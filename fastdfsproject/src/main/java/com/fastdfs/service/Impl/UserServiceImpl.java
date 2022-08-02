package com.fastdfs.service.Impl;

import com.alibaba.fastjson.JSONObject;
import com.fastdfs.bean.User;
import com.fastdfs.mapper.UserMapper;
import com.fastdfs.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @description:
 * @author: ly
 * @create: 2022-08-02 16:47
 * @version: 1.0
 **/
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public JSONObject register(User user) {
        JSONObject jsonObject = new JSONObject();
        if (user != null) {
            int index = userMapper.insert(user);
            if (index>0) {
                jsonObject.put("code","200");
                jsonObject.put("msg","注册成功");
            } else {
                jsonObject.put("code","350");
                jsonObject.put("msg","注册失败");
            }
        } else {
            jsonObject.put("code","500");
            jsonObject.put("msg","数据封装失败");
        }
        return jsonObject;
    }

    @Override
    public JSONObject changeInfo(User user) {
        return null;
    }

    @Override
    public JSONObject getInfoById(String id) {
        JSONObject jsonObject = new JSONObject();
        if (id != null && !"".equals(id)) {
            User user = userMapper.getInfoById(id);
            if (user != null) {
                //图片下载到
            }
        }

        return jsonObject;
    }

    @Override
    public JSONObject loginCheck(String phone, String password) {
        JSONObject jsonObject = new JSONObject();
        if (phone == null || "".equals(phone) || password == null ||"".equals(password)) {
            jsonObject.put("code","500");
            jsonObject.put("msg","数据为空");
        } else {
            User user = userMapper.getInfoByPhone(phone);
            if (user == null) {
                jsonObject.put("code","300");
                jsonObject.put("msg","该电话尚未注册");
            } else {
                if (password.equals(user.getPassword())) {
                    jsonObject.put("code","200");
                    jsonObject.put("msg","登录成功");
                } else {
                    jsonObject.put("code","310");
                    jsonObject.put("msg","密码错误");
                }
            }
        }
        return jsonObject;
    }

    @Override
    public JSONObject getInfoByPhone(String phone) {
        return null;
    }
}
