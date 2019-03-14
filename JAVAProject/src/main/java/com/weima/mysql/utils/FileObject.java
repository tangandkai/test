package com.weima.mysql.utils;


import java.io.*;
import java.nio.charset.Charset;
import java.text.MessageFormat;
import java.util.ArrayList;

public class FileObject {

    public static BufferedReader readFile(String path){
        File file = new File(path);
        file.setReadable(true);
        BufferedReader br = null;
        try {
            br = new BufferedReader(new FileReader(file));

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return br;
    }

    /**
     * 读取文件
     * @param path
     * @return
     * @throws IOException
     */
    public static String getSqlTemplate(String path) throws IOException {
        BufferedReader content = readFile(path);
        System.out.println(content);
        String line = "";
        StringBuffer buffer = new StringBuffer();
//        StringBuilder builder = new StringBuilder();
        while ((line=content.readLine())!=null){
            buffer.append(line).append("\n");
//            builder.append(line).append("\n");
        }
        content.close();
        return buffer.toString();
//        return builder.toString();
    }
//    public static void main(String[] args) throws IOException{
//        System.out.println(getContent("C:\\HiveQl\\test.sql"));
//    }
}
