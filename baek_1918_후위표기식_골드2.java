import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;

public class baek_1918_후위표기식_골드2 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
			Stack<Character> stack = new Stack<>();
			// 기존 수식
			char[] susic = sc.next().toCharArray();
			// 새로운 수식~
			char[] newsusic = new char[susic.length];
			int count = 0;
			for(int i=0; i<susic.length; i++) {
				// 숫자면 수식에 넣고 count를 더해준다~~~~
				if(susic[i]>='A'&&susic[i]<='Z') {
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
				else if(susic[i]=='*'||susic[i]=='/') {
					// 스택이 비었다면~~ 넣어준다~~
					if(stack.isEmpty()) stack.push(susic[i]);
					// 스택이 안비었다면~~
					else {
						// 계속 반복을 돌아줄게요
						while(true) {
							// 스택이 비었거나 맨위가 +라면~ *는 넣을 수 있다! 넣었으니 뿌레이크
							if(stack.empty() || stack.peek() == '+' || stack.peek() == '(' || stack.peek()=='-') {
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
				else if(susic[i]=='+'||susic[i]=='-') {
					// 비었다면! 넣는다~
					if(stack.isEmpty()) stack.push(susic[i]);
					// 안 비었다면!
					else {
						while(true) {
							//스택이 안 비었다면 top을 배열에 넣는다~ 이걸 반복~
							if(!stack.isEmpty()&&stack.peek()=='*' || !stack.isEmpty()&&stack.peek()=='+'||!stack.isEmpty()&&stack.peek()=='/' ||!stack.isEmpty()&&stack.peek()=='-') {
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
			for(int i=0; i<newsusic.length; i++) {
				if(newsusic[i]!='\u0000') {
					System.out.print(newsusic[i]);
				}else {
					break;
				}
			}

	}
}
