package basis.constrct.abs;

public class AbsTest {

    public static void main(String[] args) {
        AbsSon absSon = new AbsSon();
        absSon.hello();

        int sum = absSon.AddElem(10, 20);
        System.out.println(sum);
    }
}






