package myhash.demo2;

/**
 * @author <a href="mailto:einsamstorch@qq.com">Liqun_Wang</a>
 * @date: 2021/7/20 11:19
 */
public class TestMyHashMap {

    public static void main(String[] args) {

        MyMap<String, Object> map = new MyHashMap<>();
        map.put("name", "zuozhen");
        map.put("age", 23);
        map.put("weight", 75);
        map.put(null, "zuozhen2");

        System.out.println(map.get("name"));
        System.out.println(map.get("age"));
        System.out.println(map.get("weight"));
        System.out.println(map.get(null));

        map.put("name", "zuozhen1");
        System.out.println(map.get("name"));
    }
}
