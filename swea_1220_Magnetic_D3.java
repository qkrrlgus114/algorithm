import java.util.Scanner;

public class swea_1220_Magnetic_D3 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[][] map = new int[100][100];
		for(int tc=1; tc<=10; tc++) {
			sc.nextInt();
			// 입력 받기
			for(int i=0; i<100; i++) {
				for(int j=0; j<100; j++) {
					map[i][j] = sc.nextInt();
				}
			}
			
			// 완탐을 돌려서 만나는 숫자를 3으로 만들어버리자!
			int count = 0;
			for(int j=0; j<100; j++) {
				for(int i=0; i<100; i++) {
					if(map[i][j] == 1) {
						int y = i;
						while(true) {
							if(y+1<100) {
								y+=1;
							}
							else break;
							if(map[y][j]==2) {
								count++;
								map[i][j] = 3;
								map[y][j] = 3;
								break;
							} else if(map[y][j]==1) {
								map[y][j] = 3;
							}
						}
					} 
				}
			}
			System.out.printf("#%d %d\n",tc,count);
		}
	}
}
