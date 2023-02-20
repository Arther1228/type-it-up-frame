package com.yang.springboot.demo.annotation;

import java.lang.annotation.*;
import java.lang.reflect.AnnotatedType;

/**
 * @author yangliangchuang 2022/11/18 15:29
 * JAVA注解学习-@Repeatable注解
 * https://blog.csdn.net/u010316188/article/details/103651646
 */
public class RepeatableTest {

    @Repeatable(APIS.class)
    public @interface API {
        String content() default "请添加描述";
    }

    @Target({ElementType.TYPE})
    @Retention(RetentionPolicy.RUNTIME)
    @Documented
    public @interface APIS {
        API[] value();
    }

    @API(content = "学生对象1")
    @API(content = "学生对象2")
    @API(content = "学生对象3")
    public class Student {
    }

    public static void main(String[] args) {
        Annotation[] annotations = Student.class.getAnnotations();

        for (Annotation annotation : annotations) {
            System.out.println(annotation.annotationType().getName());
            APIS api = (APIS) annotation;
            for (API a : api.value()) {
                System.out.println(a.content());
            }
        }

        APIS annotation = Student.class.getAnnotation(APIS.class);
        System.out.println(annotation.value()[0].content());
        AnnotatedType[] annotatedInterfaces = Student.class.getAnnotatedInterfaces();
        for (AnnotatedType annotatedInterface : annotatedInterfaces) {
            System.out.println(annotatedInterface.getType());
        }
        Student.class.getComponentType();
    }
}


