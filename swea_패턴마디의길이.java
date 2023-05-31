import java.util.Scanner;

public class swea_패턴마디의길이 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int k=1; k<=T; k++) {
			// 단어의 길이 변수
			int wordlen = 0;
			// char 배열에 입력 받아서 넣기
			char[] word = sc.next().toCharArray();
			// 문자열의 길이는 30이고 마디는 최대10이므로 최소 3개는 반복해야함
			int l = 3;
			// l이 10까지만 와일문 돌림
			while(l!=11) {
				StringBuilder bd = new StringBuilder();
				// l의 값에 따라서 bd에 단어 집어넣음.
				// ex) KOREA 입력들어오고 l이 3이면 bd=KOR, l이 4이면 bd=KORE
				for(int i=0; i<l; i++) {
					bd.append(word[i]);
				}
				// 길이가 같은지 판단하기 위한 count변수
				int count = 0;
				// bd의 길이까지 for문을 돌림
				for(int i=0; i<bd.length(); i++) {
					// i+bd의 길이가 입력받은 word의 길이보다 작고, bd의 i번째와 word[bd.length() + i]번째가 같으면 count에 1 더함
					// bd의 i번째와 word[bd.length() + i]는 l=3이고 KOREAKOREA 라는 입력이 들어왔을 경우 
					// bd=KOR이 저장돼있고 word[3~5]까지를 비교하는 방법이다.
					// bd[1]=K word[3]=E이므로 틀려서 브레이크.
					// bd=KOREA이라고 가정하면 word[5~9]를 비교하니깐 bd[0~4] == word[5~9]는 동일하다고 판단한다. 그 다음도 확인함. 단어 길이는 10까지 가능해서
					if(i+bd.length()<word.length && bd.charAt(i) == word[i+bd.length()] && bd.charAt(i) == word[i+bd.length()+bd.length()]) {
						count++;
					}
					else break;
				}
				// 만약에 count값이 bd의 길이와 같다면 두 단어는 같다는 소리.
				if(count==bd.length()) {
					// wordlen에 count를 저장
					wordlen = count;
					break;
				}
				l++;
			}
			System.out.printf("#%d %d\n",k,wordlen);
		}
	}
}
