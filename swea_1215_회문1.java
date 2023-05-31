import java.util.Scanner;

public class swea_1215_회문1 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		// 가로 확인
		for(int l=1; l<=10; l++) {
			char[][] map = new char[8][8];
			// 입력을 받자.
			int num = sc.nextInt();
			for (int i = 0; i < map.length; i++) {
				String word = sc.next();
				for (int j = 0; j < map.length; j++) {
					map[i][j] = word.charAt(j);
				}
			}
			// 회문 카운트
			int numcount = 0;
			for(int i=0; i<map.length; i++) {
				for(int j=0; j<=map.length-num; j++) {
					// reverse 하기 위해 스트링빌더 선언
					StringBuilder bu = new StringBuilder();
					// k=j부터 입력받은 길이만큼 bu에 저장.
					for(int k=j; k<=j+num-1; k++) {
						bu.append(map[i][k]);
					}
					// 정순정렬인 rbu1, 역순정렬인 rbu2 선언
					String rbu2 = "";
					String rbu1 = bu.toString();
					rbu2 = bu.reverse().toString();
					if(rbu1.equals(rbu2)) numcount++;
				}
			}
			//세로 확인
			for(int j=0; j<map.length; j++) {
				for(int i=0; i<=map.length-num; i++) {
					StringBuilder bu = new StringBuilder();
					StringBuilder rbu = new StringBuilder();
					for(int k=i; k<=i+num-1; k++) {
						rbu = bu.append(map[k][j]);
					}
					String rbu2 = "";
					String rbu1 = rbu.toString();
					rbu2 = rbu.reverse().toString();
					if(rbu1.equals(rbu2)) numcount++;
				}
			}
			System.out.printf("#%d %d\n",l,numcount);
		}
	}
}
