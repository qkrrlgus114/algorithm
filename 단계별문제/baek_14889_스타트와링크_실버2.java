package 단계별문제;

import java.util.Scanner;

public class baek_14889_스타트와링크_실버2 {
	static int N;
	static int[][] power;
	static int min;
	static boolean[][] visited;
	static int steam = 0;
	static int lteam = 0;
	static int cnt = 0;
	static int sum = 0;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		visited = new boolean[N][N];
		power = new int[N][N];
		min = Integer.MAX_VALUE;
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				power[i][j] = sc.nextInt();
			}
		}
		perm(0, 0);
		System.out.println(steam);
		
	}
	
	public static void perm(int ist, int jst) {
		// 종료
		
		// 재귀
		for(int id=ist; id<N; id++) {
			for(int jd=jst; jd<N; jd++) {
				if(visited[id][jd]) continue;
				if(power[id][jd]==0) continue;
				if(cnt==0) {
					steam+=power[id][jd] + power[jd][id];
					visited[id][jd] = true;
					visited[jd][id] = true;					
					cnt++;
				} else if(cnt==1) {
					lteam+=power[id][jd] + power[jd][id];
					visited[id][jd] = true;
					visited[jd][id] = true;	
					cnt++;
				}
				if(cnt==2) {
					sum = 0;
					sum = Math.abs(steam-lteam);
					System.out.println(sum);
					if(min > sum) min = sum;
					visited[id][jd] = false;
					visited[jd][id] = false;
					cnt=1;
					lteam = 0;
					continue;
				}
				perm(id, jd);
				visited[id][jd] = false;
				visited[jd][id] = false;
				cnt = 0;
				steam = 0;
				
			}
		}
	}
}
