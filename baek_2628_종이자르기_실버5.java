import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class baek_2628_종이자르기_실버5 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		List<Integer> width = new ArrayList<Integer>();
		List<Integer> height = new ArrayList<Integer>();
		// 0을 넣어주고 시작. 왜지?
		width.add(0);
		height.add(0);
		
		int w = sc.nextInt();
		int h = sc.nextInt();
		int count = sc.nextInt();
		for(int i=0; i<count; i++) {
			int di = sc.nextInt();
			int num = sc.nextInt();
			if(di==0) {
				width.add(num);
			}else {
				height.add(num);
			}
		}
		
		width.add(h);
		height.add(w);
		Collections.sort(width);		
		Collections.sort(height);
		
		// 최댓값 찾기
		int max = 0;
		for(int i=width.size()-1; i>0; i--) {
			int r = width.get(i) - width.get(i-1);
			for(int j=height.size()-1; j>0; j--) {
				int c = height.get(j) - height.get(j-1);
				if(r*c>max) {
					max = r*c;
				}
			}
		}
		System.out.println(max);
	}
}