import java.util.Scanner;
import java.util.Stack;


public class baek_10773_제로_실버4{
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int K = sc.nextInt();
		Stack<Integer> stack = new Stack<>();
		for(int i=0; i<K; i++) {
			int num = sc.nextInt();
			if(num!=0) {
				stack.push(num);
			} else if(num==0) {
				if(!stack.isEmpty()) {
					stack.pop();
				}
			}
		}
		int sum = 0;
		while(!stack.isEmpty()) {
			sum += stack.pop();
		}
		System.out.println(sum);
	}
}