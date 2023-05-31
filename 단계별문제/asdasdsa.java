import java.util.*;

public class Main {
	static int[][] paper;
	static int N, M;
	static int[] count = new int[1001]; // 색종이 크기별 개수 저장

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		paper = new int[N][M];
		for (int i = 0; i < N; i++) {
			String s = sc.next();
			for (int j = 0; j < M; j++) {
				if (s.charAt(j) == '#') {
					paper[i][j] = 1; // 색칠된 칸은 1로 표시
				}
			}
		}
		sc.close();

		// 가능한 모든 색종이 크기를 생성하면서, 조건을 만족하는지 확인
		for (int i = 1; i <= 1000; i++) {
			int cnt = possible(i); // 해당 크기의 색종이를 사용할 수 있는 경우의 수 계산
			if (cnt == 0) { // 더 이상 색종이를 사용할 수 없는 경우
				break;
			}
			count[i] = cnt;
		}

		// 색종이 크기별 개수 출력
		int result = 0;
		for (int i = 1; i <= 1000; i++) {
			if (count[i] > 0) {
				result++;
			} else {
				break;
			}
		}
		System.out.println(result);
	}

	// 주어진 크기의 색종이를 사용할 수 있는 경우의 수를 계산하는 함수
	static int possible(int size) {
		int cnt = 0;
		for (int i = 0; i <= N - size; i++) { // 모눈 종이에서 색종이가 놓일 수 있는 행 범위
			for (int j = 0; j <= M - size; j++) { // 모눈 종이에서 색종이가 놓일 수 있는 열 범위
				boolean flag = true;
				for (int r = i; r < i + size; r++) { // 색종이를 놓을 영역에 대해 확인
					for (int c = j; c < j + size; c++) {
						if (paper[r][c] == 1) { // 이미 색칠된 칸이라면
							flag = false;
							break;
						}
					}
					if (!flag) { // 이미 색칠된 칸이 있으면, 다음 영역으로 이동
						break;
					}
				}
				if (flag) { // 모두 색칠되지 않은 칸이면 색종이를 붙일 수 있음
					for (int r = i; r < i + size; r++) {
						for (int c = j; c < j + size; c++) {
							paper[r][c] = 1; // 색종이를 붙임
						}
					}
					cnt++;
				}
			}
		}
		return cnt;
	}
}