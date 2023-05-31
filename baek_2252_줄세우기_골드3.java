import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class baek_2252_줄세우기_골드3 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int V = sc.nextInt();
		int E = sc.nextInt();
		List<Integer>[] list = new ArrayList[V + 1];
		for(int i=0 ;i<V+1; i++) {
			list[i] = new ArrayList<>();
		}
		List<Integer> result = new ArrayList<>();
		int[] inde = new int[V + 1];

		for (int i = 0; i < E; i++) {
			int st = sc.nextInt();
			int ed = sc.nextInt();

			list[st].add(ed);
			inde[ed]++;
		}

		Queue<Integer> q = new LinkedList<Integer>();

		for (int i = 1; i < V + 1; i++) {
			if (inde[i] == 0) {
				q.add(i);
			}
		}

		while (!q.isEmpty()) {
			int curr = q.poll();
			result.add(curr);
			for(int i=0; i<list[curr].size(); i++) {
				int temp = list[curr].get(i);
				inde[temp]--;
				if(inde[temp]==0) {
					q.add(temp);
				}
			}
		}
		for(int i=0; i<result.size(); i++) {
			System.out.print(result.get(i)+" ");
		}
	}
}
