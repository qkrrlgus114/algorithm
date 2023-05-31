import java.util.Arrays;
import java.util.Scanner;

public class baek_1904_타일_실버3 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[] arr = new int[N+1];
		if(N==1) {
			System.out.println(1);
		}else if(N==2) {
			System.out.println(2);
		}else if(N==3) {
			System.out.println(3);
		}else if(N>=4) {
			arr[1]=1;
			arr[2]=2;
			arr[3]=3;
			for(int i=4; i<=N; i++) {
				arr[i] = (arr[i-1]+arr[i-2])%15746;
			}
			System.out.println(arr[N]);
		}
	}
}	
