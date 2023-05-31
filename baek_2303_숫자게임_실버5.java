import java.util.Scanner;

public class baek_2303_숫자게임_실버5 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[] card = new int[5];
		int sum = 0;
		int max = 0;
		int winidx = 0;
		for(int i=0; i<N; i++) {
			for(int j=0; j<5; j++) {
				card[j] = sc.nextInt();
			}		
			for(int j=0; j<3; j++) {
				for(int k=1+j; k<4; k++) {
					for(int l=2+k-1; l<5; l++) {
						sum = 0;
						sum = card[k]+card[j]+card[l];
						if((sum%10)>=max) {
							max = sum%10;
							winidx = i+1;
						}
					}
				}
			}
		}
		System.out.println(winidx);
		
	}
}
