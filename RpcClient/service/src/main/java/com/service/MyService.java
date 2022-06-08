package com.service;

import com.User;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

/**
 * @Author: liuyong
 * @Date: 2022 - 06 - 08 - 21:06
 * @Description: com
 * @Version: 1.0
 */
public interface MyService extends Remote {

    public List<User> findAll() throws RemoteException;
}
