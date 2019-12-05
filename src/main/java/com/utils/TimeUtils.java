package com.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TimeUtils {
    /**
     * 内部调用枚举
     */
    public enum  TimeFormat{
        YYYY("年-月","YYYY-MM"),
        YYYY_MM("年-月","YYYY-MM"),
        YYYY_MM_DD("年-月-日","YYYY-MM-dd"),
        YYYY_MM_DD_HH("年-月-日 时","YYYY-MM-dd HH"),
        YYYY_MM_DD_HH_MI("年-月-日 时:分","YYYY-MM-dd HH:mm"),
        YYYY_MM_DD_HH_MI_SS("年-月-日 时:分","YYYY-MM-dd HH:mm:ss");
         private String type;
         private String timeFormat;

        TimeFormat(String type, String timeFormat) {
            this.type = type;
            this.timeFormat = timeFormat;
        }

        public String getType() {
            return type;
        }

        public String getTimeFormat() {
            return timeFormat;
        }
    }

    public static  Date getFormatTime(Date date,TimeFormat timeFormat){
        SimpleDateFormat simpleDateFormat=new SimpleDateFormat(timeFormat.getTimeFormat());
        String tmString=simpleDateFormat.format(date);
        try {
            Date formatDate=simpleDateFormat.parse(tmString);
            return formatDate;
        } catch (ParseException e) {
            e.printStackTrace();
            return date;
        }
    }
    public static String getFormatTimeString(Date date,TimeFormat timeFormat){
        SimpleDateFormat simpleDateFormat=new SimpleDateFormat(timeFormat.getTimeFormat());
        String tmString=simpleDateFormat.format(date);
           return tmString;
    }
    /**
     * 获取系统时间戳（高频下调用可能存在性能问题）
     * @return
     */
    public static Long getTimeStamp(){
        Long timeStamp=System.currentTimeMillis();
        return timeStamp;
    }


}
