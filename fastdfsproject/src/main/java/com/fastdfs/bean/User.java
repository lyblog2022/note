package com.fastdfs.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @description:
 * @author: ly
 * @create: 2022-08-02 15:02
 * @version: 1.0
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {

    private Integer id;
    private String nickName;
    private String trueName;
    private String sex;
    private String birthday;
    private String phone;
    private String password;
    private String photo;

}
