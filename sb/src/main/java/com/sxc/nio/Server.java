package com.sxc.nio;

import java.io.IOException;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.Set;

public class Server {

    public static void main(String[] args) throws IOException {
        int port = 8080;
        new Thread(new Runnable() {
            private ServerSocketChannel serverSocketChannel = null;
            private Selector selector = null;

            {
                serverSocketChannel = ServerSocketChannel.open();
                serverSocketChannel.configureBlocking(false);
                serverSocketChannel.socket().bind(new java.net.InetSocketAddress(8080), 1024);
                selector = Selector.open();
                serverSocketChannel.register(selector, java.nio.channels.SelectionKey.OP_ACCEPT);
            }

            @Override
            public void run() {
                try {
                    while (true) {

                        selector.select();
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
                if (selectionKey.isAcceptable()) {
                    ServerSocketChannel server = (ServerSocketChannel) selectionKey.channel();
                    java.nio.channels.SocketChannel clien = server.accept();
                    clien.configureBlocking(false);
                    clien.register(selector, java.nio.channels.SelectionKey.OP_READ);
                }
                if (selectionKey.isReadable()) {
                    java.nio.channels.SocketChannel client = (SocketChannel) selectionKey.channel();
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
