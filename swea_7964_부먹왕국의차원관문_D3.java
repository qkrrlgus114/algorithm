import java.util.Scanner;

public class swea_7964_부먹왕국의차원관문_D3 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int q=1; q<=T; q++) {
			int N = sc.nextInt();
			int D = sc.nextInt();
			int[] map = new int[N];
			for(int i=0; i<N; i++) {
				map[i] = sc.nextInt();
			}
			int zerocnt = 0;
			int onecnt = 0;
			for(int i=0; i<N; i++) {
				if(map[i]==0) {
					zerocnt++;
					if(zerocnt==D) {
						onecnt++;
						zerocnt = 0;
					}
				}else {
					zerocnt = 0;
				}
			}
			System.out.printf("#%d %d\n",q,onecnt);
		}
	}
}