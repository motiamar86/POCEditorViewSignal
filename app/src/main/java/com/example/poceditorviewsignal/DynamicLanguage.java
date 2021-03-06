package com.example.poceditorviewsignal;

import android.app.Activity;
import android.app.Service;
import android.content.Context;
import android.content.res.Configuration;

import java.util.Locale;

/**
 */
@Deprecated
public class DynamicLanguage {

  public void onCreate(Activity activity) {
  }

  public void onResume(Activity activity) {
  }

  public void updateServiceLocale(Service service) {
    setContextLocale(service, getSelectedLocale(service));
  }

  public Locale getCurrentLocale() {
    return Locale.getDefault();
  }

  static int getLayoutDirection(Context context) {
    Configuration configuration = context.getResources().getConfiguration();
    return configuration.getLayoutDirection();
  }

  private static void setContextLocale(Context context, Locale selectedLocale) {
    Configuration configuration = context.getResources().getConfiguration();

    if (!configuration.locale.equals(selectedLocale)) {
      configuration.setLocale(selectedLocale);
      context.getResources().updateConfiguration(configuration,
                                                 context.getResources().getDisplayMetrics());
    }
  }

  private static Locale getSelectedLocale(Context context) {
    Locale locale = LanguageString.parseLocale("zz");
    if (locale == null) {
      return Locale.getDefault();
    } else {
      return locale;
    }
  }
}
