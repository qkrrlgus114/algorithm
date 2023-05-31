import java.util.Scanner;

public class swea_수영장입니다 {
	static int[] cost;
	static int[] month;
	static int max;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			cost = new int[4];
			// 가격 입력 받음
			for (int i = 0; i < 4; i++) {
				cost[i] = sc.nextInt();
			}
			month = new int[12];
			// 이용 계획
			for (int i = 0; i < 12; i++) {
				month[i] = sc.nextInt();
			}

			max = cost[3]; // 1년이 최대니깐 초기화
			int sum = 0;
			BFS(0, sum);
			System.out.printf("#%d %d\n",tc,max);

		}
	}

	public static void BFS(int depth, int sum) {
		if (depth >= 12) {
			max = Math.min(max, sum);
			return;
		}
		
		// 1일 이용권
		BFS(depth+1, sum+cost[0]*month[depth]);
		// 한 달 이용권
		BFS(depth+1, sum+cost[1]);
		// 세 달 이용권
		BFS(depth+3, sum+cost[2]);
	}
}
