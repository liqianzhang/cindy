package com.aim;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

/**
 * @MethodName: $
 * @Description: TODO
 * @Param: $
 * @Return: $
 * @Author: zhangliqian
 * @Date: $
 */
public class ServiceApply {
    //编译路径

    ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");


    //XmlBeanFactory引用资源
//    Resource resource = new ClassPathResource("");
//    BeanFactory factory = new XmlBeanFactory(resource);

    //用文件系统的路径
    ApplicationContext applicationContext = new FileSystemXmlApplicationContext("");


}
