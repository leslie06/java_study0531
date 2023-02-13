package com.mysql.mysqldemo.sms;

import java.util.*;
import javax.mail.*;
import javax.mail.internet.*;

/**
 * @description: 发送电子邮件
 * 步骤：在qq邮箱设置-账户开启开启POP3/SMTP服务，获取授权码
 * @author: kangy
 * @date: 2023/2/13 11:44
 */
public class SendEmail {
    public static void main(String [] args)
    {
        // 收件人电子邮箱
        String to = "kangyu034@gmail.com";

        // 发件人电子邮箱
        String from = "791110546@qq.com";

        // 指定发送邮件的主机为 smtp.qq.com
        String host = "smtp.qq.com";  //QQ 邮件服务器

        // 获取系统属性
        Properties properties = System.getProperties();

        // 设置邮件服务器
        properties.setProperty("mail.smtp.host", host);

        properties.put("mail.smtp.auth", "true");
        // 获取默认session对象
        Session session = Session.getDefaultInstance(properties,new Authenticator(){
            public PasswordAuthentication getPasswordAuthentication()
            {
                return new PasswordAuthentication("791110546@qq.com", "larzftwaoqlrbbhj"); //发件人邮件用户名、授权码
            }
        });

        try{
            // 创建默认的 MimeMessage 对象
            MimeMessage message = new MimeMessage(session);

            // Set From: 头部头字段
            message.setFrom(new InternetAddress(from));

            // Set To: 头部头字段
            message.addRecipient(Message.RecipientType.TO,
                    new InternetAddress(to));

            // Set Subject: 头部头字段
            message.setSubject("网上购票系统-用户支付通知");

            // 设置消息体
            message.setText("\n" +
                    "尊敬的 康先生：\n" +
                    "您好！\n" +
                    "您于2023年01月16日在中国铁路客户服务中心网站(12306.cn) 成功购买了1张车票，票款共计547.50元，订单号码 ED73701272 。 所购车票信息如下：");

            // 发送消息
            Transport.send(message);
            System.out.println("Sent message successfully....from runoob.com");
        }catch (MessagingException mex) {
            mex.printStackTrace();
        }
    }
}
