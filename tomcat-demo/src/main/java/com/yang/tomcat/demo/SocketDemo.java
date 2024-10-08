package com.yang.tomcat.demo;

import java.io.*;
import java.net.Socket;

/**
 * @author yangliangchuang 2023/8/5 18:37
 */
public class SocketDemo {

    public static void main(String[] args) throws IOException, InterruptedException {

        Socket socket = new Socket("127.0.0.1", 8080);
        OutputStream os = socket.getOutputStream();
        boolean autoflush = true;
        PrintWriter out = new PrintWriter(
                socket.getOutputStream(), autoflush);
        BufferedReader in = new BufferedReader(
                new InputStreamReader(socket.getInputStream()));
        // send an HTTP request to the web server
        out.println("GET /index.jsp HTTP/1.1");
        out.println("Host: localhost:8080");
        out.println("Connection: Close");
        out.println();
        // read the response
        boolean loop = true;
        StringBuffer sb = new StringBuffer(8096);
        while (loop) {
            if (in.ready()) {
                int i = 0;
                while (i != -1) {
                    i = in.read();
                    sb.append((char) i);
                }
                loop = false;
            }
            Thread.sleep(5000);
        }
        // display the response to the out console
        System.out.println(sb.toString());
        socket.close();
    }
}
