import javax.xml.crypto.dsig.keyinfo.KeyInfo;
import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

		String[] sa = bf.readLine().split(" ");

		int N = Integer.parseInt(sa[0]);
		int M = Integer.parseInt(sa[1]);

		int[] arr = new int[N];
		sa = bf.readLine().split(" ");
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(sa[i]);
		}

		int l = 0;
		int r = 0;
		int sum = arr[0];
		int cnt = 0;

		while (l != N && r != N) {
			if (sum == M) {
				cnt++;
				sum -= arr[l];
				l++;
			} else if (sum > M) {
				sum -= arr[l];
				l++;
			} else {
                r++;
                if(r != N){
                    sum += arr[r];
                }
			}
		}

		System.out.println(cnt);

	}

}
