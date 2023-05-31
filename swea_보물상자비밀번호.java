import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

public class swea_보물상자비밀번호 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		StringBuilder sb = new StringBuilder();
		Stack<Integer> s = new Stack<>();
		for (int tc = 1; tc <= T; tc++) {
			int dec = 0;
			int N = sc.nextInt();
			int K = sc.nextInt();
			char[] num1 = new char[N];
			String str = sc.next();
			// 2회전 한다.
			num1 = str.toCharArray();
			int in = 1;
			int cnt = N / 4;
			int count = 0;
			for (int i = 0; i < N; i++) {
				if (count != cnt) {
					count++;
					sb.append(num1[i]);
					if (count == cnt) {
						count = 0;
						String sbn = sb.toString();
						dec = Integer.parseInt(sbn, 16);
						s.push(dec);
						sb.setLength(0);
					}
				}
			}
			while (in != N / 4) {
				char last='0';
				for (int i = 1; i < num1.length; i++) {
					last = num1[i];
					num1[i] = num1[0];
					num1[0] = last;
				}
				in++;
				for (int i = 0; i < N; i++) {
					if (count != cnt) {
						count++;
						sb.append(num1[i]);
						if (count == cnt) {
							count = 0;
							String sbn = sb.toString();
							dec = Integer.parseInt(sbn, 16);
							s.push(dec);
							sb.setLength(0);
						}
					}
				}
			}
			long[] point = new long[s.size()];
			for (int i = 0; i < point.length; i++) {
				if(!s.isEmpty()) {
					point[i] = s.pop();					
				}
			}
			Arrays.sort(point);
//			System.out.println(Arrays.toString(point));
			cnt = 0;
			int temp = 0;
			for (int i = point.length-1; i >= 0; i--) {
				if(i==0) {
					if(point[i]!=point[i+1]) {
						cnt++;
						if (cnt == K) {
							temp = i;
							break;
						}
						
					}
				}
				else if (point[i] != point[i - 1]) {
					cnt++;
					if (cnt == K) {
						temp = i;
						break;
					}
				}
			}
			System.out.printf("#%d %d\n", tc, point[temp]);
		}
	}
}
