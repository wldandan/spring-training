package com.tw.spring.training.reader;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;

public class UrlReader extends AbstractReader {
  private String url;

    public UrlReader(String url) {
      this.url = url;
  }

  private URLConnection getURLConnection() throws IOException {
    URLConnection connection = null;
    return new URL(url).openConnection();
  }


  @Override
  public InputStream read() throws IOException {
      return getURLConnection().getInputStream();
    }
}
