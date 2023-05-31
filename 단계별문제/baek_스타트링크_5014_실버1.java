package 단계별문제;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class baek_스타트링크_5014_실버1 {
	static boolean[] visited;
	static int[] result;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int F = sc.nextInt(); // 전체 층
		int S = sc.nextInt(); // 현재 위치
		int G = sc.nextInt(); // 회사 위치
		int U = sc.nextInt(); // up층
		int D = sc.nextInt(); // down층

		visited = new boolean[F + 1];
		result = new int[F + 1];
		BFS(F, S, G, U, D);
		if(S==G) {
			System.out.println(0);
		}else {
			if(result[G]==0) {
				System.out.println("use the stairs");
			}else {
				System.out.println(result[G]);			
			}
			
		}
	}

	public static void BFS(int F, int S, int G, int U, int D) {
		Queue<Integer> q = new LinkedList<Integer>();
		q.add(S);
		visited[S] = true;
		result[S] = 0;

		while (!q.isEmpty()) {
			int curr = q.poll();
			if(curr == G) {
				return;
			}
			for (int i = 0; i < 2; i++) {
				if (i == 0) {
					if (curr + U <= F && !visited[curr + U]) {// 올라가자
						result[curr + U] = result[curr] + 1;
						visited[curr + U] = true;
						q.add(curr+U);
					}
				}
				if (i == 1) {
					if (curr - D >= 1 && !visited[curr - D]) {// 올라가자
						result[curr - D] = result[curr] + 1;
						visited[curr - D] = true;
						q.add(curr-D);
					}
				}

			}

		}
	}
}
