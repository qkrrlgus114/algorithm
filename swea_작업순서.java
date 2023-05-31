import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class swea_작업순서 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		for(int tc=1; tc<=10; tc++) {
			int V = sc.nextInt();
			int E = sc.nextInt();
			
			List<Integer>[] list = new ArrayList[V+1];
			for(int i=0; i<V+1; i++) {
				list[i] = new ArrayList<>();
			}
			int[] inde = new int[V+1];
			List<Integer> result = new ArrayList<>();
			
			for(int i=0; i<E; i++) {
				int st = sc.nextInt();
				int ed = sc.nextInt();
				list[st].add(ed); // 유향이니깐 하나만 넣는다.
				inde[ed]++;
			}
			
			Queue<Integer> q = new LinkedList<Integer>();
			
			for(int i=1; i<V+1; i++) {
				if(inde[i]==0) { // 해당 진입차수가 0이면 넣겠다.
					q.add(i);
				}
			}
			
			while(!q.isEmpty()) {
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
			
			System.out.printf("#%d ",tc);
			for(int i=0; i<result.size(); i++) {
				if(result.get(i)!=0) {
					System.out.print(result.get(i)+" ");
				}
			}
			System.out.println();
		}
	}
}
