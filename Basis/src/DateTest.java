import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateTest {
    public static void main(String []args) {
        DateFormatDemo();

        TimestampDemo();

        // a instanceof B: 判断a是否为b的实例, 返回Boolean
        Date timDate = new Date();
        if(timDate instanceof Date){
            System.out.println(timDate);
        }
    }

    /**
     * 格式化时间
     */
    private static void DateFormatDemo(){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        String date = sdf.format(new Date());

        System.out.println(date);
    }

    private static void TimestampDemo(){
        Timestamp time1 = Timestamp.valueOf("1970-01-01 00:00:001");
        Timestamp time2 = Timestamp.from(new Date().toInstant());

        System.out.println(time1);
        System.out.println(time2);
    }
}
