package 단계별문제;

import java.util.Arrays;
import java.util.Scanner;

public class baek_10819_차이를최대로_실버2 {
	static int[] check;
	static int[] arr;
	static int N;
	static int sum = 0;
	static int max = 0;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		arr = new int[N];
		check = new int[N];
		for(int i=0; i<N; i++) {
			arr[i] = sc.nextInt();
			check[i] = arr[i];
		}
		sum = 0;
		for(int i=0; i<N-1; i++) {
			sum+= Math.abs(arr[i] - arr[i+1]);
		}
		if(sum>max) max = sum;
		
		back(0);
		System.out.println(max);
		
	}
	
	public static void back(int depth) {
		if(depth==N-1) {
			sum = 0;
			for(int i=0; i<N-1; i++) {
				sum+= Math.abs(check[i] - check[i+1]);
			}
			if(sum>max) max = sum;
			return;
		}
		
		for(int i=0; i<N-1; i++) {
			swap(i,i+1);
			back(depth+1);

		}
	}
	
	public static void swap(int x, int y) {
		int temp = check[x];
		check[x] = check[y];
		check[y] = temp;
	}
}
