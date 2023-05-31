import java.util.Scanner;

public class swea_6730_장애물경주난이도_D3 {
	public static int[] height;
	static int high;
	static int low;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int tc=1; tc<=T; tc++) {
			int N = sc.nextInt();
			height = new int[N];
			// 배열에 높이 입력 받음
			for(int i=0; i<N; i++) {
				height[i] = sc.nextInt();
			}
			cal(height);
			System.out.printf("#%d %d %d\n",tc,high,low);
			
		}
	}
	
	// 장애물 계산하는 메서드
	public static void cal(int[] height) {
		high = 0;
		low = 0;
		for(int i=0; i<height.length-1; i++) {
			// 다음 높이가 큰 경우
			if(height[i]<=height[i+1]) {
				if(high<height[i+1]-height[i]) high = height[i+1]-height[i]; 
			}
			else {
				if(low<Math.abs(height[i+1]-height[i])) low = Math.abs(height[i+1]-height[i]); 
			}
		}
	}
}
