import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(bf.readLine());

        for (int t = 0; t < T; t++) {
            int N = Integer.parseInt(bf.readLine());
            PriorityQueue<Integer> minHeap = new PriorityQueue<>();
            PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
            Map<Integer, Integer> map = new HashMap<>();

            for (int i = 0; i < N; i++) {
                String[] sa = bf.readLine().split(" ");
                char command = sa[0].charAt(0);
                int num = Integer.parseInt(sa[1]);

                if (command == 'I') {
                    minHeap.add(num);
                    maxHeap.add(num);
                    map.put(num, map.getOrDefault(num, 0) + 1);
                } else {
                    if (map.size() == 0) continue;
                    if (num == 1) {
                        while(!maxHeap.isEmpty()){
                            Integer max = maxHeap.poll();
                            Integer count = map.get(max);
                            if (count == null) continue;
                            if (count == 1) map.remove(max);
                            else map.put(max, count - 1);
                            break;
                        }
                    } else {
                        while(!minHeap.isEmpty()){
                            Integer min = minHeap.poll();
                            Integer count = map.get(min);
                            if (count == null) continue;
                            if (count == 1) map.remove(min);
                            else map.put(min, count - 1);
                            break;
                        }
                    }
                }
            }

            if (map.isEmpty()) {
                sb.append("EMPTY").append("\n");
            } else {
                int max = check(maxHeap, map);
                int min = check(minHeap, map);
                sb.append(max).append(" ").append(min).append("\n");
            }
        }
        System.out.println(sb);
    }

    private static int check(PriorityQueue<Integer> pq, Map<Integer, Integer> map){
        while(!pq.isEmpty()){
            Integer poll = pq.poll();
            if(map.containsKey(poll)){
                return poll;
            }
        }

        return 0;
    }
}
