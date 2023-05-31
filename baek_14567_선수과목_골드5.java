import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class baek_14567_선수과목_골드5 {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int V = sc.nextInt(); // 정점
		int E = sc.nextInt(); // 간선
		int[] count = new int[V+1]; // 카운트를 세기 위한 배열
		List<Integer>[] list = new ArrayList[V+1]; // 간선 담을 배열
		for(int i=0; i<V+1; i++) {
			list[i] = new ArrayList<>();
		}
		// 큐에 해당 간선 번호랑 카운트를 들고다니기 위해 int[]넣어줌
		Queue<int[]> q = new LinkedList<>();
		
		int[] inde = new int[V+1]; // 진입 차수
		
		for(int i=0; i<E; i++) {
			int st = sc.nextInt();
			int ed = sc.nextInt();
			list[st].add(ed);
			inde[ed]++;
		}
		
		for(int i=1; i<V+1; i++) {
			if(inde[i]==0) {
				q.add(new int[] {i,1}); // i번째는 1학기부터 듣는다고 시작.
			}
		}
		
		while(!q.isEmpty()) {
			int curr = q.peek()[0]; // 해당 정점
			int tcnt = q.peek()[1]; // 해당 학기
			q.poll();
			count[curr] = tcnt; // 우선 해당 학기 넣어줌.
			
			for(int i=0; i<list[curr].size(); i++) {
				int temp = list[curr].get(i);
				inde[temp]--;
				if(inde[temp]==0) { // 0이 됐으면
					// 큐에 해당 정점과 이전 부모의 학기+1을 해줌.
					q.add(new int[] {temp,count[curr]+1});
				}
			}
		}
		for(int i=1; i<count.length; i++){
			if(count[i]!=0) {
				System.out.print(count[i]+" ");
			}
		}
	}
}
