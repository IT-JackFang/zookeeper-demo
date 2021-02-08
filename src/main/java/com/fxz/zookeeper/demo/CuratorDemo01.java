package com.fxz.zookeeper.demo;

import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.retry.ExponentialBackoffRetry;
import org.apache.zookeeper.data.Stat;

/**
 * 描述：
 *
 * @author Fang
 * @date 2021-01-12 14:31:26
 */
public class CuratorDemo01 {

    public static void main(String[] args) throws Exception {

        CuratorFramework curatorFramework = CuratorFrameworkFactory
                .builder()
                .connectString("192.168.200.128")
                .sessionTimeoutMs(4000)
                .retryPolicy(new ExponentialBackoffRetry(1000, 3))
                .namespace("")
                .build();

        curatorFramework.start();
        Stat stat = new Stat();
        byte[] bytes = curatorFramework.getData().storingStatIn(stat).forPath("/jackfang");
        System.out.println(new String(bytes));
        curatorFramework.close();

    }

}
