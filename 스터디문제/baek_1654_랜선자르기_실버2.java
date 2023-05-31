package 스터디문제;

import java.util.Arrays;
import java.util.Scanner;

public class baek_1654_랜선자르기_실버2 {
	static long K;
	static long N;
	static long[] line;
	static long max = Integer.MIN_VALUE;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		K = sc.nextInt();
		N = sc.nextInt();
		line = new long[(int) K];
		for (int i = 0; i < K; i++) {
			line[i] = sc.nextInt();
		}
		Arrays.sort(line);
		System.out.println(binarySearch(1, line[(int) (K-1)]));
	}

	public static long binarySearch(long left, long right) {
		if (left > right) {
			return right;
		}

		long mid = (left + right) / 2;

		long count = 0;
		if (line[(int) (K - 1)] >= mid) {
			for (long i = K - 1; i >= 0; i--) {
				if (line[(int) i] >= mid) {
					count += line[(int) i] / mid;
				}
			}
		}

		if (count == N) {
			if(max<mid) max = mid;
			return binarySearch(mid + 1, right);
		}
		if (count > N) {
			return binarySearch(mid + 1, right);
		}
		if(count<N) {
			return binarySearch(left, mid-1);
		}
		return max;
	}
}
