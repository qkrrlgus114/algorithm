import java.util.Scanner;

public class swea_1209_Sum {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		for(int k=1; k<=10; k++) {
			int T = sc.nextInt();
			int[][] map = new int[100][100];
			
			for(int i=0; i<map.length; i++) {
				for(int j=0; j<map.length; j++) {
					map[i][j] = sc.nextInt();
				}
			}
			int realmax = 0;
			int sum = 0;
			//가로
			for(int i=0; i<map.length; i++) {
				sum = 0;
				for(int j=0; j<map.length; j++) {
					sum+=map[i][j];
				}
				if(sum>realmax) realmax=sum;			
			}
			//세로
			for(int j=0; j<map.length; j++) {
				sum = 0;
				for(int i=0; i<map.length; i++) {
					sum+=map[i][j];
				}
				if(sum>realmax) realmax=sum;			
			}
			sum = 0;
			//앞 대각선
			for(int i=0; i<map.length; i++) {
				sum+=map[i][i];
			}
			if(sum>realmax) realmax = sum;
			sum = 0;
			//뒤 대각선
			for(int i=99; i>=0; i--) {
				int j=0;
				sum+=map[i][j];				
				j++;
			}
			if(sum>realmax) realmax = sum;
			
			System.out.printf("#%d %d\n",T,realmax);
		}
	}
}
