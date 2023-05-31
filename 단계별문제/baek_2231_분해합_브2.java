package 단계별문제;

import java.util.Scanner;

public class baek_2231_분해합_브2 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();
		int min = Integer.MAX_VALUE;
		for(int i=1; i<=num; i++) {
			int temp = i;
			int sum = 0;
			while(temp!=0) {
				sum += temp%10;
				temp /= 10;
			}
			sum+=i;
			if(sum==num && i<min) {
				min = i; 
			}
		}
		if(min == Integer.MAX_VALUE) min = 0;
		System.out.println(min);
	}
}
