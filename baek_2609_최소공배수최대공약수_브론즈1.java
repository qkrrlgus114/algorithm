import java.util.Scanner;

public class baek_2609_최소공배수최대공약수_브론즈1 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int a = sc.nextInt();
		int b = sc.nextInt();
		
		// 가장 작은 수를 먼저 구해준다.
		int min = Math.min(a, b);
		// 최대공약수를 저장 할 변수.
		int num = 0;
		for(int i=1; i<=min; i++) {
			if(a%i==0&&b%i==0) num = i;
		}
		// 최대공약수
		System.out.println(num);
		// 최소공배수
		System.out.println((a*b)/num);
		
	}
}	
