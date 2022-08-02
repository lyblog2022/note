package com.fastdfs.service.Impl;

import com.alibaba.fastjson.JSONObject;
import com.fastdfs.Util.FastDFSClient;
import com.fastdfs.service.FileService;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.UUID;

/**
 * @description:
 * @author: ly
 * @create: 2022-08-02 20:27
 * @version: 1.0
 **/
@Service
public class FileServiceImpl implements FileService {

    @Override
    public JSONObject upload(File file) {
        JSONObject jsonObject = new JSONObject();
        try {
            //          File file = new File(path);
            InputStream is = new FileInputStream(file);
            String fileName = UUID.randomUUID().toString() + ".png";
            String[] result = FastDFSClient.uploadFile(is, fileName);
            System.out.println(result[0] + "/" + result[1]);
            String resultText = result[0] + "/" + result[1];
            if (resultText != null && !"".equals(resultText)) {
                jsonObject.put("code", "200");
                jsonObject.put("msg", resultText);
            } else {
                jsonObject.put("code", "300");
                jsonObject.put("msg", "failure");
            }
            if (file.delete()) {
                System.out.println("删除成功");
            } else {
                System.out.println("删除失败");
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            jsonObject.put("code", "400");
            jsonObject.put("msg", e.toString());
        }
        return jsonObject;
    }

    @Override
    public JSONObject down(String photoId) {
        return null;
    }
}
