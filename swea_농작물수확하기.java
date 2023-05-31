import java.util.Scanner;

public class swea_농작물수확하기 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int k=1; k<=T; k++) {
			int N = sc.nextInt();
			int[][] map = new int[N][N];
			//입력
			for(int i=0; i<map.length; i++) {
				char[] mapchar = sc.next().toCharArray();
				for(int j=0; j<map.length; j++) {
					map[i][j] = mapchar[j]-'0';
				}
			}
			int avr = N/2;
			int sum = 0;
			//배열 전체에서 가로 중앙과 윗 값의 합
			for(int i=0; i<=avr; i++) {
				for(int j=avr-i; j<=avr+i; j++) {
					sum+=map[i][j];
				}
			}
			
			int a = 0;
			//배열 전체에서 가로 중앙 기준으로 아래의 합
			for(int i=map.length-1; i>avr; i--) {
				for(int j=avr-a; j<=avr+a; j++) {
					sum+=map[i][j];
				}
				a++;
			}
			System.out.printf("#%d %d\n",k,sum);
		}
	}
}
