import java.util.Arrays;
import java.util.Scanner;

public class baek_12015_가장긴증가하는부분수열2_골드2 {
	static int[] memo;
	static int[] arr;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		arr = new int[N];
		for(int i=0; i<N; i++) {
			arr[i] = sc.nextInt();
		}
		
		memo = new int[N+1];
		memo[0] = Integer.MIN_VALUE;
		int len = 0;
		int idx = 0;
		for(int i=0; i<N; i++) {
			// arr배열의 값이 더 크다면
			if(arr[i] > memo[len]) {
				len++; // 1 더하고
				memo[len] = arr[i]; // 그 위치에 집어넣는다.
			}else { // 아니라면
				idx = binarySearch(0, len, arr[i]);
				memo[idx] = arr[i];
			}
		}
		System.out.println(len);
		System.out.println(Arrays.toString(memo));
		
	}

	private static int binarySearch(int left, int right, int key) {
		int mid = 0;
		while(left<right) {
			 mid = (left+right)/2;
			 if(memo[mid]<key) {
				 left = mid+1;
			 }else {
				 right = mid;
			 }
		}
		return right;
	}
}
