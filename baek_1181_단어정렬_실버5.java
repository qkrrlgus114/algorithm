import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;


public class baek_1181_단어정렬_실버5 {
	static List<String> word;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		word = new ArrayList<String>();
		for (int i = 0; i < N; i++) {
			word.add(sc.next());
		}
		
		Collections.sort(word); // 우선 모음순으로 정렬
		for(int i=0; i<word.size()-1; i++) {
			boolean flag = true;
			while(flag==true) {
				if(i!=word.size()-1&&word.get(i).equals(word.get(i+1))) { // 같으면
					word.remove(i); // 중복제거
				}else {
					flag=false;
				}
			}
		}

		Collections.sort(word, new Comparator<String>() { // 길이순 오름차순
			@Override
			public int compare(String o1, String o2) {
				return o1.length() - o2.length();
			}
		});
		
		for(int i=0; i<word.size(); i++) {
			System.out.println(word.get(i));
		}

	}
}