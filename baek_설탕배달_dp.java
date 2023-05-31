import java.util.Arrays;
import java.util.Scanner;

public class baek_설탕배달_dp {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		long N = sc.nextInt();
		long[] arr = new long[(int) (N+1)];
		if(N<=4){
			arr[3]=1;
		}else if(N>=5) {
			arr[3]=1;
			arr[5]=1;
			for(int i=6; i<=N; i++) {
				if(arr[i-3]==0&&arr[i-5]==0) {
					arr[i] = 0;
				}else if(arr[i-3]!=0&&arr[i-5]!=0) {
					arr[i] = Math.min(arr[i-3], arr[i-5])+1;
				}else if(arr[i-3]==0&&arr[i-5]!=0) {
					arr[i] = arr[i-5]+1;
				}else if(arr[i-3]!=0&&arr[i-5]==0) {
					arr[i] = arr[i-3]+1;
				}
			}
		}
		if(arr[(int) N]==0) {
			System.out.println(-1);
		}else {
			System.out.println(arr[(int) N]);			
		}
	}
}
