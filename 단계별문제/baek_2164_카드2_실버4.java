package 단계별문제;

import java.util.Scanner;
import java.util.Stack;

public class baek_2164_카드2_실버4 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		Stack<Integer> s = new Stack<>();
		while(N!=0) {
			s.add(N);
			N--;
		}
		while(!(s.size()==1)) {
			s.pop();
			int temp = s.pop();
			s.add(0, temp);
		}
		System.out.println(s.pop());
	}
}
