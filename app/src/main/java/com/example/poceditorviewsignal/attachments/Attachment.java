package com.example.poceditorviewsignal.attachments;

import android.net.Uri;


import androidx.annotation.NonNull;

import com.example.poceditorviewsignal.blurhash.BlurHash;

/*import org.thoughtcrime.securesms.audio.AudioHash;
import org.thoughtcrime.securesms.blurhash.BlurHash;
import org.thoughtcrime.securesms.database.AttachmentDatabase;
import org.thoughtcrime.securesms.database.AttachmentDatabase.TransformProperties;
import org.thoughtcrime.securesms.stickers.StickerLocator;*/

public abstract class Attachment {

  @NonNull
  private final String  contentType;
  private final int     transferState;
  private final long    size;

  @Nullable
  private final String fileName;

  private final int    cdnNumber;

  @Nullable
  private final String  location;

  @Nullable
  private final String  key;

  @Nullable
  private final String relay;

  @Nullable
  private final byte[] digest;

  @Nullable
  private final String fastPreflightId;

  private final boolean voiceNote;
  private final boolean borderless;
  private final int     width;
  private final int     height;
  private final boolean quote;
  private final long    uploadTimestamp;

  @Nullable
  private final String caption;

  @Nullable
  private final BlurHash blurHash;


  public Attachment(@NonNull String contentType,
                    int transferState,
                    long size,
                    @Nullable String fileName,
                    int cdnNumber,
                    @Nullable String location,
                    @Nullable String key,
                    @Nullable String relay,
                    @Nullable byte[] digest,
                    @Nullable String fastPreflightId,
                    boolean voiceNote,
                    boolean borderless,
                    int width,
                    int height,
                    boolean quote,
                    long uploadTimestamp,
                    @Nullable String caption,
                    @Nullable BlurHash blurHash)
  {
    this.contentType         = contentType;
    this.transferState       = transferState;
    this.size                = size;
    this.fileName            = fileName;
    this.cdnNumber           = cdnNumber;
    this.location            = location;
    this.key                 = key;
    this.relay               = relay;
    this.digest              = digest;
    this.fastPreflightId     = fastPreflightId;
    this.voiceNote           = voiceNote;
    this.borderless          = borderless;
    this.width               = width;
    this.height              = height;
    this.quote               = quote;
    this.uploadTimestamp     = uploadTimestamp;
    this.caption             = caption;
    this.blurHash            = blurHash;
  }

  @Nullable
  public abstract Uri getUri();

  public int getTransferState() {
    return transferState;
  }

  public boolean isInProgress() {
    return false/*transferState != AttachmentDatabase.TRANSFER_PROGRESS_DONE &&
           transferState != AttachmentDatabase.TRANSFER_PROGRESS_FAILED*/;
  }

  public long getSize() {
    return size;
  }

  @Nullable
  public String getFileName() {
    return fileName;
  }

  @NonNull
  public String getContentType() {
    return contentType;
  }

  public int getCdnNumber() {
    return cdnNumber;
  }

  @Nullable
  public String getLocation() {
    return location;
  }

  @Nullable
  public String getKey() {
    return key;
  }

  @Nullable
  public String getRelay() {
    return relay;
  }

  @Nullable
  public byte[] getDigest() {
    return digest;
  }

  @Nullable
  public String getFastPreflightId() {
    return fastPreflightId;
  }

  public boolean isVoiceNote() {
    return voiceNote;
  }

  public boolean isBorderless() {
    return borderless;
  }

  public int getWidth() {
    return width;
  }

  public int getHeight() {
    return height;
  }

  public boolean isQuote() {
    return quote;
  }

  public long getUploadTimestamp() {
    return uploadTimestamp;
  }

  public @Nullable BlurHash getBlurHash() {
    return blurHash;
  }

  public @Nullable String getCaption() {
    return caption;
  }
}
