package com.example.server;

import org.joda.time.DateTime;
import org.joda.time.DateTimeZone;
import org.joda.time.LocalDate;
import org.joda.time.format.DateTimeFormat;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ConfigApplicationTests {

    @Test
    public void contextLoads() {
        DateTime today = new DateTime();
        // 日期加1
        DateTime datetorrow = today.plusDays(1);

        System.out.println(today.toString("yyyy-MM-dd"));// 2019-03-05
        System.out.println(today.toString("yyyy-MM-dd HH:mm:ss"));// 2019-03-05 10:06:32
        System.out.println(datetorrow.toString("yyyy-MM-dd"));//2019-03-06

        System.out.println("......................");

        // 获得一个时间的副本，将day设置成自己制定的时间,不改变月份，只改变日期
        // 本月第1天
        DateTime d1 = today.withDayOfMonth(1);
        System.out.println(d1.toString("yyyy-MM-dd"));//2019-03-01

        System.out.println("......................");

        LocalDate localDate = new LocalDate();
        System.out.println(localDate);//2019-03-05

        System.out.println("........................");

        //获取当前时间三个月后的月份的最后一天
        localDate = localDate.plusMonths(3).dayOfMonth().withMaximumValue();
        System.out.println(localDate);//2019-06-30

        System.out.println("........................");


        //计算二年前第三个月最后一天的日期
        DateTime dateTime = new DateTime();
        DateTime dateTime2 = dateTime.minusYears(2).monthOfYear().setCopy(3).
                dayOfMonth().withMinimumValue();
        System.out.println(dateTime2.toString("yyyy-MM-dd"));//2017-03-01

        System.out.println("........................");

        System.out.println(this.convertUTC2Date("2010-12-1 21:22:33"));//Wed Dec 01 19:22:33 CST 2010
        System.out.println(this.ConvertDate2UTC(new Date()));//2017-06-26T14:09:53.606Z
        System.out.println(this.convertDate2LocalByDateformat(new Date(),"yyyy-MM-dd HH:mm:ss"));//2017-06-26 22:09:53
    }

    //将utc时间转换成java中的Date格式
    public static Date convertUTC2Date(String utcDate){
        try{
            DateTime dateTime =DateTime.parse(utcDate, DateTimeFormat.forPattern("yyyy-MM-dd HH:mm:ss"));
            return dateTime.toDate();
        }catch (Exception ex){
            return null;
        }
    }

    //将java中的date格式的时间转换成utc时间标准
    public static String ConvertDate2UTC(Date javaDate){
        DateTime dateTime = new DateTime(javaDate, DateTimeZone.UTC);
        return dateTime.toString();
    }

    //将Date类型转换成字符串
    public static String convertDate2LocalByDateformat(Date javaDate,String dateFormat){
        DateTime dateTime = new DateTime(javaDate);
        return dateTime.toString(dateFormat);
    }

}
