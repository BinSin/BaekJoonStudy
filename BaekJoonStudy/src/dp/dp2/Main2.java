/*
 * BinSin
 * https://www.acmicpc.net/problem/1890
 */

package dp2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main2 {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st;
		int[][] game = new int[N+1][N+1];
		for(int i=1; i<=N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=1; j<=N; j++) {
				game[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		long[][] dp = new long[N+1][N+1];
		dp[1][1] = 1;
		for(int i=1; i<=N; i++) {
			for(int j=1; j<=N; j++) {
				int n = game[i][j];
				if(n == 0) continue;
				if(1 <= i+n && i+n <= N) {
					dp[i+n][j] += dp[i][j];
				}
				
				if(1 <= j+n && j+n <= N) {
					dp[i][j+n] += dp[i][j]; 
				}
			}
		}
		
		bw.write(dp[N][N] + "");
		bw.flush();
		bw.close();
		br.close();
	}
}
