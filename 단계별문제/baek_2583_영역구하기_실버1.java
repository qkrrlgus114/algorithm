package 단계별문제;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;

public class baek_2583_영역구하기_실버1 {
	static int W;
	static int H;
	static int[][] map;
	static int[] dr = {-1,1,0,0};
	static int[] dc = {0,0,-1,1};
	static int[][] arr;
	static boolean[][] visited;
	static int change=2;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		H = sc.nextInt();
		W = sc.nextInt();
		map = new int[H][W];
		int k = sc.nextInt();
		int[] count = new int[1000];
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		visited = new boolean[H][W];
		for(int i=0; i<k; i++) {
			 int x1 = sc.nextInt();
			 int y1 = sc.nextInt();
			 int x2 = sc.nextInt();
			 int y2 = sc.nextInt();
			 int cnt = 1;
			 for(int j=y1; j<y2; j++) {
				 for(int l=x1; l<x2; l++) {
					 map[j][l] = cnt;
				 }
			 }
			 cnt++;
		}
		for(int i=0; i<H; i++) {
			for (int j=0; j<W; j++) {
				if(map[i][j]==0) {
					BFS(i,j);
					change++;
				}
			}
		}
//		for(int i=0; i<H; i++) {
//			System.out.println(Arrays.toString(map[i]));
//		}
		for(int i=0; i<H; i++) {
			for(int j=0; j<W; j++) {
				count[map[i][j]]++;
			}
		}
		for(int i=2; i<count.length; i++) {
			if(count[i]!=0) {
				pq.add(count[i]);
			}
		}
		System.out.println(pq.size());
		while(!pq.isEmpty()) {
			System.out.print(pq.poll()+" ");
		}
	}
	
	public static void BFS(int x, int y) {
		Queue<int[]> q = new LinkedList<>();
		q.add(new int[] {x,y});
		visited[x][y] = true;
		map[x][y] = change;
		
		while(!q.isEmpty()) {
			x = q.peek()[0];
			y = q.peek()[1];
			q.poll();
			for(int i=0; i<4; i++) {
				int idx = x + dr[i];
				int idy = y + dc[i];
				if(idx>=0 && idy>=0 && idx<H && idy<W) {
					if(map[idx][idy]==0 && !visited[idx][idy]) {
						visited[idx][idy] = true;
						map[idx][idy] = change;
						q.add(new int[] {idx, idy});
					}
					
				}
				
			}
		}
	}
}
