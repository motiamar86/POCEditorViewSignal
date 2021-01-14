package com.example.poceditorviewsignal.mediasend;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Point;
import android.net.Uri;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.WorkerThread;

/*import org.signal.core.util.StreamUtil;
import org.signal.core.util.logging.Log;
import org.thoughtcrime.securesms.imageeditor.model.EditorModel;
import org.thoughtcrime.securesms.providers.BlobProvider;
import org.thoughtcrime.securesms.util.MediaUtil;*/
import com.example.poceditorviewsignal.MediaUtil;
import com.example.poceditorviewsignal.imageeditor.model.EditorModel;
import com.example.poceditorviewsignal.providers.BlobProvider;

import org.whispersystems.libsignal.util.guava.Optional;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

public final class ImageEditorModelRenderMediaTransform implements MediaTransform {

  private static final String TAG = "ImageEditorModelRenderMediaTransform";

  @NonNull  private final EditorModel modelToRender;
  @Nullable private final Point       size;

  ImageEditorModelRenderMediaTransform(@NonNull EditorModel modelToRender) {
    this(modelToRender, null);
  }

  ImageEditorModelRenderMediaTransform(@NonNull EditorModel modelToRender, @Nullable Point size) {
    this.modelToRender = modelToRender;
    this.size          = size;
  }

  @WorkerThread
  @Override
  public @NonNull Media transform(@NonNull Context context, @NonNull Media media) {
    ByteArrayOutputStream outputStream = new ByteArrayOutputStream();

    Bitmap bitmap = modelToRender.render(context, size);
    try {
      bitmap.compress(Bitmap.CompressFormat.JPEG, 80, outputStream);

      Uri uri = BlobProvider.getInstance()
                            .forData(outputStream.toByteArray())
                            .withMimeType(MediaUtil.IMAGE_JPEG)
                            .createForSingleSessionOnDisk(context);

      return new Media(uri, MediaUtil.IMAGE_JPEG, media.getDate(), bitmap.getWidth(), bitmap.getHeight(), outputStream.size(), 0, false, media.getBucketId(), media.getCaption());
    } catch (IOException e) {
      return media;
    } finally {
      bitmap.recycle();
      //TODO we need this fun?
      //StreamUtil.close(outputStream);
    }
  }
}
