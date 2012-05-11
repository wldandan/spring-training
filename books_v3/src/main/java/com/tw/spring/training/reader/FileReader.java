package com.tw.spring.training.reader;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public class FileReader extends AbstractReader {
    private String fileName;

    public FileReader(String fileName)
    {
        this.fileName = fileName;
    }

    public InputStream read() throws IOException {
        return new FileInputStream(new File(fileName));
    }

  public void setFileName(String fileName) {
      this.fileName = fileName;
  }

  public String getFileName() {
      return fileName;
  }
}
