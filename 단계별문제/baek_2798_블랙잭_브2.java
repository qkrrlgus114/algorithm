package 단계별문제;

import java.util.Scanner;

public class baek_2798_블랙잭_브2 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt(); // 카드의 개수
		int M = sc.nextInt(); // 총 합
		
		int[] card = new int[N];
		for(int i=0; i<N; i++) {
			card[i] = sc.nextInt();
		}
		int max = Integer.MIN_VALUE;
		int sum = 0;
		for(int i=0; i<N-2; i++) {
			for(int j=1+i; j<N-1; j++) {
				sum = 0;
				for(int k=j+1; k<N; k++) {
					sum = card[i]+card[j]+card[k];
					if(sum<=M && max<sum) max = sum;
				}
			}
		}
		System.out.println(max);
		
	}
}
