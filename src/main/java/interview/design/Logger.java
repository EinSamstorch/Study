package interview.design;

import java.util.HashMap;
import java.util.Map;

/**
 * @author <a href="mailto:einsamstorch@qq.com">Liqun_Wang</a>
 * @date: 2021/5/18 10:33
 */
public class Logger {
    private Map<String, Integer> msgDict;

    public Logger() {
        msgDict = new HashMap<>();
    }

    public boolean shouldPrintMessage(int timestamp, String message) {
        if (!msgDict.containsKey(message) || timestamp - msgDict.get(message) >= 10) {
            // 未出现过或者相差超过十秒
            msgDict.put(message, timestamp);
            return true;
        } else {
            // 十秒内出现过
            return false;
        }
    }
}
