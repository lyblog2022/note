package com.service.Impl;

import com.User;
import com.service.MyService;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author: liuyong
 * @Date: 2022 - 06 - 08 - 21:10
 * @Description: com.service.Impl
 * @Version: 1.0
 */
public class MyServiceImpl extends UnicastRemoteObject implements MyService {
    public MyServiceImpl() throws RemoteException {

    }

    @Override
    public List<User> findAll() throws RemoteException {
        List<User> personList = new ArrayList<User>();
        personList.add(new User(1,"张三丰"));
        personList.add(new User(2 , "张无忌"));

        return personList;
    }
}
