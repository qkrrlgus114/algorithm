import java.util.Scanner;

public class swea_3431_준환이의운동관리_D3 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int tc=1; tc<=T; tc++) {
			int L = sc.nextInt();
			int U = sc.nextInt();
			int X = sc.nextInt();
			// 운동을 적게 한 경우
			if(X<L) System.out.printf("#%d %d\n",tc,L-X);
			else if(L<=X&&X<=U) System.out.printf("#%d 0\n",tc);
			else System.out.printf("#%d -1\n",tc);
		}
	}
}
