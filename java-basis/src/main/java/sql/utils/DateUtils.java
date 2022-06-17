package sql.utils;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateUtils {

    /**
     * 获取上一周开始与结束日期（周一 ~ 周日）
     *
     * @param date
     * @return
     */
    public static String[] getLastTimeInterval(Date date) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Calendar calendar1 = Calendar.getInstance();
        Calendar calendar2 = Calendar.getInstance();
        calendar1.setTime(date);
        calendar2.setTime(date);
        int dayOfWeek = calendar1.get(Calendar.DAY_OF_WEEK) - 1;
        if (dayOfWeek <= 0) {
            dayOfWeek = 7;
        }
        String[] dateArr = new String[2];
        int offset1 = 1 - dayOfWeek;
        calendar1.add(Calendar.DATE, offset1 - 7);
        dateArr[0] = sdf.format(calendar1.getTime());
        int offset2 = 7 - dayOfWeek;
        calendar2.add(Calendar.DATE, offset2 - 7);
        dateArr[1] = sdf.format(calendar2.getTime());
        return dateArr;
    }

    /**
     * 获取上个月开始与结束日期
     *
     * @param startDate
     * @return
     * @throws Exception
     */
    public static String[] getPreMonthDate(String startDate) throws Exception {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        Calendar c = getPreMonth(startDate);
        String[] date = new String[2];
        int firstDay = c.getActualMinimum(Calendar.DAY_OF_MONTH);
        c.set(Calendar.DAY_OF_MONTH, firstDay);
        date[0] = format.format(c.getTime());

        Calendar c2 = getPreMonth(startDate);
        int lastDay = c2.getActualMaximum(Calendar.DAY_OF_MONTH);
        c2.set(Calendar.DAY_OF_MONTH, lastDay);
        date[1] = format.format(c2.getTime());
        return date;
    }

    /**
     * 从当前时间 yyyy-MM-dd 格式获取上个月的时间
     */
    private static Calendar getPreMonth(String startDate) throws Exception {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        Calendar c = Calendar.getInstance();
        Date date = format.parse(startDate);
        c.setTime(date);
        c.add(Calendar.MONTH, -1);
        return c;
    }

    public static String[] getProgrammeDate(int frequency) throws Exception {
        String[] programmeDate = new String[2];
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        switch (frequency) {
            case 0:
                // 单次对账
                programmeDate[0] = sdf.format(new Date());
                programmeDate[1] = sdf.format(new Date());
                break;
            case 1:
                // 按周循环
                programmeDate[0] = getLastTimeInterval(new Date())[0];
                programmeDate[1] = getLastTimeInterval(new Date())[1];
                break;
            case 2:
                // 按月循环
                programmeDate[0] = getPreMonthDate(sdf.format(new Date()))[0];
                programmeDate[1] = getPreMonthDate(sdf.format(new Date()))[1];
                break;
        }
        return programmeDate;
    }
}
