import java.util.Scanner;

public class baek_1789_수들의합_실버5 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Long S = sc.nextLong();
		int count = 0;
		Long sum = (long) 0;
		while(true) {
			count++;
			sum+=count;
			if(sum>S) {
				break;
			}
		}
		System.out.println(count-1);
	}
}
