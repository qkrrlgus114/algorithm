import java.util.Scanner;

public class baek_1676_팩토리얼0의개수_실버5 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();
		int sum = num/5;
		int sum25 = 0;
		int sum125 = 0;
		if(num>=125) {
			sum125 = num/125;
		}
		if(num>=25) {
			sum25 = num/25;			
		}
		if(sum125!=0) {
			sum += sum125;
		}
		if(sum25!=0) {
			sum += sum25;
		}
		System.out.println(sum);
	}
}
