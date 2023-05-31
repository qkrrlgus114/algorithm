import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Scanner;

public class baek_16953_A_B_실버2 {
	static Map<Long, Boolean> visited;
	static Map<Long, Long> result;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		long start = sc.nextInt();
		long target = sc.nextInt();
		visited = new HashMap<>();
		result = new HashMap<>();
		
		System.out.println(bfs(start,target));
	}
	
	public static long bfs(long start, long target) {
		Queue<Long> q = new LinkedList<>();
		q.add(start);
		visited.put(start, true);
		result.put(start, 1L);
		boolean flag = false;
		
		while(!q.isEmpty()) {
			Long curr = q.poll();
			if(curr*2<=target && !visited.containsKey(curr*2)) { // get으로 하면 널값도 가져올 수 있어서 확인해야함
				visited.put(curr*2, true);
				result.put(curr*2, result.get(curr)+1);
				q.add(curr*2);
			}
			if(curr*10+1<=target && !visited.containsKey(curr*10+1)) { // get으로 하면 널값도 가져올 수 있어서 확인해야함
				visited.put(curr*10+1, true);
				result.put(curr*10+1, result.get(curr)+1);
				q.add(curr*10+1);
			}
			if(curr*2 == target || curr*10+1 == target) {
				flag = true;
				break;
			}
		}
		if(flag==true) {
			return result.get(target);
		}else {
			return -1;
		}
	}
}
