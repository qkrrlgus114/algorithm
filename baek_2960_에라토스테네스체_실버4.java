import java.util.Arrays;
import java.util.Scanner;

public class baek_2960_에라토스테네스체_실버4 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int K = sc.nextInt();
		int[] arr = new int[N+1];
		int right = 0;
		int cnt = 0;
		for(int i=0; i<=N; i++) {
			arr[i] = i;
		}
		
		while(K!=cnt) {
			outer: for(int i=2; i<=N; i++) {
				if(arr[i]!=0) {
					for(int j=i; j<=N; j+=i) {
						if(cnt==K-1 && arr[j]!=0) {
							right = arr[j];
							cnt++;
							break outer;
						}else if(arr[j]!=0) {
							arr[j]=0;
							cnt++;							
						}
					}
					break;
				}
			}
		}
		System.out.println(right);
	}
}
