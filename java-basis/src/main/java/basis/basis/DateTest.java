package basis.basis;

import org.junit.Test;

import java.util.Calendar;
import java.util.Date;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;

public class DateTest {

    /**
     * 不同类型时间
     */
    @Test
    public void DateTypeDemo() {
        java.util.Date date1 = new java.util.Date();
        java.sql.Date date2 = new java.sql.Date(System.currentTimeMillis());

        System.out.println(date1);
        System.out.println(date2);
    }

    /**
     * 格式化时间
     */
    @Test
    public void FormatDemo() {
        SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss.SSS");
        String date1 = sdf1.format(new Date());
        String date2 = sdf2.format(new Date());

        System.out.println(date1);
        System.out.println(date2);
    }

    /**
     * 获取任意日期
     */
    @Test
    public void AnyTime() {
        // 获取当前时间前第 n 天时间
        int n = 2;
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.DAY_OF_YEAR, calendar.get(Calendar.DAY_OF_YEAR) - n);
        Date passDay = calendar.getTime();
        System.out.println(passDay);
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
}
