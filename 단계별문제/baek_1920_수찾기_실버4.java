package 단계별문제;

import java.util.Arrays;
import java.util.Scanner;

public class baek_1920_수찾기_실버4 {
	static int N;
	static int[] arr;
	static int M;
	static int[] search;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		arr = new int[N];
		for (int i = 0; i < N; i++) {
			arr[i] = sc.nextInt();
		}
		M = sc.nextInt();
		search = new int[M];
		for (int i = 0; i < M; i++) {
			search[i] = sc.nextInt();
		}
		Arrays.sort(arr);
		for(int i=0; i<M; i++) {
			if (binarySerach(0, arr.length - 1, i)) {
				System.out.println(1);
			} else {
				System.out.println(0);
			}
		}

	}

	public static boolean binarySerach(int st, int ed, int point) {
		// 종료
		if(st>ed) return false;
		// 재귀
		int mid = (st + ed) / 2;

		// 같다면
		if (arr[mid] == search[point])
			return true;

		// key가 더 크다
		if (arr[mid] < search[point]) {
			return binarySerach(mid + 1, ed, point);
		}
		// key가 더 작다.
		else {
			return binarySerach(st, mid - 1, point);
		}
	}
}
