import java.util.Scanner;

public class baek_2669_직사각형면적_브론즈1{
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[][] map = new int[100][100];
		int count = 0;
		for(int q=0; q<4; q++) {
			int x = sc.nextInt();
			int y = sc.nextInt();
			int xx = sc.nextInt();
			int yy = sc.nextInt();
			for(int i=y; i<yy; i++) {
				for(int j=x; j<xx; j++) {
					map[i][j] = 1;
				}
			}
		}
		int cnt = 0;
		for(int i=0; i<100; i++) {
			for(int j=0; j<100; j++) {
				if(map[i][j]==1) cnt++;
			}
		}
		System.out.println(cnt);
	}
}