package com.yang.springboot.demo.configuration.PropertiesLoaderUtils;

import org.junit.Test;
import org.springframework.core.io.support.PropertiesLoaderUtils;

import java.io.IOException;
import java.util.Properties;

/**
 * @author yangliangchuang 2022/11/20 13:30
 */
public class PropertiesLoaderUtilsTest {

    /**
     * Spring 提供的 PropertiesLoaderUtils 允许您直接通过基于类路径的文件地址加载属性资源
     * 最大的好处就是：实时加载配置文件，修改后立即生效，不必重启
     */
    @Test
    public  void springUtil(){
        Properties props = new Properties();
        while(true){
            try {
                props= PropertiesLoaderUtils.loadAllProperties("message.properties");
                for(Object key:props.keySet()){
                    System.out.print(key+":");
                    System.out.println(props.get(key));
                }
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }

            try {Thread.sleep(5000);} catch (InterruptedException e) {e.printStackTrace();}
        }
    }
}
