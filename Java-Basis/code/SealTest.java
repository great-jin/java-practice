public class SealTest {
    public static void main(String[] args) {
        // StringBuilder提供一种可变的字符串类型
        StringBuilder builder = new StringBuilder();
        builder.append("Hello");
        builder.append("World!");
        builder.insert(5, "J");
        builder.setCharAt(5, ' ');
        String finalString = builder.toString();
        System.out.println(finalString);

        
        // hashCode：对象散列值计算
        String str = "hello";
        StringBuilder strBuilder = new StringBuilder("hello");
        System.out.println(str.hashCode() + "__" + strBuilder.hashCode());


        // 可以处理任意长度的数字序列长度
        BigInteger big_1 = BigInteger.valueOf(100);
        BigInteger big_2 = BigInteger.valueOf(100);
        BigInteger a = big_1.add(big_2);
        System.out.println(a);


        // 对象包装，将一般类型封装为对象，实现可实例化。
        // int i = null; 语句非法
        int i = 0;
        Integer integer_1 = null;
        Integer integer_2 = new Integer();
    }
}
