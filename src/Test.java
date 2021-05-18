import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * @Author <a href="mailto:einsamstorch@qq.com">Liqun_Wang</a>
 * @Date: 2020/9/3 17:21
 */
public class Test {


    public static void main(String[] args) throws Exception {

        List<String> list = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            new Thread(() -> {
                list.add(UUID.randomUUID().toString().substring(0, 5));
                // 必须打印调用出来
                System.out.println(list);
            }, String.valueOf(i)).start();
        }
    }
}








