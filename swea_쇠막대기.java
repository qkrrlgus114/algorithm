import java.util.Scanner;

public class swea_쇠막대기 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		for(int k=1; k<=T; k++) {
			// 파이프 입력받기
			String pipe = sc.next();
			// 파이프의 개수
			int pipecount = 0;
			// 파이프의 조각
			int pipepiece = 0;
			// i=0부터 pipe의 길이까지 for문을 돌려서 확인
			for(int i=0; i<pipe.length(); i++) {
				// pipe를 char로 바꿔서 저장
				char pipea = pipe.charAt(i);
				// 만약에 파이프가 '('이면
				if(pipea == '(') {
					// '(' 다음이 '('인 경우 파이프가 생성이 된 거니깐
					if(pipe.charAt(i+1) == '(') {
						// 파이프에 1을 더해준다.
						pipecount++;
					}
					// '(' 다음이 ')'인 경우
					else {
						// 파이프조각에 현재 파이프를 더해준다.
						pipepiece += pipecount;
					}
				}
				// 만약에 파이프가 ')'이면
				else {
					// 만약에 ')' 이전 파이프가 ')'이면 파이프가 닫힌 상태이니
					if(pipe.charAt(i-1)==')') {
						// 현재 파이프 조각에 1을 더해준다. 파이프가 닫히면서 하나는 잘리기 때문
						pipepiece++;
						// 그리고 파이프 개수를 줄여준다.
						pipecount--;
					}
					// ')' 이전 파이프가 '('인 경우는 레이저인 상태지만 이미 위의 if문에서 검사했기때문에 넘긴다.
				}
			}
			System.out.printf("#%d %d\n",k,pipepiece);
		}
	}
}
