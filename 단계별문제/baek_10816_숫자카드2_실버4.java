package 단계별문제;

import java.util.Arrays;
import java.util.Scanner;

public class baek_10816_숫자카드2_실버4 {
	
	// lower bound
	// upper bound 개념 알아야 풀 수 있다고 한다...
	static int N;
	static int M;
	static int[] arr;
	static int[] search;
	static int count;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		arr = new int[N];
		for(int i=0; i<N; i++) {
			arr[i] = sc.nextInt();
		}
		M = sc.nextInt();
		search = new int[M];
		for(int i=0; i<M; i++) {
			search[i] = sc.nextInt();
		}
		Arrays.sort(arr);
		for(int i=0; i<M; i++) {
			count = 0;
			if(binarySearch(0, arr.length-1, i)) {
				System.out.print(count+" ");
			}
		}
	}
	
	public static boolean binarySearch(int st, int ed, int point) {
		// 종료
		if(st>ed) {
			return true;
		}
		
		// 재귀
		int mid = (st+ed)/2;
		
		if(arr[mid] < search[point]) {
			return binarySearch(mid+1, ed, point);
		}else if(arr[mid] > search[point]){
			return binarySearch(st, mid-1, point);
		}else {
			count++;
			binarySearch(mid+1, ed, point);
			binarySearch(st, mid-1, point);
			return true;
		}
	}
	
}
