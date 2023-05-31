package 단계별문제;

import java.util.Scanner;

public class baek_10870_피보나치수5_브2 {
	static int N;
	static int sum;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		System.out.println(fibonacci(N));
	}
	
	public static int fibonacci(int x) {
		if(x==0) {
			return 0;
		} else if(x==1) {
			return 1;
		}
		
		return fibonacci(x-1) + fibonacci(x-2);
	}
}
