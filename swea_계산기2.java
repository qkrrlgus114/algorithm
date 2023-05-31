import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;

public class swea_계산기2 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		for (int k = 1; k <= 10; k++) {
			int N = sc.nextInt();
			Stack<Character> stack = new Stack<>();
			// 기존 수식
			char[] susic = sc.next().toCharArray();
			// 새로운 수식~
			char[] newsusic = new char[susic.length];
			int count = 0;
			for(int i=0; i<N; i++) {
				// 숫자면 수식에 넣고 count를 더해준다~~~~
				if(susic[i]>='0'&&susic[i]<='9') {
					newsusic[count++] = susic[i];
				}
				else if(susic[i] == '(') {
					stack.push(susic[i]);
				}
				else if(susic[i] == ')') {
					while(true) {
						if(stack.peek()!='(') {
							newsusic[count++] = stack.pop();
						}
						else if(stack.peek()=='(') {
							stack.pop();
							break;
						}
					}
				}
				// 곱하기면~~
				else if(susic[i]=='*') {
					// 스택이 비었다면~~ 넣어준다~~
					if(stack.isEmpty()) stack.push(susic[i]);
					// 스택이 안비었다면~~
					else {
						// 계속 반복을 돌아줄게요
						while(true) {
							// 스택이 비었거나 맨위가 +라면~ *는 넣을 수 있다! 넣었으니 뿌레이크
							if(stack.empty() || stack.peek() == '+' || stack.peek() == '(') {
								stack.push(susic[i]);
								break;
							}
							// 아니면 교체하고 넣는 걸 반복한다~
							else {
								newsusic[count++] = stack.peek();
								stack.pop();					
							}
						}
					}
					
				}
				// 쁘라스면
				else if(susic[i]=='+') {
					// 비었다면! 넣는다~
					if(stack.isEmpty()) stack.push(susic[i]);
					// 안 비었다면!
					else {
						while(true) {
							//스택이 안 비었다면 top을 배열에 넣는다~ 이걸 반복~
							if(!stack.isEmpty()&&stack.peek()=='*' || !stack.isEmpty()&&stack.peek()=='+') {
								newsusic[count++] = stack.peek();
								stack.pop();
							}
							// 아니라면 스택에 넣고 쁘레이크
							else {
								stack.push(susic[i]);
								break;
							}
						}
					}
				}
			}
			// 전부 끝나면 스택에 남은 걸 다 출력한다~
			while(!stack.isEmpty()) {
				newsusic[count++] = stack.peek();
				stack.pop();
			}
			
//			System.out.println(Arrays.toString(newsusic));

			Stack<Integer> calstack = new Stack<>();
			for(int i=0; i<newsusic.length; i++) {
				// 숫자라면 스택에 넣는다~
				if(newsusic[i]>='0'&&newsusic[i]<='9') {
					calstack.push(newsusic[i]-'0');
				}
				// 곱하기면 곱해서 다시 넣는다~
				else if(newsusic[i] == '*') {
					int a = calstack.peek();
					calstack.pop();
					int b = calstack.peek();
					calstack.pop();
					int c = 0;
					c = b*a;
//					c = c+'0';
					calstack.push( c);
				}
				// 더하기면 더해서 다시 넣는다~
				else if(newsusic[i] == '+') {
					int a = calstack.peek();
					calstack.pop();
					int b = calstack.peek();
					calstack.pop();
					int c = 0;
					c = b+a;
//					c = c+'0';
					calstack.push( c);
				}
			}
			// 스택이 안비었다면~ 출력한다~
			if(!calstack.isEmpty()) {
				System.out.printf("#%d %d\n",k,calstack.peek());
				calstack.pop();
			}
		}
	}
}
