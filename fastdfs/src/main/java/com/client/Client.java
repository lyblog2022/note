package com.client;

import com.util.FastDFSClient;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.UUID;

/**
 * Client
 *
 * @author liuyong
 * @version 1.0
 * @description com.client
 * @date 2022/6/19 19:52
 */
public class Client {

    public static void main(String[] args) {
        try {
            File file = new File("E:\\note\\source\\_posts\\software\\FastDFS\\fastdfs.png");
            InputStream is = new FileInputStream(file);
            String fileName = UUID.randomUUID().toString()+".png";
            String[] result = FastDFSClient.uploadFile(is, fileName);
            System.out.println(Arrays.toString(result));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
