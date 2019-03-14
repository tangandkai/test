package com.weima.file;

import com.csvreader.CsvWriter;

import java.io.*;
import java.nio.charset.Charset;
import java.util.ArrayList;

public class FileObject {

    public FileObject(){}

    public BufferedReader readCsv(String path){
        File file = new File(path);
        file.setReadable(true);

        BufferedReader br = null;
        try {
            br = new BufferedReader(new FileReader(file));

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return br;
//        finally {
//            try {
//                br.close();
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//        }

//        String line = "";
//        String everyLine = "";
//        ArrayList<String> allString = new ArrayList<>();
//        try {
//            while ((line = br.readLine()) != null) // 读取到的内容给line变量
//            {
//                everyLine = line;
//                System.out.println(everyLine);
//                allString.add(everyLine);
//            }
//            System.out.println("csv表格中所有行数：" + allString.size());
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        return allString;
    }

    public void writeCSV(String path,ArrayList writearraylist) {
        String csvFilePath = path;
        try {

            // 创建CSV写对象 例如:CsvWriter(文件路径，分隔符，编码格式);
            CsvWriter csvWriter = new CsvWriter(csvFilePath, ',', Charset.forName("GBK"));
            // 写内容
            String[] headers = {"FileName","FileSize","FileMD5"};
            csvWriter.writeRecord(headers);
            for(int i=0;i<writearraylist.size();i++){
                String[] writeLine= (String[]) writearraylist.get(i);//.split(",")
                System.out.println(writeLine);
                csvWriter.writeRecord(writeLine);
            }
            csvWriter.close();
            System.out.println("--------CSV文件已经写入--------");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


//    public static void main(String[] args) throws IOException{
//        String path = "C:\\query-hive-8549.csv";
//        String line = "";
//        FileObject file = new FileObject();
//        BufferedReader content = file.readCsv(path);
//        System.out.println(content);
//        while ((line=content.readLine())!=null){
//            System.out.println(line);
//        }
//        content.close();
//    }
}
