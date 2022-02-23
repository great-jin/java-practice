import org.junit.Test;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateTest {

    /**
     * a instanceof B: 判断a是否为b的实例, 返回Boolean
     */
    @Test
    public void InstanceDemo() {
        Date timDate = new Date();
        System.out.println(timDate instanceof Date);
    }

    /**
     * 格式化时间
     */
    @Test
    public void DateFormatDemo(){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        String date = sdf.format(new Date());

        System.out.println(date);
    }

    /**
     * 时间戳
     */
    @Test
    public void TimestampDemo(){
        Timestamp time1 = Timestamp.valueOf("1970-01-01 00:00:00.001");
        Timestamp time2 = Timestamp.from(new Date().toInstant());

        System.out.println(time1);
        System.out.println(time2);
    }
}
