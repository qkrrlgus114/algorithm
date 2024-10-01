import javax.xml.crypto.dsig.keyinfo.KeyInfo;
import java.io.*;
import java.sql.SQLOutput;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

		String[] sa = bf.readLine().split(" ");

		int N = Integer.parseInt(sa[0]);
		int M = Integer.parseInt(sa[1]);

		int[] arr = new int[N];
		for(int i=0; i<N; i++){
			arr[i] = Integer.parseInt(bf.readLine());
		}
		Arrays.sort(arr);

		int result = Integer.MAX_VALUE;
		int l = 0;
		int r = 0;

		while(r < N && l < N){
			if(arr[r] - arr[l] >= M){
				result = Math.min(result, arr[r] - arr[l]);
				l++;
			}else{
				r++;
			}
		}

		System.out.println(result);

	}

}
