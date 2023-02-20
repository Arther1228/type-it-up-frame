package com.yang.springboot.demo.configuration.classPathResource;

import org.springframework.core.io.ClassPathResource;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Properties;

/**
 * @author yangliangchuang 2022/11/20 15:23
 */
public class ClassPathResourceTest {

    public static void main(String[] args) throws IOException {
        ClassPathResource classpathResource = new ClassPathResource("e.properties");
        InputStream inputStream = classpathResource.getInputStream();
        Properties properties = new Properties();

        try {
            InputStreamReader isr = new InputStreamReader(inputStream, "utf8");
            properties.load(isr);

            // 获取key对应的value值
            String property = properties.getProperty("e");
            System.out.println(property);

            inputStream.close();
            isr.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
