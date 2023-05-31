import java.util.Arrays;
import java.util.Scanner;

public class baek_2096_내려가기_골드5 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[][] map = new int[N][3];
		for(int i=0; i<N; i++) {
			map[i][0] = sc.nextInt();
			map[i][1] = sc.nextInt();
			map[i][2] = sc.nextInt();
		}
		
		int[][] maxDP = new int[2][3];
		int[][] minDP = new int[2][3];
		
		maxDP[0][0] = map[0][0];
		maxDP[0][1] = map[0][1];
		maxDP[0][2] = map[0][2];
		minDP[0][0] = map[0][0];
		minDP[0][1] = map[0][1];
		minDP[0][2] = map[0][2];
		
		for(int i=1; i<N; i++) {
			maxDP[1][0] = Math.max(maxDP[0][0], maxDP[0][1])+map[i][0]; 
			maxDP[1][1] = Math.max(maxDP[0][0], Math.max(maxDP[0][1], maxDP[0][2]))+map[i][1];
			maxDP[1][2] = Math.max(maxDP[0][1], maxDP[0][2])+map[i][2];
			maxDP[0][0] = maxDP[1][0];
			maxDP[0][1] = maxDP[1][1];
			maxDP[0][2] = maxDP[1][2];
		}
		
		for(int i=1; i<N; i++) {
			minDP[1][0] = Math.min(minDP[0][0], minDP[0][1])+map[i][0]; 
			minDP[1][1] = Math.min(minDP[0][0], Math.min(minDP[0][1], minDP[0][2]))+map[i][1];
			minDP[1][2] = Math.min(minDP[0][1], minDP[0][2])+map[i][2];
			minDP[0][0] = minDP[1][0];
			minDP[0][1] = minDP[1][1];
			minDP[0][2] = minDP[1][2];
		}
		
		int max = Integer.MIN_VALUE;
		for(int i=0; i<3; i++) {
			if(max<maxDP[0][i]) max = maxDP[0][i];
		}
		int min = Integer.MAX_VALUE;
		for(int i=0; i<3; i++) {
			if(min>minDP[0][i]) min = minDP[0][i];
		}
		System.out.println(Arrays.deepToString(maxDP));
		System.out.println(Arrays.deepToString(minDP));
		
		System.out.println(max+" "+min);
	}
}
