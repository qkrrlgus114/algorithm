package 단계별문제;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class baek_7562_나이트의이동_실버1 {
	
	static int[][] map;
	//2차 방문 배열
	static boolean[][] visited;
	//도착 지점의 좌표
	static int fx;
	static int fy;
	static int cnt;
	//8방향을 확인한다.
	static int[] dr = {-2, -1, 1, 2, 2, 1, -1, -2};
	static int[] dc = {1, 2, 2, 1, -1, -2, -2, -1};
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			int N = sc.nextInt();
			cnt = 0;
			map = new int[N][N];
			visited = new boolean[N][N];
			int x = sc.nextInt();
			int y = sc.nextInt();
			fx = sc.nextInt();
			fy = sc.nextInt();
			
			System.out.println(BFS(x,y,N,cnt));
			
		}
	}
	
	static int BFS(int x, int y, int N, int cnt) {
		Queue<int[]> q = new LinkedList<int[]>();
		q.add(new int[] {x,y,cnt});
		
		while(!q.isEmpty()) {
			x = q.peek()[0];
			y = q.peek()[1];
			cnt = q.peek()[2];
			visited[x][y] = true;
			q.poll();
			for(int i=0; i<8; i++) {
				int idx = x + dr[i];
				int idy = y + dc[i];
				// 범위체크
				if(idx >=0 && idy >= 0 && idx < N && idy < N) {
					if(!visited[idx][idy]) {
						visited[idx][idy] = true; // 너 택했어.
						if(idx==fx && idy==fy) {
							return cnt+1;
						}
						q.add(new int[] {idx,idy,cnt+1});
					}
				}
			}
		}
		return 0;
		
	}
}
