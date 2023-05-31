import java.util.Scanner;

public class swea_1217_거듭제곱_D3 {
	public static int N;
	public static int M;
	public static int tc;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		for (int i = 0; i < 10; i++) {
			tc = sc.nextInt();
			N = sc.nextInt();
			M = sc.nextInt() - 1;
			cal(N);
		}
	}

	// 제곱을 하는 함수
	public static void cal(int x) {
		x *= N;
		M--;
		if (M != 0) {
			cal(x);
		} else {
			System.out.printf("#%d %d\n",tc,x);
		}
	}
}
