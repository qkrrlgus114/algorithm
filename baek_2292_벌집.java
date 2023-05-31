import java.util.Scanner;

public class baek_2292_벌집 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int min = 1;
		int max = 1;
		int i = 0;
		int count = 1;
		while(true) {
			i+=6;
			min += i-6;
			max = min+i;
			if(N==1) {
				count = 1;
				System.out.println(count);
				break;
			} else if(N>=min&&N<=max) {
				System.out.println(count+1);
				break;
			}
			count++;
		}
	}
}
