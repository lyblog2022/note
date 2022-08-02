package com.fastdfs.service;

import com.alibaba.fastjson.JSONObject;

import java.io.File;

/**
 * @description:
 * @author: ly
 * @create: 2022-08-02 15:22
 * @version: 1.0
 **/
public interface FileService {

    /**
     * 图片上传
     * @param file
     * @return
     */
    public JSONObject upload(File file);

    /**
     * 图片下载
     * @param photoId
     * @return
     */
    public JSONObject down(String photoId);

}
