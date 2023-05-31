import java.util.Arrays;
import java.util.Scanner;

public class swea_사다리 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		for(int k = 1; k<=10; k++) {
			int T = sc.nextInt();
			int[][] map = new int[102][102];
			int[][] list = new int[102][102];
			for(int i=1; i<map.length-1; i++) {
				for(int j=1; j<map.length-1; j++) {
					map[i][j] = sc.nextInt();
					list[i][j] = map[i][j];
				}
			}
			boolean flag = false;
			for(int j=1; j<map.length-1; j++) {
				for(int i=0; i<map.length-1; i++) {
					for(int q=0; q<map.length-1; q++) {
						map[i][q] = list[i][q];
					}
				}
				//동작
				int count = j;
				if(map[1][j]==1) {
						for(int i=1; i<map.length-1; i++) {
							if(map[i][count]==2) {
								flag = true;
								break;
							}
							else if((map[i][count]==1&&map[i][count+1]==1)||(map[i][count]==1&&map[i][count-1]==1)) {
								// 오른쪽으로 간다.
								if(map[i][count]==1&&map[i][count+1]==1) {
									for(int l=count; l<map.length; l++) {
										//
										if(map[i][l]==1) {
											count = l;
										}
										else {
											break;
										}
									}
								}
								// 왼쪽
								else if(map[i][count]==1&&map[i][count-1]==1) {
									for(int l=count; l>=0; l--) {
										if(map[i][l]==1) {
											count = l;
										}
										else {
											break;
										}
									}
								}
							}
							
						}
						//flag가 true면 출력하고 브레이크
						if(flag==true) {
							System.out.printf("#%d %d\n",k,j-1);
							break;
						}
						
						
					}
				}
		}
	}
}


