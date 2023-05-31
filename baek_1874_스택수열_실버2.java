import java.util.Scanner;
import java.util.Stack;

public class baek_1874_스택수열_실버2 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[] arr = new int[N + 1];
		for (int i = 1; i < N + 1; i++) {
			arr[i] = sc.nextInt();
		}

		StringBuilder sb = new StringBuilder();

		int cnt = 1;
		int i = 1;
		Stack<Integer> s = new Stack<>();
		boolean flag = true;
		while (i <= N) {
			if (arr[cnt] != i && arr[cnt] > i) {
				s.push(i);
				i++;
				sb.append("+").append("\n");
			} else if (arr[cnt] == i) {
				s.push(i);
				s.pop();
				i++;
				cnt++;
				sb.append("+").append("\n");
				sb.append("-").append("\n");
			} else if (arr[cnt] != i && arr[cnt] < i) {
				if (s.peek() == arr[cnt]) {
					s.pop();
					sb.append("-").append("\n");
					cnt++;
				} else if (s.peek() != arr[cnt]) {
					flag = false;
					break;
				}
			}
		}
		if (flag == true) {
			while (!s.isEmpty()) {
				if (s.peek() == arr[cnt]) {
					s.pop();
					sb.append("-").append("\n");
					cnt++;
				} else if (s.peek() != arr[cnt]) {
					flag = false;
					break;
				}
			}
			if(flag==true) {
				System.out.println(sb);				
			}else {
				System.out.println("NO");
			}
		} else {
			System.out.println("NO");
		}
	}
}