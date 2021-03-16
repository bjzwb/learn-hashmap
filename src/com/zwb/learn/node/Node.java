package com.zwb.learn.node;

import java.util.HashMap;
import java.util.LinkedList;

//单向链表
public class Node {
//    LinkedList 双向链表、
//    HashMap 单向链表

    private Node next;
    private Object data;

    private Node(Object data){
        this.data = data;
    }

    public static void main(String[] args) {

        Node head = new Node("张文彪");
        head.next = new Node("杜卓桅");
        head.next.next = new Node("杜卓笑");

        System.out.println(head.data);
        System.out.println(head.next.data);
        System.out.println(head.next.next.data);

    }
}
