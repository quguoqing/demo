package com.example.demo.bio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Date;
import java.util.Iterator;
import java.util.Set;

import org.apache.commons.lang.StringUtils;


/**
 * @author: chunmu
 * @Date: 2020/6/2 22:20
 * @Description:
 */
public class MultiplexerTimerServer implements Runnable {

    private Selector selector;

    private ServerSocketChannel serverSocketChannel;

    private volatile boolean isStop;

    public MultiplexerTimerServer(int port){
        try{
            selector = Selector.open();
            serverSocketChannel = ServerSocketChannel.open();
            serverSocketChannel.configureBlocking(false);
            serverSocketChannel.socket().bind(new InetSocketAddress(port), 1024);
            serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);
            System.out.println("The time server is start in port:" + port);
        }catch (IOException e){
            e.printStackTrace();
            System.exit(1);
        }
    }

    @Override
    public void run() {
        while (!isStop){
            try {
                if(!selector.isOpen()){
                    System.out.println("selector is closed");
                    System.exit(1);
                }
                selector.select(1000);
                Set<SelectionKey> selectionKeys = selector.selectedKeys();
                SelectionKey key = null;
                Iterator<SelectionKey> it = selectionKeys.iterator();
                while (it.hasNext()){
                    key = it.next();
                    it.remove();
                    try{
                        //这个是单线程模型的reactor模型，如果要改为多线程模型，handleInput放到线程池执行
                        handleInput(key);
                    }catch (Exception e){
                        if(null != key){
                            key.cancel();
                            if(key.channel() != null){
                                key.channel().close();
                            }
                        }
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
                System.exit(1);
            }
        }
    }

    private void handleInput(SelectionKey key) throws IOException {
        if(key.isValid()){
            if(key.isAcceptable()){
                //连接事件
                //表示ServerSocket的accept
                ServerSocketChannel serverSocketChannel = (ServerSocketChannel)key.channel();
                SocketChannel sc = serverSocketChannel.accept();
                //这里可以做成多线程多rector模式。主线程拿到SocketChannel后，把该channel注册在另外一个selector上。
                sc.configureBlocking(false);
                sc.register(selector, SelectionKey.OP_READ);
            } else if(key.isReadable()){
                //可读事件
                //客户端channel可写。这里也可以使用多worker线程模型，某一个selector监听到可读事件后，唤醒一个worker去read，然后执行响应的handler。
                SocketChannel sc = (SocketChannel)key.channel();
                ByteBuffer readBuffer = ByteBuffer.allocate(1024);
                int size = sc.read(readBuffer);
                if(size > 0){
                    readBuffer.flip();
                    byte[] bytes = new byte[readBuffer.remaining()];
                    readBuffer.get(bytes);
                    String body = new String(bytes, "utf-8");
                    System.out.println("The time server receive order:" + body);
                    String currentTime = "QUGUOQING".equalsIgnoreCase(body) ? new Date().toString() : "bad order";
                    doWrite(sc, currentTime);
                }else if(size < 0){
                    //对端channel closed
                    key.cancel();
                    sc.close();
                }else {
                    // read 0，ignore
                }
            }
        }
    }

    private void doWrite(SocketChannel sc, String response) throws IOException {
        if(StringUtils.isNotBlank(response)){
            byte[] bytes = response.getBytes("UTF-8");
            ByteBuffer writeBuffer = ByteBuffer.allocate(1024);
            writeBuffer.put(bytes);
            writeBuffer.flip();
            sc.write(writeBuffer);
        }
    }

    public void stop(){
        isStop = true;
    }
}
