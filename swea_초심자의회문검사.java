import java.util.Scanner;

public class swea_초심자의회문검사 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int k = 1; k <= T; k++) {
			//str을 char배열에 쪼개서 넣기.
			String wordStr = sc.next();
			char[] word = wordStr.toCharArray();
			//word길이를 가지는 변수 선언
			int count = word.length-1;
			//참 거짓 판단
			int flag = 0;
			for(int i=0; i<word.length; i++) {
				//word[i]번째와 word[count]번째가 같은지 판단.
				//서로 1씩 더하고 빼면서 for문을 통해 계속 교차해서 판단.
				if(word[i] == word[count]) flag=1;
				else flag=0;
				count--;
			}
			System.out.printf("#%d %d\n",k,flag);
		}
	}
}
