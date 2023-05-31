import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;

public class swea_1234_비밀번호_D3 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		for(int T=1; T<=10; T++) {
			int numL = sc.nextInt();
			String num = sc.next();
			Stack<Character> s = new Stack<>();
			s.push(num.charAt(0));
			for(int i=1; i<numL; i++) {
				if(!s.isEmpty()) {
					if(s.peek() == num.charAt(i)) {
						s.pop();
					} else {
						s.push(num.charAt(i));
					}
				} else {
					s.push(num.charAt(i));
				}
			}
			char[] temp = new char[s.size()];
			int cnt = 0;
			while(!s.isEmpty()) {
				temp[cnt++] = s.pop();
			}
			System.out.printf("#%d ",T);
			for(int i=temp.length-1; i>=0; i--) {
				System.out.print(temp[i]);
			}
			System.out.println();
		}
	}
}
