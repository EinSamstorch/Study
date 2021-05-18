package interview.meituan9;

import java.util.*;

/**
 * @author <a href="mailto:einsamstorch@qq.com">Liqun_Wang</a>
 * @date: 2021/4/26 11:14
 */
public class Main4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int treeSize = sc.nextInt();
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < treeSize - 1; i++) {
            int father = sc.nextInt();
            int son = sc.nextInt();
            List<Integer> fatherList = map.getOrDefault(father, new ArrayList<>());
            List<Integer> sonList = map.getOrDefault(son, new ArrayList<>());
            fatherList.add(son);
            sonList.add(father);
            map.put(father, fatherList);
            map.put(son, sonList);
        }
        // 对map里面的元素进行modify，使得它只能含有指向儿子的有向图
        modify(1, map);
    }

    private static void modify(int root, Map<Integer, List<Integer>> map) {
        List<Integer> fatherList = map.get(root);
        if (fatherList.size() == 0) {
            return;
        }
        for (int child : fatherList) {
            List<Integer> children = map.get(child);
            children.remove(root);
            // 删除child为键的，邻接数组里面是root的部分
            map.put(child, children);
            modify(child, map);
        }
    }
}
