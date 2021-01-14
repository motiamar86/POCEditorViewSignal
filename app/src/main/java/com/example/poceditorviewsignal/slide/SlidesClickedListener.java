package com.example.poceditorviewsignal.slide;

import android.view.View;

import com.example.poceditorviewsignal.mms.Slide;

import java.util.List;

public interface SlidesClickedListener {
  void onClick(View v, List<Slide> slides);
}
