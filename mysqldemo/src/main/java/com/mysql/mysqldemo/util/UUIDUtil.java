package com.mysql.mysqldemo.util;

import java.util.UUID;

/**
 * @Description
 * @Author leslie
 * @Date 2022/10/26 11:40
 **/
public class UUIDUtil {
    public static String getUUid(){
        return UUID.randomUUID().toString().replaceAll("-","");
    }
}
