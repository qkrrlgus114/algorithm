package 단계별문제;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class baek_숨바꼭질_1697_실버1 {
	static int N; // 수빈이 위치
	static int K; // 동생 위치
	static boolean[] visited; // 방문쳌
	static int[] result; // 이동 횟수 기록

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		K = sc.nextInt();
		visited = new boolean[1001]; // 최대 10만까지니
		result = new int[1001];

		BFS(N);
		System.out.println(Arrays.toString(result));
	}

	public static void BFS(int N) {
		Queue<Integer> q = new LinkedList<Integer>();
		q.add(N);
		visited[N] = true;
		result[N] = 0; // 결과배열에 우선 0 넣어줌
		while (!q.isEmpty()) {
			int curr = q.poll();
			if (curr == K) { // 이동해서 K에 도착하면 리턴
				return;
			}
			for (int i = 0; i < 3; i++) { // 3가지 경우를 보니깐
				if (i == 0) {
					// 현재 위치에서 1을 빼도 범위에 있고 false면
					if (curr - 1 >= 0 && !visited[curr - 1]) {
						visited[curr - 1] = true; // 체크하고
						q.add(curr - 1); // 넣고
						result[curr - 1] = result[curr] + 1; // 이전좌표에서 +1해줌
					}

				} else if (i == 1) {
					// 현재 위치에서 1을 더해도 범위에 있고 false면
					if (curr + 1 < 100001 && !visited[curr + 1]) {
						visited[curr + 1] = true; // 체크하고
						q.add(curr + 1); // 넣고
						result[curr + 1] = result[curr] + 1; // 이전좌표에서 +1해줌
					}
				} else if(i==2) {
					// 현재 위치에서 2를 곱해도 범위에 있고 false면
					if (curr * 2 < 100001 && !visited[curr * 2]) {
						visited[curr * 2] = true; // 체크하고
						q.add(curr * 2); // 넣고
						result[curr * 2] = result[curr] + 1; // 이전좌표에서 +1해줌
					}
				}
			}

		}
	}
}
