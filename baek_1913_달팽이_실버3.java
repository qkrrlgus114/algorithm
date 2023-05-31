import java.util.Scanner;

public class baek_1913_달팽이_실버3 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[][] map = new int[N][N];
		int idxNum = sc.nextInt();
		int[] dr = { 1, 0, -1, 0 };
		int[] dc = { 0, 1, 0, -1 };
		int cnt = N * N;
		int i = 0;
		int j = 0;
		boolean flag = false;
		outer: while(true) {
			for (int l = 0; l < 4; l++) {
				while (true) {
					if(map[i][j]==0) map[i][j] = cnt--;
					if (j + dc[l] >= 0 && j + dc[l] < N && i + dr[l] >= 0 && i + dr[l] < N
							&& map[i + dr[l]][j + dc[l]] == 0) {
						j = j + dc[l];
						i = i + dr[l];
					} else {
						break;
					}
				}
				if(cnt==0) break outer;
			}
		}	
		int Iidx = 0;
		int Jidx = 0;
		for(int q=0; q<N; q++) {
			for(int w=0; w<N; w++) {
				System.out.print(map[q][w]+" ");
				if(flag==false) {
					if(map[q][w]==idxNum) {
						Iidx = q+1;
						Jidx = w+1;
						flag = true;
					}
				}
			}System.out.println();
		}
		System.out.println(Iidx+" "+Jidx);
	}
}
