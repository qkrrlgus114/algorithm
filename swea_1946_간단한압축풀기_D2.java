import java.util.Scanner;

public class swea_1946_간단한압축풀기_D2 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int q = 1; q <= T; q++) {
			int N = sc.nextInt();
			char[] alpha = new char[N]; 
			int[] num = new int[N]; 
			int sum = 0;
			for(int i=0; i<N; i++) {
				alpha[i] = sc.next().charAt(0);
				num[i] = sc.nextInt();
				sum+=num[i];
			}
			int nasum = sum%10;
			sum -= nasum;
			System.out.printf("#%d\n",q);
			for(int i=0; i<N; i++) {
				while(num[i]!=0) {
					sum--;
					num[i]--;
					if(sum%10==0) System.out.printf("%c\n",alpha[i]);
					else System.out.print(alpha[i]);
				}
			}
			System.out.println();
		}
	}
}
