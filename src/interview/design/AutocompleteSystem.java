package interview.design;

import javafx.util.Pair;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author <a href="mailto:einsamstorch@qq.com">Liqun_Wang</a>
 * @date: 2021/5/18 13:33
 */
public class AutocompleteSystem {
    /**
     * 使用两层 HashMap 存储句子和出现的次数。
     * 使用数组 arr 存储所有的句子和出现的次数，数组的每一项都是一个 HashMap，每个 HashMap 存储相同首字母的所有句子。
     * 例如 arr[0] 表示所有以 ′a′ 开头的所有句子的 HashMap。
     */
    Map<String, Integer>[] arr;

    public AutocompleteSystem(String[] sentences, int[] times) {
        arr = new HashMap[26];
        for (int i = 0; i < 26; i++) {
            arr[i] = new HashMap<>();
        }
        for (int i = 0; i < sentences.length; i++) {
            int index = sentences[i].charAt(0) - 'a';
            arr[index].put(sentences[i], times[i]);
        }
    }

    String cur_sent = "";

    public List<String> input(char c) {
        List<String> res = new ArrayList<>();
        if (c == '#') {
            int index = cur_sent.charAt(0) - 'a';
            arr[index].put(cur_sent, arr[index].getOrDefault(cur_sent, 0) + 1);
            cur_sent = "";
        } else {
            List<Pair<String, Integer>> list = new ArrayList<>();
            cur_sent += c;
            int index = cur_sent.charAt(0) - 'a';
            for (String key : arr[index].keySet()) {
                if (key.indexOf(cur_sent) == 0) {
                    list.add(new Pair<>(key, arr[index].get(key)));
                }
            }
            list.sort((a, b) -> a.getValue() == b.getValue() ? a.getKey().compareTo(b.getKey()) : b.getValue() - a.getValue());
            if (list.size() <= 3) {
                for (Pair<String, Integer> stringIntegerPair : list) {
                    res.add(stringIntegerPair.getKey());
                }
            } else {
                for (int i = 0; i < 3; i++) {
                    res.add(list.get(i).getKey());
                }
            }
        }
        return res;
    }
}
