package interview.design;

import java.util.*;

/**
 * @author <a href="mailto:einsamstorch@qq.com">Liqun_Wang</a>
 * @date: 2021/5/16 0:40
 */
public class TweetCounts {
    Map<String, List<Integer>> map;

    public TweetCounts() {
        map = new HashMap<>();
    }

    public void recordTweet(String tweetName, int time) {
        map.computeIfAbsent(tweetName, k -> new ArrayList<>());
        List<Integer> list = map.get(tweetName);
        list.add(time);
        Collections.sort(list);
        map.put(tweetName, list);
    }

    public List<Integer> getTweetCountsPerFrequency(String freq, String tweetName,
                                                    int startTime, int endTime) {
        List<Integer> results = new ArrayList<>();
        List<Integer> tweets = map.get(tweetName);
        int interval;
        switch (freq) {
            case "minute":
                interval = 60;
                break;
            case "hour":
                interval = 60 * 60;
                break;
            default:
                interval = 60 * 60 * 24;
                break;
        }

        for (int time = startTime; time <= endTime; time += interval) {
            int begin = time;
            int end = Math.min(time + interval, endTime + 1);
            long count = tweets.stream().filter(t -> t >= begin && t < end).count();
            results.add((int) count);
        }
        return results;
    }
}
