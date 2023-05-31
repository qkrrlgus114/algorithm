package 단계별문제;

import java.util.Scanner;

public class baek_19949_영재의시험_실버3 {
	static int sum; // 점수의 합
	static int count; // 5이상인 점수의 개수 
	static int[] check; // 내가 체크한 정답
	static int[] right; // 답안지

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		right = new int[10];
		for (int i = 0; i < 10; i++) {
			right[i] = sc.nextInt(); // 답안지 입력 받기
		}
		check = new int[10];
		sum = 0;
		count = 0;

		BFS(0);
		System.out.println(count);

	}

	public static void BFS(int depth) {
		if (depth == 10) { // depth가 10이 되면 10개 전부 봤으므로
			sum = 0; // sum을 0으로 초기화 하고
			for (int i = 0; i < 10; i++) { // 체크한 답이랑 답안지랑 비교해서 같으면 
				if (right[i] == check[i]) {
					sum++; // 1 더해준다.
				}
			}
			if (sum >= 5) { // sum이 5 이상이면 카운트 1 증가
				count++;
			}
			return;
		}
		for (int j = 1; j <= 5; j++) {
			if (depth > 1 && check[depth - 1] == check[depth - 2] && check[depth - 1] == j) { // 우선 depth가 2 이상이어야 하고
				// 이전 2개의 값이 서로 같고, 현재 내가 고른 정답인 j랑 같으면 3개가 연속되는 경우니 건너뛴다.
				continue;
			}
			check[depth] = j;
			BFS(depth + 1);
		}
	}

}
