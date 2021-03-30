package cn.noteblogs.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtil {
    public static String data2String(Date date, String format){
        SimpleDateFormat sp = new SimpleDateFormat(format);
        String s = sp.format(date);
        return s;
    }
    public static Date String2Date(String time, String format) throws ParseException {
        SimpleDateFormat simpleDateFormat=new SimpleDateFormat(format);
        Date date=simpleDateFormat.parse(time);
        return date;
    }
}
