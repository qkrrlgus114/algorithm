import java.util.Scanner;

public class swea_체스판위의룩배치 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int q=1; q<=T; q++) {
			char[][] map = new char[8][8];
			// 말 넣기
			for(int i=0; i<map.length; i++) {
				// str로 받아서 char 2차배열에 삽입
				String mal = sc.next();
				for(int j=0; j<map.length; j++) {
					map[i][j] = mal.charAt(j);
				}
			}
			
			// 아래로 가기 위한 방향
			int dr = 1;
			// 참 거짓 판단
			boolean flag = true;
			// 전체 룩의 개수
			int Ocount = 0;
			for(int i=0; i<map.length; i++) {
				// 한 열의 룩 개수
				int count = 0;
				// i인덱스 저장
				int a = i;
				for(int j=0; j<map.length; j++) {
					// 그 위치에 룩이 있다면
					if(map[i][j]=='O') {
						// 전부 1씩 더해줌
						count++;
						Ocount++;
						// i행에 1을 더해도 맵을 안 벗어나면
						while(a+dr<map.length){
							// 더해주고 
							a = a+dr;
							// 그 아래에 룩이 있다면 false로 바꾸고 브레이꾸
							if(map[a][j]=='O') {
								flag = false;
								break;
							}
						}
					}
				}
				// 열을 판단했는데 count가 1보다 크면 룩이 2개 이상이므로 false
				if(count>1) {
					flag=false;
				}
			}
			// 전체를 판단했는데 룩의 개수가 8이 아니면 false
			if(Ocount!=8) {
				flag=false;
			}
			System.out.printf("#%d ",q);
			if(flag == true) System.out.println("yes");
			else if(flag == false) System.out.println("no");
		}
	}
}

