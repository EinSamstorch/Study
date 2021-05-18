package interview.design;

import java.util.*;

/**
 * @author <a href="mailto:einsamstorch@qq.com">Liqun_Wang</a>
 * @date: 2021/5/18 14:00
 */
public class FileSharingSystem {
    /**
     * key：用户id
     * value：该用户拥有的区块列表
     */
    Map<Integer, Set<Integer>> map;
    /**
     * 自增用户id
     */
    int uid = 1;
    /**
     * 可复用的id列表
     */
    PriorityQueue<Integer> leaveIds;

    public int join(List<Integer> ownedChunks) {
        // 默认使用用户自增id
        int userID = uid;
        if (leaveIds.size() > 0) {
            // 如果复用列表不为空，优先使用复用列表中最小的
            userID = leaveIds.poll();
        } else {
            uid++;
        }
        map.put(userID, new HashSet<>(ownedChunks));
        return userID;
    }

    public void leave(int userID) {
        // 从map中删除该用户信息
        map.remove(userID);
        // 将该用户id添加至可服用id的queue列表
        leaveIds.offer(userID);
    }

    public List<Integer> request(int userID, int chunkID) {
        List<Integer> res = new ArrayList<>();
        for (int user : map.keySet()) {
            if (map.get(user).contains(chunkID)) {
                res.add(user);
            }
        }

        // 如果返回结果中元素个数大于0，说明userID这个用户可以得到chunkID这个区块
        if (res.size() > 0) {
            Set<Integer> set = map.get(userID);
            set.add(chunkID);
            map.put(userID, set);
        }
        return res;
    }
}
