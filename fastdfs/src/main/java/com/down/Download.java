package com.down;

import com.util.FastDFSClient;

import java.io.*;
import java.util.Arrays;
import java.util.UUID;

/**
 * Download
 *
 * @author liuyong
 * @version 1.0
 * @description com.down
 * @date 2022/6/19 20:09
 */
public class Download {
    public static void main(String[] args) {
        try {
//            File file = new File("E:\\note\\source\\_posts\\software\\FastDFS\\fastdfs.png");
//            InputStream is = new FileInputStream(file);
//            String fileName = UUID.randomUUID().toString()+".png";
//            String[] result = FastDFSClient.uploadFile(is, fileName);
//            System.out.println(Arrays.toString(result));
            InputStream is = FastDFSClient.downloadFile("group1", "M00/00/00/wKjVhWKvD_iAZ0rRAACDGmk1a_U227.png");
            OutputStream os = new FileOutputStream(new File("E:/jqk.png"));
            int index = 0 ;
            while((index = is.read())!=-1){
                os.write(index);
            }
            os.flush();
            os.close();
            is.close();


        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
