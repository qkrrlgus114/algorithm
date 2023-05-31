import java.util.Scanner;

public class swea_String {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		for(int k=1; k<=10; k++) {
			int a = sc.nextInt();
			// 전체 문자열과 부분 문자열을 전부 char로 비교
			char[] wordarr = sc.next().toCharArray();
			char[] wordStrarr = sc.next().toCharArray();
			// 일치 횟수
			int wordCount = 0;
			
			for(int i=0; i<wordStrarr.length; i++) {
				// 부분 문자열 몇 자리가 맞는지 확인하는 변수
				int count = 0;
				// 전체i번째와 부분0번째가 같으면 시작한다~
				if(wordStrarr[i] == wordarr[0]) {
					// 그럼 하나는 맞은 거니깐 count를 하나 올려주고
					count++;
					// i 다음부터 이제 탐색을 시작한다~
					for(int j=i+1; j<wordStrarr.length; j++) {
						// 이번엔 전체j번째와 부분count번째가 맞으면
						if(wordStrarr[j] == wordarr[count]) {
							// count와 부분문자열의 자릿수-1이 같으면 전부 일치한다는 소리니깐~
							if(count==wordarr.length-1) {
								// 일치 횟수 1 더해주고 나가자!
								wordCount++;
								break;
							}
							// 아니면 count에 1을 더해주자!(전체는 아니어도 j번째는 맞는 거니깐)
							else count++;
						}
						// 그것도 아니면 걍 안맞는거다~
						else break;
					}
				}
			}
			System.out.printf("#%d %d\n",k,wordCount);
		}
	}
}
