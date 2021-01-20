package com.example.poceditorviewsignal.secondActivity;

import android.net.Uri;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import com.example.poceditorviewsignal.R;
import com.example.poceditorviewsignal.mediapreview.MediaPreviewFragment;
import com.example.poceditorviewsignal.mediasend.ImageEditorFragment;
import com.example.poceditorviewsignal.mediasend.MediaSendVideoFragment;

public class SecondActivity extends AppCompatActivity implements MediaPreviewFragment.Events, ImageEditorFragment.Controller, MediaSendVideoFragment.Controller {


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_second);
        String uri = getIntent().getExtras().getString("URI");
        String type = getIntent().getExtras().getString("type");
        if (type.equals("image")) {
            loadFragment(ImageEditorFragment.newInstance(Uri.parse(uri)));
        } else if (type.equals("video")) {
            loadFragment(MediaSendVideoFragment.newInstance(Uri.parse(uri),
                    15* 1024* 1024,
                    100*1024*1024));
        } else {

        }

    }

    private void loadFragment(Fragment fragment) {

        getSupportFragmentManager().beginTransaction()
                .replace(R.id.frameEditLayout, fragment)
                .addToBackStack(null)
                .commit();
    }


    @Override
    public boolean singleTapOnMedia() {
        return false;
    }

    @Override
    public void mediaNotAvailable() {

    }

    @Override
    public void onTouchEventsNeeded(boolean needed) {

    }

    @Override
    public void onVideoBeginEdit(@NonNull Uri uri) {

    }

    @Override
    public void onRequestFullScreen(boolean fullScreen, boolean hideKeyboard) {

    }

    @Override
    public void onDoneEditing() {

    }

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {

    }
}
