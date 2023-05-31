import java.util.Scanner;

public class swea_3314_보충학습과평균_D3 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int tc=1; tc<=T; tc++) {
			int[] point = new int[5];
			int sum = 0;
			for(int i=0; i<5; i++) {
				point[i] = sc.nextInt();
				if(point[i] < 40) point[i] = 40;
				sum += point[i];
			}
			
			System.out.printf("#%d %d\n",tc,sum/5);
		}
	}
}
