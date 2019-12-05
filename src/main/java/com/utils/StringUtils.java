package com.utils;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 字符串工具类
 */
public class StringUtils {
    /**
     * 为空判断
     * @param str
     * @return
     */
    public static Boolean isEmpty(String str){
        if (str == null||"".equals(str)){
            return true;
        }
        return false;
    }

    /**
     * 不为空判断
     * @param str
     * @return
     */
    public static Boolean isNotEmpty(String str){
        if(str!=null&&!"".equals(str)){
            return true;
        }
        return false;
    }

    /**
     *字符串按固定长度截断保存
     * @param str 处理字符串
     * @param subLenth 固定截断长度
     * @return
     */
    public List<String> subByLength(String str,Integer subLenth){
        List<String> list=new ArrayList<String>();
        int index= (int) Math.ceil(Double.valueOf(str.length())/Double.valueOf(subLenth));
        for (int i = 0, l = str.length(); i < index; i++) {
            if(i!=index-1) {
                String a = str.substring(subLenth * i, subLenth * (i + 1));
                list.add(a);
                continue;
            }
            String a = str.substring(subLenth * i, str.length()-1);
            list.add(a);
        }
        return list;
    }

    /**
     * 判断包含中文字符个数
     * @param str
     * @return
     */
    public static int getUTF8_Size(String str){
        int count=0;
        String regEx = "[\\u4e00-\\u9fa5]";
        Pattern p = Pattern.compile(regEx);
        Matcher m = p.matcher(str);
        int len = m.groupCount();
        while (m.find()) {
            for (int i = 0; i <= len; i++) {
                count = count + 1;
            }
        }
        return count;

    }


}
