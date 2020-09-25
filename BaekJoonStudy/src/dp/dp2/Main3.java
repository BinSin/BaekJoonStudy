/*
 * BinSin
 * https://www.acmicpc.net/problem/10942
 * 팰린드롬 : 역순으로 읽어도 같은 말이 되는 말
 */

package dp2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main3 {

	public static int isPlindrome(int[] num, int s, int e) {
		if(s < e) {
			if(num[s] == num[e]) {
				return isPlindrome(num, s+1, e-1);
			} else {
				return -1;
			}
		} else {
			return 1;
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int N = Integer.parseInt(br.readLine());
		int[] num = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) num[i] = Integer.parseInt(st.nextToken());
		
		boolean[][] dp = new boolean[N][N];
		for(int i=0; i<N; i++) dp[0][i] = (isPlindrome(num, 0, i) == 1) ? true : false;
		
		for(int i=1; i<N; i++) {
			dp[i][i] = true;
			for(int j=i+1; j<N; j++) {
				if(j == N-1) dp[i][j] = isPlindrome(num, i, j) == 1 ? true : false;
				else dp[i][j] = (dp[i-1][j+1]) ? true : ((isPlindrome(num, i, j) == 1) ? true : false);
			}
		}
		
		
		System.out.println();
		for(int i=0; i<N; i++) {
			
			for(int j=0; j<N; j++) {
				if(dp[i][j]) System.out.print("T ");
				else System.out.print("F ");
			}
			System.out.println();
		}
		
		
		int M = Integer.parseInt(br.readLine());
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken()) - 1;
			int e = Integer.parseInt(st.nextToken()) - 1;
			if(dp[s][e]) bw.write("1\n");
			else bw.write("0\n");
		}
		bw.flush();
		bw.close();
		br.close();
	}
}
