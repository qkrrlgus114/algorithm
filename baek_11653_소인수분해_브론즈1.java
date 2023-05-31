import java.util.Scanner;

public class baek_11653_소인수분해_브론즈1{
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();
		int i = 2;
		while(i<=num) {
			if(num%i==0) {
				System.out.println(i);
				num/=i;
			} else {
				i++;
			}
		}
	}
	
}