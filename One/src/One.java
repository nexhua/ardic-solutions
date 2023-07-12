import com.ardic.one.Number;

import java.math.BigDecimal;

public class One {
    public static void main(String[] args) {

        Number num_0 = new Number(new BigDecimal("21095128"));
        Number num_1 = new Number(new BigDecimal("-92184912"));
        Number num_2 = new Number(new BigDecimal("321242109.7425123"));
        Number num_3 = new Number(new BigDecimal("-84714.74"));
        Number num_4 = new Number(new BigDecimal("-1828174515234567890.123456789"));

        //System.out.println(num_0);
        //System.out.println(num_1);
        System.out.println(num_2);
        System.out.println(num_3);
        System.out.println(num_4);
    }
}
