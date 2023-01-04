package com.yang.springboot.linux;

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
            mkdir(parentFile);
            resultFlag = dir.mkdir();
            Runtime.getRuntime().exec("chmod -R 777 " + dir);
        } else {
            //log.info(dir + ", 路径已存在，这里只设置权限");
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
        dir.setWritable(true, false);
        dir.setExecutable(true, false);
        dir.setReadable(true, false);
    }
}
