import java.util.HashMap;
import java.util.Map;

/**
 * @Author <a href="mailto:einsamstorch@qq.com">Liqun_Wang</a>
 * @Date: 2020/9/3 17:21
 */
public class Test {


    private static Map<String, String> map = new HashMap<>();

    public static void main(String[] args) {
        Integer a = 127;
        Integer b = 127;
        System.out.println(a == b);

        Integer c = new Integer(1);
        Integer d = new Integer(1);
        System.out.println(c == d);

    }
}

