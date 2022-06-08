package com;

import com.service.Impl.MyServiceImpl;
import com.service.MyService;
import org.apache.zookeeper.*;

import java.nio.charset.StandardCharsets;
import java.rmi.Naming;
import java.rmi.Remote;
import java.rmi.registry.LocateRegistry;

/**
 * @Author: liuyong
 * @Date: 2022 - 06 - 08 - 21:15
 * @Description: com
 * @Version: 1.0
 */
public class ProviderRun {
    public static void main(String[] args) {
        try {
            MyService service = new MyServiceImpl();
            LocateRegistry.createRegistry(8989);
            String url = "rmi://localhost:8989/myService";
            Naming.bind(url, service);
            System.out.println("MRI服务启动成功！");

            //创建zookeeper并发布信息
            ZooKeeper zooKeeper = new ZooKeeper("192.168.253.132:2181", 10000, new Watcher() {
                @Override
                public void process(WatchedEvent watchedEvent) {
                    System.out.println("获取链接");
                }
            });

            zooKeeper.create("/rpc/provider",url.getBytes(), ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT);
            System.out.println("注册成功");



        } catch (Exception e){

        }
    }
}
