import java.util.Arrays;
import java.util.Scanner;

public class baek_11048_이동하기_실버2 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();
		int[][] map = new int[N + 1][M + 1];
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= M; j++) {
				map[i][j] = sc.nextInt();
			}
		}
		int[][] arr = new int[N + 1][M + 1];

		arr[1][1] = map[1][1];
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= M; j++) {
				arr[i][j] = Math.max(arr[i-1][j], Math.max(arr[i-1][j-1], arr[i][j-1])) + map[i][j];
			}
		}
		System.out.println(arr[N][M]);
	}
}
