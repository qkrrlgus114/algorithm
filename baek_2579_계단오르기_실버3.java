import java.util.Arrays;
import java.util.Scanner;

public class baek_2579_계단오르기_실버3 {

	static int[] step;
	static int[] arr;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		step = new int[N + 1];
		arr = new int[N + 1];
		for (int i = 1; i <= N; i++) {
			step[i] = sc.nextInt();
		}
		if(N==1) {
			arr[1] = step[1];
		}else{
			arr[1] = step[1];
			arr[2] = step[1] + step[2];			
		}
		if(N>2) {
			for(int i=3; i<=N; i++) {
				arr[i] = Math.max(arr[i-3] + step[i-1], arr[i-2]) + step[i];
			}
		}
		int max = Integer.MIN_VALUE;
		for(int i=1; i<=N; i++) {
			if(max < arr[i]) max = arr[i];
		}
		System.out.println(max);
	}
}
