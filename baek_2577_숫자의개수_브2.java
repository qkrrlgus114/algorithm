import java.util.Arrays;
import java.util.Scanner;

public class baek_2577_숫자의개수_브2 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int A = sc.nextInt();
		int B = sc.nextInt();
		int C = sc.nextInt();
		int sum = A * B * C;
		int[] count = new int[10];
		String num = Integer.toString(sum);
		char[] nums = num.toCharArray();
		for(int i=0; i<nums.length; i++) {
			count[nums[i]-'0']++;
		}
		for(int i=0; i<count.length; i++) {
			System.out.println(count[i]);
		}
	}
}
