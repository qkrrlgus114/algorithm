import java.util.Scanner;

public class baek_10163_색종이_브론즈1 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[][] map = new int[1001][1001];
		int[] count = new int[N];
		int cnt = 1;
		for(int q=0; q<N; q++) {
			int x = sc.nextInt();
			int y = sc.nextInt();
			int w = sc.nextInt();
			int h = sc.nextInt();
			for(int i=x; i<w+x; i++) {
				for(int j=y; j<h+y; j++){
					map[i][j] = cnt;
				}
			}
			cnt++;
		}
//		for(int i=0; i<map.length; i++) {
//			for(int j=0; j<map.length; j++) {
//				System.out.print(map[i][j]+" ");
//			}System.out.println();
//		}
		for(int i=0; i<map.length; i++) {
			for(int j=0; j<map.length; j++) {
				if(map[i][j]!=0) {
					count[map[i][j]-1]++;					
				}
			}
		}
		for(int i=0; i<count.length; i++) {
			System.out.println(count[i]);
		}
	}
}
