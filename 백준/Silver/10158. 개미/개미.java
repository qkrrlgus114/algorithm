import javax.xml.crypto.dsig.keyinfo.KeyInfo;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        String[] sa = bf.readLine().split(" ");
        int w = Integer.parseInt(sa[0]);
        int h = Integer.parseInt(sa[1]);

        sa = bf.readLine().split(" ");
        int p = Integer.parseInt(sa[0]);
        int q = Integer.parseInt(sa[1]);
        int t = Integer.parseInt(bf.readLine());

        p+=t%(w*2);
        q+=t%(h*2);
        if(p>w) p=Math.abs(w*2-p);
        if(q>h) q=Math.abs(h*2-q);

        StringBuilder sb = new StringBuilder();
        sb.append(p).append(" ").append(q);
        System.out.print(sb.toString());
    }
}
