import java.util.LinkedList;
import java.util.Scanner;

public class swea_암호문3 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		for(int q=1; q<=10; q++) {
			// 암호문의 길이를 입력 받는다~
			int N = sc.nextInt();
			// 연결리스트를 만든다!
			LinkedList<Integer> list = new LinkedList<>();
			// 리스트에 전부 추가한다~
			for(int i=0; i<N; i++) {
				list.add(sc.nextInt());
			}
			// 명령어 개수를 입력 받는다~
			int T = sc.nextInt();
			for(int i=0; i<T; i++) {
				// 첫 명령어를 char로 받는다~
				char command = sc.next().charAt(0);
				// 그게 I라면 삽입이므로~
				if(command == 'I') {
					int x = sc.nextInt();
					int y = sc.nextInt();
					// y개의 숫자를 삽입하니깐 y번 for문을 돌린다.
					for(int j=0; j<y; j++) {
						int s = sc.nextInt();
						// x+j 인덱스에다가 s를 추가한다~
						list.add(x+j, s);
					}
				}
				// 그게 D라면 삭제이므로~
				else if(command == 'D') {
					int x = sc.nextInt();
					int y = sc.nextInt();
					// x부터 y개를 삭제하니깐 for문으로 돌린다.
					for(int j=x; j<x+y; j++) {
						list.remove(j);
					}
				}
				// 그게 A라면 마지막에 삽입이므로~
				else if(command == 'A') {
					int y = sc.nextInt();
					// y번 for문 돌려서 addLast 해주면 마지막에 삽입한다~
					for(int j=0; j<y; j++) {
						int s = sc.nextInt();
						list.addLast(s);
					}
				}
			}	
			System.out.printf("#%d ",q);
			for(int i=0; i<10; i++) {
				System.out.printf("%d ",list.get(i));
			}
		}
	}
}
