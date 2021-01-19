package com.example.poceditorviewsignal.secondActivity;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.net.Uri;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import com.example.poceditorviewsignal.R;
import com.example.poceditorviewsignal.mediapreview.ImageMediaPreviewFragment;
import com.example.poceditorviewsignal.mediapreview.MediaPreviewFragment;
import com.example.poceditorviewsignal.mediasend.ImageEditorFragment;
import com.example.poceditorviewsignal.mediasend.MediaSendFragment;

public class SecondActivity extends AppCompatActivity implements  MediaPreviewFragment.Events, ImageEditorFragment.Controller {


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_second);

        loadFragment(ImageEditorFragment.newInstance(Uri.parse("content://media/external/images/media/4910")));

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
    public void onRequestFullScreen(boolean fullScreen, boolean hideKeyboard) {

    }

    @Override
    public void onDoneEditing() {

    }
}
