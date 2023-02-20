package com.yang.springboot.demo.linux;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.io.File;
import java.io.IOException;

/**
 * @author admin
 * @desc:Linux系统测试命令：java -jar java-demo-project-0.0.1-SNAPSHOT.jar --path=/home/server/test/1
 */
@Component
@Slf4j
public class PathTest {

    @Value("${path}")
    private String path;

    public void test() {

        System.out.println("========test方法========");
        String testPath = path;
        System.out.println("testPah: " + testPath);
        try {
            boolean mkdir = mkdir(new File(testPath));
            if (mkdir) {
                System.out.println("目录: " + testPath + ", 新建/授权成功。");
            } else {
                System.out.println("目录: " + testPath + ", 新建失败。");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 新建目录并且授权
     * @param dir  示例：/mnt/motorvehicle_2/sckk/2022/03/17/34010518001199003069/
     * @return
     * @throws IOException
     */
    public static boolean mkdir(File dir) throws IOException {
        boolean resultFlag;
        if (!dir.exists()) {
            File parentFile = dir.getParentFile();
            //递归创建父级目录，可能会每天一个卡口创建一次
            mkdir(parentFile);
            //创建当前目录
            resultFlag = dir.mkdir();
            Runtime.getRuntime().exec("chmod -R 777 " + dir);
        } else {
            log.info(dir + ", 路径已存在，这里只设置权限");
            setPermission(dir);
            resultFlag = true;
        }
        return resultFlag;
    }

    /**
     * 设置目录权限为最高级
     * @param dir
     */
    public static void setPermission(File dir) {
        boolean b = dir.setWritable(true, false);
        boolean b1 = dir.setExecutable(true, false);
        boolean b2 = dir.setReadable(true, false);
        log.info("路径 {} 设置读写权限结束，写：{}， 执行：{}， 读：{}", dir.getPath(), b, b1, b2);
    }

    /**
     * 判断是否存在
     * @param url
     * @return
     */
    private boolean isExistFile(String url){
        boolean flag = false;
        File imageFile = new File(url);
        if(imageFile.exists()){
            flag = true;
        }
        return flag;
    }
}
