package com.zookeeperclient;

import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;
import org.apache.zookeeper.ZooKeeper;

import java.util.List;

/**
 * @Author: liuyong
 * @Date: 2022 - 06 - 07 - 21:56
 * @Description: com.zookeeperclient
 * @Version: 1.0
 */
public class ReceiveContent {
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

            //从zookeeper中获取内容
            //2.1获取节点
            List<String> list = zooKeeper.getChildren("/demo",false);
            System.out.println(list);

            //获取内容
            for(String child:list){
                byte[] result = zooKeeper.getData("/demo/"+child,false,null);
                System.out.println(new String(result));
            }


        } catch (Exception e){
            e.printStackTrace();
        }

    }
}
