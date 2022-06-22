package basis.utils.date;

import org.junit.Test;

import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;

public class DateTest {

    /**
     * java.util.Date表示特定的瞬间，精确到毫秒
     */
    @Test
    public void UtilDateDemo() {
        Date date1 = new Date();
        System.out.println("origin：" + date1);

        Date date2 = new Date(System.currentTimeMillis());
        System.out.println("current：" + date2);

        SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        String date3 = sdf1.format(new Date());
        System.out.println("精确到秒：" + date3);

        SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss.SSS");
        String date4 = sdf2.format(new Date());
        System.out.println("精确到毫秒：" + date4);

    }

    /**
     * java.sql.date 继承自 java.util.Date
     * java.sql.date 的时间格式是年-月-日，没有时间部分
     * 强制从 datesql 获取时分秒，会抛异常，但是不代表没有时间部分的精度
     */
    @Test
    public void SQLDateDemo() {
        java.sql.Date date = new java.sql.Date(System.currentTimeMillis());
        System.out.println(date);
    }

    /**
     * 时间戳
     */
    @Test
    public void TimestampDemo() {
        Timestamp time1 = Timestamp.valueOf("1970-01-01 00:00:00.001");
        Timestamp time2 = Timestamp.from(new Date().toInstant());

        System.out.println(time1);
        System.out.println(time2);
    }

    /**
     * Calendar 日历类
     */
    @Test
    public void CalendarDemo() {
        // 获取当前时间实例
        Calendar calendar = Calendar.getInstance();
        // 设置日期
        calendar.set(Calendar.YEAR, 1998);
        calendar.set(Calendar.MONTH, 3);
        calendar.set(Calendar.DATE, 28);
        calendar.set(Calendar.HOUR_OF_DAY, 23);
        calendar.set(Calendar.MINUTE, 11);
        calendar.set(Calendar.SECOND, 11);

        // 获取日期
        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH);
        int day = calendar.get(Calendar.DATE);
        int hour = calendar.get(Calendar.HOUR_OF_DAY);
        int minute = calendar.get(Calendar.MINUTE);
        int second = calendar.get(Calendar.SECOND);

        // 当前时间后移
        calendar.add(Calendar.DATE, -1);
        // 当前时间前推
        calendar.add(Calendar.DATE, -1);

        // 将日期转为可读的 Date 类
        Date date = calendar.getTime();
        System.out.println(date);
    }

    @Test
    public void CalendarDemo1() {
        // 获取当前时间前第 n 天时间
        int n = 2;
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.DAY_OF_YEAR, calendar.get(Calendar.DAY_OF_YEAR) - n);
        Date passDay = calendar.getTime();
        System.out.println(passDay);
    }
}
