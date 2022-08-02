package com.fastdfs.service;

import com.alibaba.fastjson.JSONObject;
import com.fastdfs.bean.User;

/**
 * @description:
 * @author: ly
 * @create: 2022-08-02 15:20
 * @version: 1.0
 **/

public interface UserService {

    /**
     * 用户注册
     *
     * @param user
     * @return
     */
    public JSONObject register(User user);

    /**
     * 用户更新信息
     *
     * @param user
     * @return
     */
    public JSONObject changeInfo(User user);

    /**
     * 根据ID获取用户信息
     *
     * @param id
     * @return
     */
    public JSONObject getInfoById(String id);

    /**
     * 登录检测
     *
     * @param phone
     * @param password
     * @return
     */
    public JSONObject loginCheck(String phone, String password);

    /**
     * 根据电话获取用户信息
     *
     * @param phone
     * @return
     */
    public JSONObject getInfoByPhone(String phone);

}
