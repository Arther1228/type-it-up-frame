package com.yang.configuration;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.Properties;
import java.util.ResourceBundle;

/**
 * Created by hongcaixia on 2019/11/19.
 */
@WebServlet("/getResourceFileServlet")
public class GetResourceFileServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        /**
         * Serverlet方式
         */
        getWebResource();
        getWebINFOResource();
        getSrcResource();

        /**
         *ResourceBundle方式
         */
        getSrcResource2();

        /***
         * ClassLoader方式
         */
        getWebResourceByClassLoader();
        getWebInfoResourceByClassLoader();
        getSrcResourceByClassLoader();

    }

    /**
     * 获取web下的资源b.properties,查看文件发布到tomcat的位置为/b.properties
     */
    public void getWebResource() {
        ServletContext servletContext = this.getServletContext();
        String realPath = servletContext.getRealPath("/b.properties");
        //文件的路径是：D:\WorkSpaces\IDEAWS\tomcatdemo\out\artifacts\tomcatdemo_war_exploded\b.properties
        System.out.println("文件的路径是：" + realPath);
        Properties properties = new Properties();
        try {
            properties.load(new FileReader(realPath));
        } catch (IOException e) {
            e.printStackTrace();
        }
        Object b = properties.get("b");
        //获取到的key是：b
        System.out.println("获取到的key值是：" + b);
    }

    /**
     * 获取WEB-INF下资源c.properties
     */
    public void getWebINFOResource() {
        ServletContext servletContext = this.getServletContext();
        String realPath = servletContext.getRealPath("/WEB-INF/c.properties");
        //文件的路径是：D:\WorkSpaces\IDEAWS\tomcatdemo\out\artifacts\tomcatdemo_war_exploded\WEB-INF\c.properties
        System.out.println("文件的路径是：" + realPath);
        Properties properties = new Properties();
        try {
            properties.load(new FileReader(realPath));
        } catch (IOException e) {
            e.printStackTrace();
        }
        Object c = properties.get("c");
        //获取到的key值是：c
        System.out.println("获取到的key值是：" + c);
    }

    public void getSrcResource() {
        ServletContext servletContext = this.getServletContext();
        String realPath = servletContext.getRealPath("/WEB-INF/classes/a.properties");
        //文件的路径是：D:\WorkSpaces\IDEAWS\tomcatdemo\out\artifacts\tomcatdemo_war_exploded\WEB-INF\classes\d.properties
        System.out.println("文件的路径是：" + realPath);
        Properties properties = new Properties();
        try {
            properties.load(new FileReader(realPath));
        } catch (IOException e) {
            e.printStackTrace();
        }
        Object a = properties.get("a");
        //获取到的key值是：a
        System.out.println("获取到的key值是：" + a);
    }

    public void getSrcResource2() {
        //获取ResourceBundle对象(专门用来获取properties文件的信息,所以不用加后缀名.properties)
        ResourceBundle resourceBundle = ResourceBundle.getBundle("a");  //这个a文件在直接在java目录下面
        String a = resourceBundle.getString("a");
        System.out.println("src下资源文件：" + a);

        //获取ResourceBundle对象(专门用来获取properties文件的信息,所以不用加后缀名.properties)
        ResourceBundle resourceBundle2 = ResourceBundle.getBundle("com.yang.d");
        String d = resourceBundle2.getString("d");
        System.out.println("src下资源文件：" + d);
    }

    public void getWebResourceByClassLoader(){
        //url：file:/D:/WorkSpaces/IDEAWS/tomcatdemo/out/artifacts/tomcatdemo_war_exploded/WEB-INF/classes/
        URL url = this.getClass().getClassLoader().getResource("/");
        InputStream resourceAsStream = this.getClass().getClassLoader().getResourceAsStream("../../b.properties");

        Properties properties = new Properties();
        try {
            properties.load(resourceAsStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
        String b = properties.getProperty("b");
        System.out.println(b);

    }

    public void getWebInfoResourceByClassLoader(){
        //url：file:/D:/WorkSpaces/IDEAWS/tomcatdemo/out/artifacts/tomcatdemo_war_exploded/WEB-INF/classes/
        URL url = this.getClass().getClassLoader().getResource("/");
        InputStream resourceAsStream1 = this.getClass().getClassLoader().getResourceAsStream("../../WEB-INF/c.properties");

        Properties properties = new Properties();
        try {
            properties.load(resourceAsStream1);
        } catch (IOException e) {
            e.printStackTrace();
        }
        String c = properties.getProperty("c");
        System.out.println(c);
    }

    public void getSrcResourceByClassLoader(){
        //获取类加载器方式：
        /**
         * 1.通过类名:ClassLoader classLoader = GetResourceFileServlet.class.getClassLoader();
         * 2.通过对象：ClassLoader classLoader = this.getClass().getClassLoader();
         * 3.通过Class.forName():ClassLoader classLoader = Class.forName("GetResourceFileServlet").getClassLoader();
         */
        InputStream resourceAsStream = this.getClass().getClassLoader().getResourceAsStream("a.properties");
        InputStream resourceAsStream2 = this.getClass().getClassLoader().getResourceAsStream("com/yang/d.properties");
        Properties properties = new Properties();
        try {
            properties.load(resourceAsStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
        String a = properties.getProperty("a");
        System.out.println(a);

        try {
            properties.load(resourceAsStream2);
        } catch (IOException e) {
            e.printStackTrace();
        }
        String d = properties.getProperty("d");
        System.out.println(d);
    }

}
