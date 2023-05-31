import java.util.Scanner;

public class 블럭쌓기 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[][] map = new int[N][N];
		int[] input = new int[map.length];
		// 입력 배열에 집어넣기
		for (int i = 0; i < input.length; i++) {
			input[i] = sc.nextInt();
		}
		// input 배열 map에 집어넣기
		int j = 0;
		for (int k = 0; k < N; k++, j++) {
			for (int i = N - 1; i >= N - input[k]; i--) {
				map[i][j] = 1;
			}
		}
		int max = 0;
		for(int l=0; l<map.length; l++) {
		for (int i = 0; i < map.length; i++) {
			// map[i][l]이 1이면 0을 세기 위해 동작
				if (map[i][l] == 1) {
					int count = 0;
					for (int k = l; k < map.length; k++) {
						// map[i][k]가 0이면 개수 카운트
						if (map[i][k] == 0) {
							count += 1;
							// max를 최대로 갱신
							if (max < count) {
								max = count;
							}
						}
					}
				}
			}
		}
		System.out.println(max);
	}
}
