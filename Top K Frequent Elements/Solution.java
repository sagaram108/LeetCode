
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class Solution {
    public static int[] topKFrequent(int[] nums, int k) {
        // map<key, freq>
        HashMap<Integer, Integer> map = new HashMap<>();
        for (var num : nums) {
            if (map.containsKey(num)) {
                map.put(num, map.get(num) + 1);
            } else {
                map.put(num, 1);
            }
        }

        // priorityqueue<key, freq>
        // remove-nature is Min-Heap(by freq)
        PriorityQueue<Map.Entry<Integer, Integer>> pq = new PriorityQueue<>((a, b) -> (a.getValue() - b.getValue()));

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            // pq.add(entry.getValue(), entry.getKey());
            pq.add(entry);
            if (pq.size() > k) {
                pq.remove();
            }
        }

        int a[] = new int[k];
        while (k-- != 0) {
            Map.Entry<Integer, Integer> entry = pq.remove();
            a[k] = entry.getKey();
        }
        return a;
    }
}
