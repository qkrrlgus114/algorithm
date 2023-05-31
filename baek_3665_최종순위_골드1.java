import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;


public class baek_3665_최종순위_골드1 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int tc=1; tc<=T; tc++) {
			int V = sc.nextInt();
			int[] win = new int[V+1]; // 작년 정보를 받는 배열
			for(int i=1; i<V+1; i++) {
				win[i] = sc.nextInt();
			}
			int E = sc.nextInt();
			List<Integer>[] list = new ArrayList[V+1]; // 배열 리스트 생성
			List<Integer> result = new ArrayList<>(); // 결과 저장할 리스트 성성
			int[] inde = new int[V+1];
			
			for(int i=0; i<V+1; i++) {
				list[i] = new ArrayList<>();
			}
			
			for(int i=1; i<V; i++) {
				for(int j=i+1; j<=V; j++) {
					list[win[i]].add(win[j]);
					inde[win[j]]++;
				}
			}
			for(int i=0; i<E; i++) {
				int st = sc.nextInt();
				int ed = sc.nextInt();
				if(list[ed].contains(st)) {
					for(int j=0; j<list[ed].size(); j++) {
						if(list[ed].get(j)==st) {
							list[ed].remove(j);
							inde[st]--;
							break;
						}
					}
					list[st].add(ed);
					inde[ed]++;					
				} else {
					for(int j=0; j<list[st].size(); j++) {
						if(list[st].get(j)==ed) {
							list[st].remove(j);
							inde[ed]--;
							break;
						}
					}
					list[ed].add(st);
					inde[st]++;
				}
			}
			Queue<Integer> q = new LinkedList<Integer>();
			
			for(int i=1; i<inde.length; i++) {
				if(inde[i]==0) {
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
			boolean flag = true;
			for(int i=0; i<inde.length; i++) {
				if(inde[i]!=0) {
					flag = false;
					break;
				}
			}
			if(flag==false) {
				System.out.print("IMPOSSIBLE");
			}else {
				for(int i=0; i<result.size(); i++) {
					System.out.print(result.get(i)+" ");
				}				
			}
			System.out.println();
		}
	}
}
