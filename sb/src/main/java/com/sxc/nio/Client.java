package com.sxc.nio;

import java.io.IOException;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.Set;

public class Client {

    public static void main(String[] args) throws IOException {
        int port = 8080;
        new Thread(new Runnable() {
            private SocketChannel socketChannel = null;
            private Selector selector = null;

            {
                socketChannel = SocketChannel.open();
                socketChannel.configureBlocking(false);
            
                selector = Selector.open();
              
            }

            @Override
            public void run() {
                try {
                    boolean connect=socketChannel.connect(new java.net.InetSocketAddress("127.0.0.1",8080));
                    
                    if (connect) {
                        socketChannel.register(selector ,SelectionKey.OP_READ);
                        java.nio.ByteBuffer buffer=java.nio.ByteBuffer.allocate(1024);
                        buffer.put("asdasd".getBytes());
                        buffer.flip();
                        socketChannel.write(buffer);
                    }else{
                        socketChannel.register(selector , SelectionKey.OP_CONNECT);
                    }
                    
                    
                    
                    while (true) {

                        selector.select(1000);
                        Set<SelectionKey> selectionKeys = selector.selectedKeys();

                        Iterator<SelectionKey> iterator = selectionKeys.iterator();
                        SelectionKey selectionKey = null;
                        while (iterator.hasNext()) {
                            selectionKey = iterator.next();
                            iterator.remove();

                            doHandle(selectionKey);

                        }

                    }
                } catch (Exception e) {
                    // TODO: handle exception
                }

            }

            private void doHandle(SelectionKey selectionKey) throws IOException {
                if (!selectionKey.isValid())
                    return;
                java.nio.channels.SocketChannel client = (SocketChannel) selectionKey.channel();
                if (selectionKey.isConnectable()) {
                    if (client.finishConnect()) {
                       // client.register(selector, SelectionKey.OP_READ);
                        java.nio.ByteBuffer buffer=java.nio.ByteBuffer.allocate(1024);
                        buffer.put("asdasd".getBytes());
                        buffer.flip();
                        client.write(buffer);
                    }
                }
                if (selectionKey.isReadable()) {
                    java.nio.ByteBuffer reveice = java.nio.ByteBuffer.allocate(1024);
                    int count = client.read(reveice);
                    if (count > 0) {
                        reveice.flip();
                        byte[] bytes = new byte[reveice.remaining()];
                        reveice.get(bytes);
                        System.out.println(new String(bytes));
                    }

                }

            }

        }).start();
    }
}
