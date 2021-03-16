package com.zwb.learn.map;

public class Test {
    public static void main(String[] args) {
        Map<Object, Object> map = new HashMap<>();
        map.put("姓名","张文彪");
        map.put("年龄","18");
        map.put("学历","本科");
        map.put("爱好","学习");
        map.put("宠物","大黑");

        System.out.println(map.get("姓名"));
        System.out.println(map.get("年龄"));
        System.out.println(map.get("学历"));
        System.out.println(map.get("爱好"));
        System.out.println(map.get("宠物"));
    }
}
