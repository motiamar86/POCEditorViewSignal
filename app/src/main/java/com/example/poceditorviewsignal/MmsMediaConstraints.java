package com.example.poceditorviewsignal;

import android.content.Context;


final class MmsMediaConstraints extends MediaConstraints {

  private final int subscriptionId;

  private static final int MIN_IMAGE_DIMEN = 1024;

  MmsMediaConstraints(int subscriptionId) {
    this.subscriptionId = subscriptionId;
  }

  @Override
  public int getImageMaxWidth(Context context) {
    return /*Math.max(MIN_IMAGE_DIMEN, getOverriddenMmsConfig(context).getMaxImageWidth())*/1000;
  }

  @Override
  public int getImageMaxHeight(Context context) {
    return/* Math.max(MIN_IMAGE_DIMEN, getOverriddenMmsConfig(context).getMaxImageHeight())*/1000;
  }

  @Override
  public int getImageMaxSize(Context context) {
    return getMaxMessageSize(context);
  }

  @Override
  public int getGifMaxSize(Context context) {
    return getMaxMessageSize(context);
  }

  @Override
  public int getVideoMaxSize(Context context) {
    return getMaxMessageSize(context);
  }

  @Override
  public int getUncompressedVideoMaxSize(Context context) {
    return Math.max(getVideoMaxSize(context), 15 * 1024 * 1024);
  }

  @Override
  public int getAudioMaxSize(Context context) {
    return getMaxMessageSize(context);
  }

  @Override
  public int getDocumentMaxSize(Context context) {
    return getMaxMessageSize(context);
  }

  private int getMaxMessageSize(Context context) {
    return /*getOverriddenMmsConfig(context).getMaxMessageSize()*/1000;
  }

 /* private MmsConfig.Overridden getOverriddenMmsConfig(Context context) {
    MmsConfig mmsConfig = MmsConfigManager.getMmsConfig(context, subscriptionId);

    return new MmsConfig.Overridden(mmsConfig, null);
  }*/
}
