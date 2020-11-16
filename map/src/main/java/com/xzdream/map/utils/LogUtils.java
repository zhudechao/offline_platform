package com.xzdream.map.utils;

//
public class LogUtils {
    public String parse(String log){
        String result = "";
        String[] splits = log.split("\t");
        String domain = splits[0];
        String ip = splits[2];

        StringBuilder builder = new StringBuilder("");
        builder.append(domain).append("\t").append(ip);
        result = builder.toString();
        return result;
    }
}
