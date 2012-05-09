package com.tw.spring.training.factory;

import com.tw.spring.training.reader.FileReader;
import com.tw.spring.training.reader.Reader;
import com.tw.spring.training.reader.UrlReader;

/**
 * Created with IntelliJ IDEA.
 * User: twer
 * Date: 5/8/12
 * Time: 7:48 PM
 * To change this template use File | Settings | File Templates.
 */
public class Factory {
    public Reader getReader(String param){
        Reader reader = null;
        if (param.indexOf("File") > -1){
            String file = param.split(":")[1];
            reader = new FileReader(file);
        }
        else if (param.indexOf("Url") > -1){
            String url = param.substring(param.indexOf(":")+1);
            reader = new UrlReader(url);
        }
        return reader;
    }
}
