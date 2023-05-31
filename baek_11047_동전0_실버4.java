import java.util.Scanner;

public class baek_11047_동전0_실버4 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int K = sc.nextInt();
		int[] money = new int[N];
		int cnt = 0;
		int rem = 0;
		int sum = 0;
		for(int i=N-1; i>=0; i--) {
			money[i] = sc.nextInt();
		}
		
		for(int i=0; i<N; i++) {
			if(K>=money[i]&&K-rem>=money[i]) {
				 cnt += (K-rem)/money[i];
				 sum = (K-rem)/money[i];
				 rem += sum*money[i];
			}
			if(K==rem) break;
		}
		System.out.println(cnt);
	}
}
