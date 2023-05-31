import java.util.Scanner;

public class swea_벽돌깨기 {
	static int[] dr = {0, -1, 0};
	static int[] dc = {1, 0, -1};
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int tc=1; tc<=T ; tc++) {
			int N = sc.nextInt();
			int W = sc.nextInt();
			int H = sc.nextInt();
			int[][] map = new int[H][W];
			for(int i=0; i<H; i++) {
				for(int j=0; j<W; j++) {
					map[i][j] = sc.nextInt();
				}
			}
			while(N!=0) {
				outer: for(int i=0; i<H; i++) {
					for(int j=0; j<W; j++) {
						if(map[i][j]!=0) {
							int bomb = map[i][j]-1;
							for(int l=0; l<3; l++) {
								int idr = i + dr[l];
								int idc = j + dc[l];
								if(idr>=0 && idc>=0 && idc<W) {
									
								}
							}
						}
					}
				}
			}
		}
	}
}
