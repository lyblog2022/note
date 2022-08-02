package com.fastdfs;

import com.fastdfs.Util.FastDFSClient;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.UUID;

@SpringBootTest
class FastdfsprojectApplicationTests {

    @Test
    void contextLoads() {
        //[group1, M00/00/00/wKjVjmLoyr6AWpdcAAC3rg7FOOc848.png]
        //[group1, M00/00/00/wKjVjmLoysyAY3VNAAC3rg7FOOc399.png]
        //[group1, M00/00/00/wKjVjmLoytqAA7YxAAC3rg7FOOc093.png]
        try {
            File file = new File("E:\\note\\source\\_posts\\algorithm\\tree\\tree\\tree1.png");
            InputStream is = new FileInputStream(file);
            String fileName = UUID.randomUUID().toString()+".png";
            String[] result = FastDFSClient.uploadFile(is, fileName);
            System.out.println(result[0]+"/"+result[1]);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

}
