package 단계별문제;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class baek_2667_단지번호붙이기_실버1 {
	static int N;
	static Queue<Integer> qx;
	static Queue<Integer> qy;
	static boolean[][] visited; // 방문 체크
	static int[][] map; // 맵
	// 상 우 하 좌
	static int[] dr = { -1, 0, 1, 0 };
	static int[] dc = { 0, 1, 0, -1 };
	static int cnt = 0; // 단지의 수
	static int[] arr = new int[25*25]; // 단지를 넣고 정렬하기 위한 배열
	static int land = 0; // 랜드의 수

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = 0;
		N = sc.nextInt();
		qx = new LinkedList<Integer>();
		qy = new LinkedList<Integer>();
		visited = new boolean[N][N];
		map = new int[N][N];
		// 맵에 입력 받음
		for (int i = 0; i < N; i++) {
			String str = sc.next();
			for (int j = 0; j < N; j++) {
				map[i][j] = str.charAt(j)-'0';
			}
		}
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				// 1이고 false면 보겠다.
				if (map[i][j] == 1 && !visited[i][j]) {
					cnt = 0;
					visited[i][j] = true;
					BFS(i, j); // bfs 돌기 시작
					arr[n++] = cnt; // arr에 cnt 저장
					land++; // 랜드 1 늘려줌.
				}
			}
		}
		// 정렬해서 출력한다.
		Arrays.sort(arr);
		System.out.println(land);
		for(int i=1; i<arr.length; i++) {
			if(arr[i]!=0) System.out.println(arr[i]); 
		}
	}

	public static void BFS(int y, int x) {
		qx.add(x);
		qy.add(y);
		cnt++;
		while (!qx.isEmpty()) {
			int idc = qx.poll();
			int idr = qy.poll();
			// 사방을 전부 탐색
			for (int i = 0; i < 4; i++) {
				int nr = idr + dr[i];
				int nc = idc + dc[i];
				if (nc >= 0 && nr < N && nr >= 0 && nc < N) {
					if (map[nr][nc] == 1 && !visited[nr][nc]) {
						cnt++;
						qx.add(nc);
						qy.add(nr);
						visited[nr][nc] = true;
					}
				}
			}
		}
	}
}
