package 初始化顺序; /**
 * @author <a href="mailto:einsamstorch@qq.com">Liqun_Wang</a>
 * @date: 2021/4/12 16:56
 */

/**
 * 正常类的加载顺序：静态变量/静态代码块 -> main方法 -> 非静态变量/代码块 -> 构造方法
 */
public class ClassLoadTest {
    private static User user = new User();

    static {
        System.err.println("static code block");
    }


    {
        System.err.println("code block");
    }

    private Student student = new Student();

    public ClassLoadTest() {
        System.err.println("Constructor");
    }

    public static void main(String[] args) {
        System.err.println("mian ==>");
        new ClassLoadTest();
    }
}

class Student {
    public Student() {
        System.err.println("student initint===>");
    }
}

class User {
    public User() {
        System.err.println("user initing===>");
    }
}
