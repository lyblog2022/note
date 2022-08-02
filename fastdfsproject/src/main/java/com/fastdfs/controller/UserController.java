package com.fastdfs.controller;

import com.alibaba.fastjson.JSONObject;
import com.fastdfs.bean.User;
import com.fastdfs.service.FileService;
import com.fastdfs.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

/**
 * @description:
 * @author: ly
 * @create: 2022-08-02 15:52
 * @version: 1.0
 **/

@RequestMapping("/user")
@RestController
public class UserController {

    @Autowired
    private UserService userService;
    @Autowired
    private FileService fileService;

    @RequestMapping("/logincheck")
    public JSONObject loginCheck(String phone, String password, HttpSession session) {
        JSONObject jsonObject = userService.loginCheck(phone, password);

        session.setAttribute("uid","2");
        return jsonObject;
    }

    @RequestMapping("/register")
    public JSONObject register(MultipartFile multipartFile, User user){
        //文件上传前的名称
        String fileName = multipartFile.getOriginalFilename();
        File file = new File(fileName);
        OutputStream out = null;
        //格式转化
        try {
            //获取文件流，以文件流的方式输出到新文件
            out = new FileOutputStream(file);
            byte[] ss = multipartFile.getBytes();
            for (int i = 0; i < ss.length; i++) {
                out.write(ss[i]);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (out != null) {
                try {
                    out.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        System.out.println(user.toString());
        JSONObject jsonObject = fileService.upload(file);
        if (jsonObject != null && "200".equals(jsonObject.getString("code"))) {
            if (user != null) {
                user.setPhoto(jsonObject.getString("msg"));
                return userService.register(user);
            } else {
                jsonObject = new JSONObject();
                jsonObject.put("code","400");
                jsonObject.put("msg","数据封装失败");
            }
        } else {
            jsonObject = new JSONObject();
            jsonObject.put("code","400");
            jsonObject.put("msg","头像上传失败");
        }
        return jsonObject;
    }

    @RequestMapping("/getInfo")
    public JSONObject getInfo(HttpSession session) {
        return null;
    }

}
