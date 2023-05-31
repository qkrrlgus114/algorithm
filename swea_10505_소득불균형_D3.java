import java.util.Scanner;

public class swea_10505_소득불균형_D3 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int tc=1; tc<=T; tc++) {
			int N = sc.nextInt();
			int[] money = new int[N];
			for(int i=0; i<N; i++) {
				money[i] = sc.nextInt();
			}
			System.out.printf("#%d ",tc);
			System.out.println(cal(money));
		}
	}
	
	//불균형 계산 메서드
	public static int cal(int[] money) {
		int sum = 0;
		int num = 0;
		for(int i=0; i<money.length; i++) {
			sum+=money[i];
		}
		sum/=money.length;
		for(int i=0; i<money.length; i++) {
			if(money[i]<=sum) num++;
		}
		return num;
		
	}
}
