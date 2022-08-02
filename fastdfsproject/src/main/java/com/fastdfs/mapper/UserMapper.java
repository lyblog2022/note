package com.fastdfs.mapper;

import com.fastdfs.bean.User;
import org.apache.ibatis.annotations.Mapper;

/**
 * @description:
 * @author: ly
 * @create: 2022-08-02 15:05
 * @version: 1.0
 **/
@Mapper
public interface UserMapper {

    /**
     * 用户注册
     *
     * @param user
     * @return
     */
    public Integer insert(User user);

    /**
     * 更新用户信息
     *
     * @param user
     * @return
     */
    public Integer update(User user);

    /**
     * 根据ID获取用户信息
     *
     * @param id
     * @return
     */
    public User getInfoById(String id);

    /**
     * 根据电话获取用户信息
     *
     * @param phone
     * @return
     */
    public User getInfoByPhone(String phone);

}
