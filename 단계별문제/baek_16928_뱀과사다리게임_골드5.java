package 단계별문제;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class baek_16928_뱀과사다리게임_골드5 {
	static int snake;
	static int ladder;
	static boolean[] visited;
	static int[] map;
	static int cnt = 0;
	static int[] list;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		ladder = sc.nextInt();
		snake =sc.nextInt();
		list = new int[101]; // 
		visited = new boolean[101]; // 방문체크
		map = new int[101]; // 맵의 이동 횟수 확인
		for(int i=0; i<snake+ladder; i++) {
			int st = sc.nextInt();
			int ed = sc.nextInt();
			list[st]=ed;
		}

		BFS(1);

	}
	
	public static void BFS(int position) {
		Queue<Integer> q = new LinkedList<>();
		q.add(position);
		visited[position] = true;
		
		while(!q.isEmpty()) {
			int curr = q.poll();
			if(curr==100) {
				System.out.println(map[100]);
				break;
			}
//			System.out.println(curr);
			for(int i=1; i<=6; i++) {
				int temp = curr + i;
//				System.out.println(temp);
				if(temp>100) break;
				if(visited[temp]) continue;
				visited[temp] = true;
				map[temp] = map[curr] + 1;
				// 사다리 or 뱀이 존재한다면
				if(list[temp]!=0) {
					int ftemp = list[temp];
					if (visited[ftemp]) continue;
					visited[ftemp]=true;
//					System.out.println(ftemp);
					q.add(ftemp);
					map[ftemp] = map[curr] + 1; 
//					System.out.println(Arrays.toString(map));
				} else { // 없다면
					q.add(temp);
				}
			}
		}
	}
	
}
