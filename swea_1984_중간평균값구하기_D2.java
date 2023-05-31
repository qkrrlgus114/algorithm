import java.util.Arrays;
import java.util.Scanner;

public class swea_1984_중간평균값구하기_D2 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		double T = sc.nextInt();
		for(int q=1; q<=T; q++) {
			double sum = 0;
			int[] arr = new int[10];
			for(int i=0; i<10; i++) {
				arr[i] = sc.nextInt();
			}
			Arrays.sort(arr);
			for(int i=1; i<9; i++) {
				sum+=arr[i];
			}
			sum=Math.round(sum/8);
			System.out.printf("#%d %.0f\n",q,sum);
		}
	}
}
