import java.util.Arrays;
import java.util.Scanner;

public class baek_7568_덩치_실버5{
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[] cm = new int[N];
		int[] kg = new int[N];
		for(int tc=0; tc<N; tc++) {
			kg[tc] = sc.nextInt();
			cm[tc] = sc.nextInt();
		}
		int[] win = new int[N];
		for(int i=0; i<N; i++) {
			int cnt = 0;
			for(int j=0; j<N; j++) {
				if(kg[i]<kg[j]&&cm[i]<cm[j]) cnt++;
			}
			win[i] = cnt+1;
		}
		for(int i=0; i<N; i++) {
			System.out.print(win[i]+" ");
		}
	}
}