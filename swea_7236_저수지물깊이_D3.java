import java.util.Scanner;

public class swea_7236_저수지물깊이_D3 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int q=1; q<=T; q++) {
			int N = sc.nextInt();
			char[][] map = new char[N][N];
			for(int i=0; i<N; i++) {
				for(int j=0; j<N; j++) {
					map[i][j] = sc.next().charAt(0);
				}
			}
			int max = 0;
			for(int i=1; i<N-1; i++) {
				for(int j=1; j<N-1; j++) {
					if(map[i][j]=='W') {
						int Wcnt = 0;
						for(int w=i-1; w<=i+1; w++ ) {
							for(int e=j-1; e<=j+1; e++) {
								if(map[w][e]=='W') Wcnt++;
							}
						}
						if(Wcnt==1) Wcnt=2;
						if(max<Wcnt-1) max=Wcnt-1;
						
					}
				}
			}
			System.out.printf("#%d %d\n",q,max);
		}
	}
}
