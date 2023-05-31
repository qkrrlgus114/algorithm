package 스터디문제;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class baek_2583_영역구하기_실버1 {
	static int H;
	static int W;
	static int[][] map;
	static int[] dr = {-1,1,0,0};
	static int[] dc = {0,0,-1,1};
	static int cnt;
	static int ground = 0;
	static List<Integer> list = new ArrayList<Integer>();
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		H = sc.nextInt();
		W = sc.nextInt();
		map = new int[H+1][W+1];
		int K = sc.nextInt();
		for(int tc=0; tc<K; tc++) {
			int y1 = sc.nextInt();
			int x1 = sc.nextInt();
			int y2 = sc.nextInt();
			int x2 = sc.nextInt();
			for(int i=x1; i<x2; i++) {
				for(int j=y1; j<y2; j++) {
					map[i][j] = 1;
				}
			}
		}
		for(int i=0; i<H; i++) {
			for(int j=0; j<W; j++) {
				if(map[i][j]==0) {
					cnt = 1;
					ground++;
					BFS(i,j);
				}
			}
		}
		Collections.sort(list);
		System.out.println(ground);
		for(int i=0; i<list.size(); i++) {
			System.out.print(list.get(i)+" ");
		}
	}

	private static void BFS(int x, int y) {
		Queue<int[]> q = new LinkedList<int[]>();
		q.add(new int[] {x,y});
		map[x][y] = 1;
		
		while(!q.isEmpty()) {
			x = q.peek()[0];
			y = q.peek()[1];
			q.poll();
			for(int i=0; i<4; i++) {
				int idr = dr[i]+x;
				int idc = dc[i]+y;
				if(idr>=0 && idc>=0 && idr<H && idc<W) {
					if(map[idr][idc]==0) {
						cnt++;
						map[idr][idc] = 1;
						q.add(new int[] {idr,idc});
					}
				}
			}
		}
		list.add(cnt);
		
	}
}
