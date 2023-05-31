import java.util.Arrays;
import java.util.Scanner;

public class swea_공통조상 {
	public static int n;
	static char[] ch = {};
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		for(int q=1; q<=10; q++) {
			int T = sc.nextInt();
			// 스트링과 char을 +1 길이만큼 만들어서 0번째는 비운다.
			String[] arr = new String[T+1];
			ch = new char[T+1];
			n = ch.length;
			// 이렇게 0번째는 비워놓음
			ch[0] = '\u0000';
			// 입력 하나 건너뛰어야 오류 안생기더라. 왜지?
			sc.nextLine();
			// 스트링에 넣고나서 문자만 따로 char에 빼서 넣었다.
			for(int i=1; i<=arr.length-1; i++) {
				arr[i] = sc.nextLine();
				// 처음 숫자가 10 이상일 경우 인덱스가 달라져서 조건을 추가해야함.
				if(arr[i].charAt(1)>=0+'0') {
					ch[i] = arr[i].charAt(3);	
				}
				else{
					ch[i] = arr[i].charAt(2);					
				}
			}
			System.out.printf("#%d ",q);
			traverse(1);
			System.out.println();
		}
	}
	
	private static void traverse(int i) { // i번째 노드의 순회
		if(i <= n-1) {
			// 전위 순회
			// V : 자기 자신을 방문처리
			
			// L : 왼쪽 트리로 탐색을 이어나감
			traverse(i*2);
			if(ch[i] != '\u0000') System.out.print(ch[i]);
			
			// R : 오른쪽으로 탐색을 이어나감
			traverse(i*2+1);
		}
		
	}
}
