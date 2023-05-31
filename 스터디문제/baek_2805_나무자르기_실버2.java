package 스터디문제;

import java.util.Arrays;
import java.util.Scanner;

public class baek_2805_나무자르기_실버2 {
	static long N;
	static long M;
	static long[] trees;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		trees = new long[(int) N];
		for (int i = 0; i < N; i++) {
			trees[i] = sc.nextInt();
		}
		Arrays.sort(trees); // 이분탐색이니 정렬은 필수
		long result = binarySearch(0, trees[(int) (N - 1)]); // 0부터 최댓값까지 넣음
		System.out.println(result);
	}

	public static long binarySearch(long left, long right) { // 이분탐색 진행
		if (left > right) { // left가 넘으면 right의 값을 반환
			return right;		
		}
		long mid = (left + right) / 2;
		long count = 0;
		for (long i = N - 1; i >= 0; i--) { // 최댓값부터 봄
			if (trees[(int) i] > mid) { // 나무의 길이가 mid보다 크면 자를 수 있으니
				count += trees[(int) i] - mid; // 잘라서 카운트에 넣는다
				if (count > M)
					break;
			}
		}
		if (count > M) { // count가 크면 너무 많이 잘랐다는 소리니깐 절단기의 높이를 높여준다.
			return binarySearch(mid + 1, right);
			
		}
		if (count < M) { // count가 작으면 덜 잘랐다는 소리니깐 절단기의 높이를 낮춘다.
			return binarySearch(left, mid - 1);
		}
		return mid;
	}
}
