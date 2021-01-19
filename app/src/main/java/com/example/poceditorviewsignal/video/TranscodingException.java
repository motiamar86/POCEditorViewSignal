package com.example.poceditorviewsignal.video;

final class TranscodingException extends Exception {

  TranscodingException(String message) {
    super(message);
  }

  TranscodingException(Throwable inner) {
    super(inner);
  }
}
