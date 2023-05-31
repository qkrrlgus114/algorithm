import java.util.Scanner;
 
public class swea_오목판정 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        String rock;
        for (int k = 1; k <= T; k++) {
            int N = sc.nextInt();
            char[][] map = new char[N][N];
            for (int i = 0; i < map.length; i++) {
                rock = sc.next();
                for (int j = 0; j < map.length; j++) {
                    map[i][j] = rock.charAt(j);
                }
            }
            boolean omog = false;
            int count = 0;
            //가로
            for(int i=0; i<map.length; i++) {
                count = 0;
                for(int j=0; j<map.length; j++) {
                    if(map[i][j]=='o') {
                        count++;
                        if(count==5)omog=true;
                    }
                    else
                    	count=0;
                }
            }
            //세로
            for(int i=0; i<map.length; i++) {
                count = 0;
                for(int j=0; j<map.length; j++) {
                    if(map[j][i]=='o') {
                        count++;
                        if(count==5)omog=true;
                    }
                    else
                    	count=0;
                }
            }
            //우하향 대각선
            for(int i=0; i<map.length; i++) {
            	for(int j=0; j<map.length; j++) {
            		count = 1;
            		if(map[i][j]=='o') {
            			while(i+count<map.length&&j+count<map.length&&map[i][j]==map[i+count][j+count]) {
            				count++;
            				if(count==5)break;
            			}
            		}
            		if(count==5)omog=true;
            	}
            }
            //좌하향 대각선
            for(int i=0; i<map.length; i++) {
            	for(int j=map.length-1; j>=0; j--) {
            		count = 1;
            		if(map[i][j]=='o') {
            			while(i+count<map.length&&j-count>=0&&map[i][j]==map[i+count][j-count]) {
            				count++;
            				if(count==5)break;
            			}
            		}
            		if(count==5)omog=true;
            	}
            }
            String good="";
            if(omog==true)good="YES";
            else if(omog==false)good="NO";
            System.out.printf("#%d %s\n",k,good);
        }
 
    }
}