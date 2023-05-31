import java.util.Arrays;
import java.util.Scanner;

public class swea_준홍이의카드놀이 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int q=1; q<=T; q++) {
			int N = sc.nextInt();
			int M = sc.nextInt();
			int[] Ncard = new int[N];
			int[] Mcard = new int[M];
			int Nmax = 0;
			int Mmax = 0;
			for(int i=0; i<Ncard.length; i++) {
				Ncard[i] = i+1;
				if(Nmax<Ncard[i]) Nmax = Ncard[i];
			}
			for(int i=0; i<Mcard.length; i++) {
				Mcard[i] = i+1;
				if(Mmax<Mcard[i]) Mmax = Mcard[i];
			}
			int[] counting = new int[Nmax+Mmax];
			int a = 0;
			for(int i=0; i<Ncard.length; i++) {
				for(int j=0; j<Mcard.length; j++) {
					counting[Ncard[i]+Mcard[j]-1]++;
				}
			}
		}
	}
}
