package 단계별문제;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class baek_4963_섬의개수_실버2 {
	static int N;
	static int M;
	static Queue<Integer> qx;
	static Queue<Integer> qy;
	static boolean[][] visited;
	static int[][] map;
	// 상 우 하 좌 좌상 우상 우하 좌하
	static int[] dr = {-1, 0, 1, 0, -1, -1, 1, 1};
	static int[] dc = {0, 1, 0, -1, -1, 1, 1, -1};
	static int cnt = 0;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while(true) {
			M = sc.nextInt();
			N = sc.nextInt();
			if(M==0 && N==0) break;
			qx = new LinkedList<Integer>();
			qy = new LinkedList<Integer>();
			visited = new boolean[N][M];
			map = new int[N][M];
			for(int i=0; i<N; i++) {
				for(int j=0; j<M; j++) {
					map[i][j] = sc.nextInt();
				}
			}
			int cnt = 0;
			for(int i=0; i<N; i++) {
				for(int j=0; j<M; j++) {
					if(map[i][j]==1 && !visited[i][j]) {
						visited[i][j] = true;
						BFS(i,j);
						cnt++;
					}
				}
		}
			System.out. println(cnt);
		}
		
	}
	public static void BFS(int y, int x) {
		qx.add(x);
		qy.add(y);
		cnt++;
		while(!qx.isEmpty()) {
			int idc = qx.poll();
			int idr = qy.poll();
			// 팔방을 전부 탐색
			for(int i=0; i<8; i++) {
				int nr = idr+dr[i];
				int nc = idc+dc[i];
				if(nc>=0 && nr<N && nr>=0 && nc<M) {
					if(map[nr][nc]==1 && !visited[nr][nc]) {
						qx.add(nc);
						qy.add(nr);
						visited[nr][nc] = true;
					}
				}
			}
		}
	}
}
