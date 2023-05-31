package class2;

import java.util.Arrays;
import java.util.Scanner;

public class baek_1018_체스판다시칠하기_실버4 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();
		char[][] map = new char[N][M];
		for(int i=0; i<N; i++) {
			String str = sc.next();
			for(int j=0; j<M; j++) {
				map[i][j] = str.charAt(j);
			}
		}
		int min = Integer.MAX_VALUE;
		for(int i=0; i<N-7; i++) {
			for(int j=0; j<M-7; j++) {
				char ch = ' ';
				int count = 0;
				for(int k=i; k<8+i; k++) {
					for(int l=j; l<8+j; l++) {
						if(k==i&&l==j&&map[k][l]=='W') {
							ch = 'B';
						}else if(k==i&&l==j&&map[k][l]=='B') {
							ch = 'B';
						}
						if(k!=i+7&&l==j+7) continue;
						else if(map[k][l]=='W'&&ch=='W') {
							ch = 'B';
						}
						else if(map[k][l]=='B'&&ch=='B') {
							ch = 'W';
						}else if((map[k][l]=='W'&&ch=='B') || (map[k][l]=='B'&&ch=='W')) {
							count++;
							if(ch=='W') ch='B';
							else ch='W';
						}
					}
				}
				if(min>count) {
					min = count;
				}
			}
		}
		System.out.println(min);
	}
}
