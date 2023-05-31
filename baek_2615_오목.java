import java.util.Scanner;

public class baek_2615_오목 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[][] map = new int[21][21];
		for (int i = 1; i < map.length-1; i++) {
			for (int j = 1; j < map.length-1; j++) {
				map[i][j] = sc.nextInt();
			}
		}
		
		boolean fblack = false;
		int count = 1;
		for(int i=1; i<map.length-1; i++) {
			for(int j=1; j<map.length-1; j++) {
				while(map[i][j]==1) {
					int ndr = j+count;
					if(map[i][ndr]==1)count++;
					else count = 0;
					if(count==5) {
						fblack=true;
						break;
					}
				}
				if(fblack==true)break;
			}
		}
		
		if(fblack==true) 
			System.out.println(1);
		else System.out.println(2);
		
	}
}