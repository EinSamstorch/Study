package zhongxingpengyue;

import java.util.Scanner;

public class Main2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // Scanner是一个扫描器，它扫描数据都是去内存中一块缓冲区中进行扫描并读入数据的，而我们在控制台中输入的数据也都是被先存入缓冲区中等待扫描器的扫描读取。
        // 这个扫描器在扫描过程中判断停止的依据就是“空白符”，空格啊，回车啊什么的都算做是空白符。
        // nextInt()方法在扫描到空白符的时候会将前面的数据读取走，但会丢下空白符“\r”在缓冲区中，但是，nextLine()方法在扫描的时候会将扫描到的空白符一同清理掉。
        // 像是上边的代码nextInt()方法之后在缓冲区中留下了“\r”，
        // 然后nextLine()方法再去缓冲区找数据的时候首先看到了“\r”，然后就把这个“\r”扫描接收进来，并在缓冲区内清除掉。其实，nextLine()方法是执行过的，并没有不执行。
//        int T = sc.nextInt();
//        int T = Integer.parseInt(sc.nextLine());
//        while (T > 0) {
//            T--;
//            int temp = 0;
//            String n = sc.nextLine();
//            BigDecimal k = new BigDecimal(n);
//            int i = 0;
//            // a.compareTo(b) > 0 表示 a > b
//            while (k.compareTo(BigDecimal.valueOf(Math.pow(2, i))) > 0) {
//                i++;
//            }
//            System.out.println(temp + i + 1);
//        }

        while (in.hasNextInt()) {
            int T = in.nextInt();
            while (T-- != 0) {
                long n = in.nextLong();
                System.out.println(1 + (int) Math.ceil(Math.log(n) / Math.log(2)));
            }
        }
    }
}
