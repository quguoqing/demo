package com.example.demo.bio;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.Set;

/**
 * @author: chunmu
 * @Date: 2020/6/2 22:59
 * @Description:
 */
public class TimeClientHandler implements Runnable {

    private String host;

    private int port;

    private Selector selector;

    private SocketChannel socketChannel;

    private volatile boolean isStop;

    public TimeClientHandler(String host, int port){
        this.host = host;
        this.port = port;
        try {
            selector = Selector.open();
            socketChannel = SocketChannel.open();
            socketChannel.configureBlocking(false);
            System.out.println("NioTimeClient start host:" + host + " port:" + port);
        } catch (IOException e) {
            e.printStackTrace();
            System.exit(1);
        }
    }

    private void doConnect() throws IOException {
        if(socketChannel.connect(new InetSocketAddress(host, port))){
            //success connect
            socketChannel.register(selector, SelectionKey.OP_READ);
            doRequest("QUGUOQING");
        }else {
            //not yet success connect
            socketChannel.register(selector, SelectionKey.OP_CONNECT);
        }
    }

    private void doRequest(String request) throws IOException {
        byte[] req = request.getBytes("UTF-8");
        ByteBuffer writeBuffer = ByteBuffer.allocate(req.length);
        writeBuffer.put(req);
        writeBuffer.flip();
        socketChannel.write(writeBuffer);
        if(!writeBuffer.hasRemaining()){
            System.out.println("Send order 2 server succeed.");
        }
    }

    @Override
    public void run() {
        try{
            doConnect();
        }catch (Exception e){
            e.printStackTrace();
            System.exit(1);
        }
        while (!isStop){
            try {
                selector.select(1000);
                Set<SelectionKey> selectionKeySet = selector.selectedKeys();
                Iterator<SelectionKey> it = selectionKeySet.iterator();
                SelectionKey key = null;
                while (it.hasNext()){
                    key = it.next();
                    it.remove();
                    try{
                        handleInput(key);
                    }catch (Exception e){
                        e.printStackTrace();
                        if(null != key){
                            key.cancel();
                            if(null != key.channel()){
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

        if(null != selector){
            try {
                selector.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

    private void handleInput(SelectionKey key) throws IOException {
        if(key.isValid()){
            SocketChannel sc = (SocketChannel) key.channel();
            if(key.isConnectable()){
                if(sc.finishConnect()){
                    //success connet
                    sc.register(selector, SelectionKey.OP_READ);
                    doRequest("QUGUOQING");
                }else {
                    // failed connect
                    System.exit(1);
                }
            }else if(key.isReadable()){
                //可读，说明有结果返回了
                ByteBuffer readBuffer = ByteBuffer.allocate(1024);
                int size = sc.read(readBuffer);
                if(size > 0){
                    readBuffer.flip();
                    byte[] bytes = new byte[readBuffer.remaining()];
                    readBuffer.get(bytes);
                    String result = new String(bytes, "utf-8");
                    System.out.println("Now is:" + result);
                    this.isStop = true;
                }else if(size < 0){
                    key.cancel();
                    sc.close();
                }else {
                    //ignore
                }
            }
        }
    }
}
