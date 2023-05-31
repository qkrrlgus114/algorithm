import java.util.Scanner;

public class baek_1476_날짜계산 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int E = sc.nextInt();
		int S = sc.nextInt();
		int M = sc.nextInt();
		int cnt = 1;
		int[] num = {1,1,1};
		while(true) {
			if(num[0]==E && num[1]==S && num[2]==M) {
				System.out.println(cnt);
				break;
			}
			num[0]++;
			num[1]++;
			num[2]++;
			cnt++;
			if(num[0]>15) num[0]=1;
			if(num[1]>28) num[1]=1;
			if(num[2]>19) num[2]=1;
		}
	}
}
