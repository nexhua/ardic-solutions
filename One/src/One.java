import com.ardic.one.NumberString;

public class One {
    public static void main(String[] args) {

        NumberString num_0 = new NumberString("21095128");
        NumberString num_1 = new NumberString("-92184912");
        NumberString num_2 = new NumberString("321242109,7425123");
        NumberString num_3 = new NumberString("-84714,74");
        NumberString num_4 = new NumberString("-1234567890,0123456789");


        System.out.println(num_0);
        System.out.println(num_1);
        System.out.println(num_2);
        System.out.println(num_3);
        System.out.println(num_4);
    }
}
