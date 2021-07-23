import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @Author <a href="mailto:einsamstorch@qq.com">Liqun_Wang</a>
 * @Date: 2020/8/30 19:45
 */
public class Single1 {
    private static volatile Single1 instance;

    private Single1() {
    }

    public static synchronized Single1 getInstance() {
        if (instance == null) {
            synchronized (Single1.class) {
                if (instance == null) {
                    instance = new Single1();
                }
            }
        }
        return instance;
    }

    public static void main(String[] args) {
        List<String> stringArrayList = new ArrayList<>();

        List<Integer> integerArrayList = new ArrayList<>();

        Class classStringArrayList = stringArrayList.getClass();

        Class classIntegerArrayList = integerArrayList.getClass();

        System.out.println(classStringArrayList);
        System.out.println(classIntegerArrayList);

        Apple[] apples = Apple.values();


    }

    public static <T extends Comparable<? super T>> T max(List<? extends T> list) {
        Iterator<? extends T> i = list.iterator();
        T result = i.next();

        while (i.hasNext()) {
            T t = i.next();
            if (t.compareTo(result) > 0) {
                result = t;
            }
        }
        return result;

    }

    public enum Apple {FUJI, PIPPIN, GRANNY_SMITH}

    public enum Orange {NAVEL, TEMPLE, BOOOD}


}
