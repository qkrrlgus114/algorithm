import java.util.Scanner;

public class swea_수영장 {
	static int[] cost; // 가격
	static int[] pickmonth;
	static int max;
	static int sum;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			sum = 0;
			cost = new int[4];
			for (int i = 0; i < 4; i++) {
				cost[i] = sc.nextInt();
			}
			max = cost[3]; // 최대가격을 우선 1년으로 초기화.
			pickmonth = new int[12];
			for (int i = 0; i < 12; i++) {
				pickmonth[i] = sc.nextInt();
			}

			back(0);

			System.out.printf("#%d %d\n", tc, max);
		}
	}

	private static void back(int depth) {
		if (depth >= 12) {
			if (max > sum)
				max = sum;
			return;
		}
		// 1일권 확인
		if (max >= sum + pickmonth[depth] * cost[0]) {
			sum += pickmonth[depth] * cost[0];
			back(depth + 1);
			sum -= pickmonth[depth] * cost[0];
		}
		// 한 달권 확인
		if (max >= sum + cost[1]) {
			sum += cost[1];
			back(depth + 1);
			sum -= cost[1];
		}
		// 세 달권 확인
		if (max >= sum + cost[2]) {
			sum += cost[2];
			back(depth + 3);
			sum -= cost[2];
		}
	}
}
