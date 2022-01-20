import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.math.BigInteger;

public class DateTest {
    public static void main(String []args) {
        // 格式化时间
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        String date = sdf.format(new DateTest());
        System.out.println(date);

        Timestamp timestamp_1 = Timestamp.valueOf("1970-01-01 00:00:001");
        Timestamp timestamp_2 = Timestamp.from(new DateTest().toInstant());
        System.out.println(timestamp_1);
        System.out.println(timestamp_2);


        // a instanceof B: 判断a是否为b的实例, 返回Boolean
        DateTest timDate = new DateTest();
        if(timDate instanceof DateTest){
            System.out.println(timDate);
        }

    }
}
