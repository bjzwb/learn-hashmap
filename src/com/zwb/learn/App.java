package com.zwb.learn;

public class App {

    private void put(String key,String value){

        System.out.printf("key:%s---hash值:%s---存储位置:%s\n",key,key.hashCode(),key.hashCode()%10);

    }

    public static void main(String[] args) {
        App map = new App();
        map.put("姓名","张文彪");
        map.put("年龄","18");
        map.put("学历","本科");
        map.put("爱好","学习");
        map.put("宠物","大黑");
    }

}
