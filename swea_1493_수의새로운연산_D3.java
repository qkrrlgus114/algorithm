import java.util.Scanner;

public class swea_1493_수의새로운연산_D3 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T= sc.nextInt();
		int[][] map = new int[302][302];
		map[1][1] = 1;
		// 2차배열에다가 아예 배열을 다 생성했다. 이게 되네?
		for(int i=1; i<300; i++) {
			for(int j=1; j<300; j++) {
				if(j==1&&i!=1) {
					map[i][j] = map[i-1][j]+i-1;
				} else {
					map[i][j] = map[i][j-1]+i+j-1;
				}
			}
		}
		boolean flag1 = false;
		boolean flag2 = false;
		for(int q=1; q<=T; q++) {
			flag1 = false;
			flag2 = false;
			int one = sc.nextInt();
			int two = sc.nextInt();
			// one과 two의 좌표를 넣을 변수
			int x1 = 0;
			int y1 = 0;
			int x2 = 0;
			int y2 = 0;
			outer:for(int i=0; i<300; i++) {
				for(int j=0; j<300; j++) {
					// one과 two랑 일치하면 그 좌표 저장하기.
					if(map[i][j] == one) {
						x1 = j;
						y1 = i;
						flag1 = true;
					}
					if(map[i][j] == two) {
						x2 = j;
						y2 = i;
						flag2 = true;
					}
					if(flag1==true&&flag2==true) break outer;
				}
			}
			// 좌표 더해서 새로운 값 찾기.
			x1 = x1+x2;
			y1 = y1+y2;
			System.out.printf("#%d %d\n",q,map[y1][x1]);
		}
	}
}
