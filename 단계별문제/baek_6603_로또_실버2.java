package 단계별문제;

import java.util.Scanner;

public class baek_6603_로또_실버2 {
	static int N;
	static int[] arr;
	static int[] result;
	static boolean[] visited;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		boolean flag = true;
		while (flag == true) { // true일 때 동작
			N = sc.nextInt();
			if (N != 0) { // N이 0이 아니면
				arr = new int[N]; // 입력 받을 배열
				result = new int[6]; // 6개 뽑을 배열
				visited = new boolean[N]; // 방문 체크 배열

				for (int i = 0; i < N; i++) {
					arr[i] = sc.nextInt(); // 입력 받음
				}
				Back(0,0);
				System.out.println();
			} else {
				flag=false;
			}
		}
	}

	public static void Back(int depth, int start) {
		if (depth == 6) { // 6개 다 뽑았으면 전체 출력
			for (int i = 0; i < 6; i++) {
				System.out.print(result[i] + " ");
			}
			System.out.println();
			return;
		}

		for (int i = start; i < N; i++) { // start를 매개변수로 받아서
			// start 이후만 뽑게 설정 (이전 수를 뽑지 않음)
			if (visited[i])
				continue;

			visited[i] = true;
			result[depth] = arr[i];
			Back(depth + 1, i);
			visited[i] = false;
		}
	}
}
