package 스터디문제;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

// 상하좌우 탐색 필요. 대각선X
// 좌표로 지렁이의 위치가 주어지므로 행렬 사용
// 맵을 전체 탐색 돌리면서 1이면 0으로 bfs하면서 해당 지점 카운트.

public class baek_1012_유기농배추_실버2 {
	static int[][] map;
	static int cnt = 0;
	static int[] dr = {-1, 1, 0, 0};
	static int[] dc = {0, 0, -1, 1};
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int tc=1; tc<=T; tc++) {
			cnt=0;
			int W = sc.nextInt();
			int H = sc.nextInt();
			int baechu = sc.nextInt();
			map = new int[H][W];
			for(int i=0; i<baechu; i++) {
				int x = sc.nextInt();
				int y = sc.nextInt();
				map[y][x] = 1;
			}
			
			for(int i=0; i<H; i++) {
				for(int j=0; j<W; j++) {
					if(map[i][j] == 1) {
						BFS(i, j, H, W);
					}
				}
			}
			System.out.println(cnt);
		}
		
	}

	private static void BFS(int x, int y, int H, int W) {
		Queue<int[]> q = new LinkedList<int[]>();
		q.add(new int[] {x,y});
		cnt++;
		map[x][y] = 0;
		
		while(!q.isEmpty()) {
			x = q.peek()[0];
			y = q.peek()[1];
			q.poll();
			for(int i=0; i<4; i++) {
				int idr = x+dr[i];
				int idc = y+dc[i];
				if(idr>=0 && idc>=0 && idr<H && idc<W) {
					if(map[idr][idc]==1) {
						map[idr][idc] = 0;
						q.add(new int[] {idr, idc});
					}
				}
			}
		}
		
	}
}
