package com.zookeeperclient;

import org.apache.zookeeper.*;

import java.nio.charset.StandardCharsets;

/**
 * @Author: liuyong
 * @Date: 2022 - 06 - 07 - 21:26
 * @Description: com.zookeeperclient
 * @Version: 1.0
 */
public class SendContent {

    public static void main(String[] args) {

        try {
            /**
             * 创建zookeeper对象
             * 参数1：zookeeper IP+端口
             * 参数2：访问超时设置
             * 参数3：链接成功后，编写成功信息
             */
            String ip = "192.168.253.132:2181";
            ZooKeeper zooKeeper = new ZooKeeper(ip, 10000, new Watcher() {
                @Override
                public void process(WatchedEvent watchedEvent) {
                    System.out.println("获取链接");
                }
            });

            /**
             * 向zookeeper发送内容
             * 参数1：发送的文件
             * 参数2：发送的内容
             * 参数3：权限
             * 参数4：内容的模式
             */
            String content  = zooKeeper.create("/demo/rmi-adress","rmi:localhost:8080/demoService".getBytes(), ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT_SEQUENTIAL);
            System.out.println("content="+content);
        } catch (Exception e){
            e.printStackTrace();
        }

    }

}
