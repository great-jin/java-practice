package basis;

import org.junit.Test;

public class EnumTest {

    @Test
    public  void Demo1() {
        Color color = Color.Blue;

        System.out.println(color);
        System.out.println(color.ordinal());
        System.out.println(color == Color.Blue);
        System.out.println(color.equals(Color.Blue));

    }

    @Test
    public  void Demo2() {
        Weekday day = Weekday.SUN;

        System.out.println(day);
        System.out.println(day.ordinal());
        System.out.println(day == Weekday.SAT);
        System.out.println(day.equals(Weekday.SUN));
    }

}

enum Color {
    Red,
    Blue,
    White,
    Black
}

enum Weekday {
    MON(1, "星期一"),
    TUE(2, "星期二"),
    WED(3, "星期三"),
    THU(4, "星期四"),
    FRI(5, "星期五"),
    SAT(6, "星期六"),
    SUN(0, "星期日");

    public final int dayValue;
    private final String describe;

    Weekday(int dayValue, String describe) {
        this.dayValue = dayValue;
        this.describe = describe;
    }

    @Override
    public String toString() {
        return this.describe;
    }
}
