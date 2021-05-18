import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author <a href="mailto:einsamstorch@qq.com">Liqun_Wang</a>
 * @date: 2021/1/18 19:18
 */

public class Cmd {

    public static void main(String[] args) throws IOException, InterruptedException {
        String[] arguments = new String[]{"python", "D:\\Documents\\Python\\time.py", "wangliqun", "23"};
        try {
            Process process = Runtime.getRuntime().exec(arguments);
            BufferedReader in = new BufferedReader(new InputStreamReader(process.getInputStream()));
            String line = null;
            while ((line = in.readLine()) != null) {
                System.out.println(line);
            }
            in.close();
            int re = process.waitFor();
            System.out.println(re);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}