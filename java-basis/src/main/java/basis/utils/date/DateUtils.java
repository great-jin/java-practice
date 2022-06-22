package basis.utils.date;

import org.junit.Test;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;

public class DateUtils {

    private final SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

    @Test
    public void Demo() throws Exception {
        System.out.println(Arrays.toString(getLastTimeInterval(new Date())));

        SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd");
        System.out.println(Arrays.toString(getPreMonthDate(sdf1.format(new Date()))));
    }

    /**
     * 获取上一周开始与结束日期（周一 ~ 周日）
     *
     * @param date
     * @return
     */
    public String[] getLastTimeInterval(Date date) {
        Calendar calendar1 = Calendar.getInstance();
        Calendar calendar2 = Calendar.getInstance();
        calendar1.setTime(date);
        calendar2.setTime(date);
        int dayOfWeek = calendar1.get(Calendar.DAY_OF_WEEK) - 1;
        if (dayOfWeek <= 0) {
            dayOfWeek = 7;
        }
        int offset1 = 1 - dayOfWeek;
        int offset2 = 7 - dayOfWeek;
        calendar1.add(Calendar.DATE, offset1 - 7);
        calendar2.add(Calendar.DATE, offset2 - 7);

        String[] dateArr = new String[2];
        // last Monday
        dateArr[0] = sdf.format(calendar1.getTime());
        // last Sunday
        dateArr[1] = sdf.format(calendar2.getTime());
        return dateArr;
    }

    /**
     * 获取下一周开始与结束日期
     *
     * @param date
     * @return
     */
    public String[] getNextTimeInterval(Date date) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        Calendar calendar1 = Calendar.getInstance();
        Calendar calendar2 = Calendar.getInstance();
        calendar1.setTime(date);
        calendar2.setTime(date);
        int dayOfWeek = calendar1.get(Calendar.DAY_OF_WEEK) - 1;
        if (dayOfWeek <= 0) {
            dayOfWeek = 7;
        }
        int offset1 = 1 - dayOfWeek;
        int offset2 = 7 - dayOfWeek;
        calendar1.add(Calendar.DATE, offset1 + 7);
        calendar2.add(Calendar.DATE, offset2 + 7);

        String[] dateArr = new String[2];
        // last Monday
        dateArr[0] = sdf.format(calendar1.getTime());
        // last Sunday
        dateArr[1] = sdf.format(calendar2.getTime());
        return dateArr;
    }

    /**
     * 获取当前周的开始与结束日期
     *
     * @param date
     * @return
     */
    public String[] getTimeInterval(Date date) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        int dayWeek = cal.get(Calendar.DAY_OF_WEEK);
        if (1 == dayWeek) {
            cal.add(Calendar.DAY_OF_MONTH, 0);
        }
        cal.setFirstDayOfWeek(Calendar.MONDAY);
        int day = cal.get(Calendar.DAY_OF_WEEK);
        cal.add(Calendar.DATE, cal.getFirstDayOfWeek() - day);

        String[] dateArr = new String[2];
        dateArr[0] = sdf.format(cal.getTime());
        cal.add(Calendar.DATE, 6);
        dateArr[1] = sdf.format(cal.getTime());
        return dateArr;
    }

    /**
     * 获取上一个月开始与结束时间
     *
     * @param startDate
     * @throws Exception
     */
    private String[] getPreMonthDate(String startDate) throws Exception {
        Calendar c = getPreMonth(startDate);

        String[] date = new String[2];
        //获取某月最小天数
        int firstDay = c.getActualMinimum(Calendar.DAY_OF_MONTH);
        //设置日历中月份的最小天数
        c.set(Calendar.DAY_OF_MONTH, firstDay);
        // 上个月第一天
        date[0] = sdf.format(c.getTime());

        Calendar c2 = getPreMonth(startDate);
        int lastDay = c2.getActualMaximum(Calendar.DAY_OF_MONTH);
        c2.set(Calendar.DAY_OF_MONTH, lastDay);
        date[1] = sdf.format(c2.getTime());
        return date;
    }

    /**
     * 从当前时间 yyyy-MM-dd 格式获取上个月的时间
     */
    private Calendar getPreMonth(String startDate) throws Exception {
        Calendar c = Calendar.getInstance();
        Date date = sdf.parse(startDate);
        c.setTime(date);
        c.add(Calendar.MONTH, -1);
        return c;
    }
}
