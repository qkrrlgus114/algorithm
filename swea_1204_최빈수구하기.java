import java.util.Scanner;

public class swea_1204_최빈수구하기 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int q = 1; q <= T; q++) {
			sc.nextInt();
			int[] students = new int[1000];
			int[] point = new int[101];
			for (int i = 0; i < students.length; i++) {
				students[i] = sc.nextInt();
			}
			for (int i = 0; i < students.length; i++) {
				point[students[i]]++;
			}
			int max = 0;
			for (int i = 0; i < point.length; i++) {
				if (max < point[i])
					max = point[i];
			}

			int maxidx = -1;
			for (int i = 0; i < point.length; i++) {
				if (point[i] == max) {
					if (maxidx < i)
						maxidx = i;
				}
			}
			System.out.printf("#%d %d\n",q,maxidx);
		}
	}
}