import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class baek_15686_치킨배달_골드5 {
	static int[][] map; // 맵
	static int[][] chickenMap; // 치킨집 좌표 저장
	static int N;
	static int M;
	static boolean[] open;
	static int chickenMin = Integer.MAX_VALUE;
	static int finalMin = 0;
	static int realFinalMin = Integer.MAX_VALUE;
	static int temp;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt(); // 맵의 크기
		M = sc.nextInt(); // 뽑아낼 치킨집
		map = new int[N + 2][N + 2];
		chickenMap = new int[N * N][2]; // 치킨집의 좌표
		open = new boolean[N * N];
		List<Integer> tempList = new ArrayList<>(); // 각 치킨집마다 제일 가까운 집의 거리를 넣을 리스트
		temp = 0;
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= N; j++) {
				map[i][j] = sc.nextInt();
				if (map[i][j] == 2) { // 치킨집이면 좌표 구해야함.
					chickenMap[temp][0] = i;
					chickenMap[temp++][1] = j;
				}
			}
		}
		DFS(0, 0);
		System.out.println(realFinalMin);

	}

	public static void DFS(int start, int depth) {
		if (depth == M) { // 종료조건
			int sum = 0;
			for (int i = 1; i <= N; i++) {
				for (int j = 1; j <= N; j++) {
					if (map[i][j] == 1) { // 집이면
						for (int k = 0; k < temp; k++) {
							if (open[k]) { // 열었으면
								sum = Math.abs(i - chickenMap[k][0]) + Math.abs(j - chickenMap[k][1]);
								if (sum > 0 && chickenMin > sum) {
									chickenMin = sum;
								}
							}
						}
						if(chickenMin!=Integer.MAX_VALUE) {
							finalMin += chickenMin;							
						}
						System.out.println(finalMin);
						chickenMin = Integer.MAX_VALUE;
					}
				}
			}
			if(realFinalMin<finalMin) {
				realFinalMin = finalMin;
				finalMin = 0;
			}
			return;
		}

		for (int i = start; i < chickenMap.length; i++) {
			open[i] = true;
			DFS(start + 1, depth + 1);
		}
	}

}
