package com.consumer.service.Impl;

import com.User;
import com.consumer.service.PageService;
import com.service.MyService;
import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;
import org.apache.zookeeper.ZooKeeper;
import org.springframework.stereotype.Service;

import java.rmi.Naming;
import java.util.List;

/**
 * @Author: liuyong
 * @Date: 2022 - 06 - 08 - 21:37
 * @Description: com.consumer.service.Impl
 * @Version: 1.0
 */
@Service
public class PageServiceImpl implements PageService {
    @Override
    public List<User> show() {
        try {
            ZooKeeper zooKeeper = new ZooKeeper("192.168.253.132:2181", 10000, new Watcher() {
                @Override
                public void process(WatchedEvent watchedEvent) {
                    System.out.println("链接成功");
                }
            });
            byte[] bytes = zooKeeper.getData("/rpc/provider",false,null);
            MyService myService = (MyService) Naming.lookup(new String(bytes));

            return myService.findAll();
        } catch (Exception e){
            e.printStackTrace();
            return null;
        }


    }
}
