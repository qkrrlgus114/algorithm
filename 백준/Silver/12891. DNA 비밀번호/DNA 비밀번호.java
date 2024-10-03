import javax.xml.crypto.dsig.keyinfo.KeyInfo;
import java.io.*;
import java.sql.SQLOutput;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

		String[] sa = bf.readLine().split(" ");
		int S = Integer.parseInt(sa[0]);
		int P = Integer.parseInt(sa[1]);

		char[] charDna = bf.readLine().toCharArray();

		// 우리가 확인해야하는 cnt
		int[] PCnt = new int[4];
		int[] SCnt = new int[4];
		sa = bf.readLine().split(" ");
		for (int i = 0; i < 4; i++) {
			SCnt[i] = Integer.parseInt(sa[i]);
		}

		int l = 0;
		int r = P - 1;
		int result = 0;

		for (int i = l; i <= r; i++) {
			addCnt(i, PCnt, charDna);
		}

		if (check(PCnt, SCnt)) result++;

		while (r < S) {
			removeCnt(l, PCnt, charDna);
			l++;
			r++;
			if (r >= S) break;
			addCnt(r, PCnt, charDna);

			if (check(PCnt, SCnt)) result++;
		}

		System.out.println(result);


	}

	public static void addCnt(int index, int[] cnt, char[] charDna) {
		if (charDna[index] == 'A') cnt[0]++;
		else if (charDna[index] == 'C') cnt[1]++;
		else if (charDna[index] == 'G') cnt[2]++;
		else if (charDna[index] == 'T') cnt[3]++;
	}

	public static void removeCnt(int index, int[] cnt, char[] charDna) {
		if (charDna[index] == 'A') cnt[0]--;
		else if (charDna[index] == 'C') cnt[1]--;
		else if (charDna[index] == 'G') cnt[2]--;
		else if (charDna[index] == 'T') cnt[3]--;
	}

	public static boolean check(int[] PCnt, int[] SCnt) {
		for (int i = 0; i < 4; i++) {
			if (PCnt[i] < SCnt[i]) return false;
		}

		return true;
	}


}
