import java.util.Arrays;
import java.util.Scanner;

public class baek_11399_ATM_실버4 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N =sc.nextInt();
		int[] p = new int[N];
		int sum = 0;
		for(int i=0; i<N; i++) {
			p[i] = sc.nextInt();
		}
		Arrays.sort(p);
		
		for(int i=0; i<N; i++) {
			for(int j=0; j<i+1; j++) {
				sum+=p[j];
			}
		}
		System.out.println(sum);
	}
}
