import java.util.Arrays;
import java.util.Scanner;

public class swea_Flatten_D3 {
public static void main(String[] args) {
	Scanner sc = new Scanner(System.in);
	for (int k = 1; k <= 10; k++) {
		int[] map = new int[100];
		int dump = sc.nextInt();
		for(int i=0; i<map.length; i++) {
			map[i] = sc.nextInt();
		}
		int min = 0;
		int max = 99;
		while(dump>0) {
			Arrays.sort(map);
			if(map[max]-map[min]>2) {
				map[max]-=1;
				map[min]+=1;
			}
			else {
				break;
			}
			dump--;
		}
		Arrays.sort(map);
		System.out.printf("#%d %d\n",k,map[max]-map[min]);
	}
}
}
