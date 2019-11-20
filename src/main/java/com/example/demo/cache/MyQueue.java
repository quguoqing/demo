package com.example.demo.cache;

import java.util.concurrent.atomic.AtomicReference;

/**
 * @author: chunmu
 * @Date: 2019/11/19 21:39
 * @Description:
 */
public class MyQueue {
    private AtomicReference<Node> head = new AtomicReference();

    private AtomicReference<Node> tail = new AtomicReference();

    /**
     * 同步的话，可以使用synchronized，也可以使用lock，也可以cas。高并发使用lock
     */
    public void add(Object o) throws InterruptedException{
        //第一个节点
        if (null == head.get() || null == tail.get()) {
            Node newNode = new Node(o);
            safeCas(head,null, newNode);
            safeCas(tail, null, newNode);
            return;
        }
        //非第一个节点，直接插入到head
        Node old = head.get();
        Node newNode = new Node(o);
        newNode.next = old;
        safeCas(head,old, newNode);
        return;
    }

    public Object poll() throws InterruptedException{
        //只有一个节点
        if (head == tail) {
            Object o = head.get().object;
            safeCas(head, head.get(), null);
            safeCas(tail, tail.get(), null);
            return o;
        }
        //从头遍历，一致保存着遍历的时候：倒数第一个，和倒数node
        Node current = head.get();
        Node follow = head.get();

        for (Node node = head.get(); null != node; node = node.next) {
            if (node == head.get()) {
                continue;
            }
            follow = current;
            current = node;
        }
        //取出最后一个
        Object old = current.object;
        follow.next = null;
        safeCas(tail, tail.get(), follow);
        return old;
    }

    private void safeCas(AtomicReference<Node> current, Node old, Node newValue) throws InterruptedException{
        for(;;){
            if(current.compareAndSet(old, newValue)){
                break;
            }
            Thread.sleep(10L);
        }
    }

    static class Node<E> {
        Object object;

        Node next;

        Node(Object o) { object = o; }
    }
}
