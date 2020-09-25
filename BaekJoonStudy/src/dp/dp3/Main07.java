/*
 * BinSin
 * https://www.acmicpc.net/problem/2008
 */

package dp3;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main07 {

	static int N, M, a, b, X, Y;
	static int[] p;
	static int[][] dp;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		a = Integer.parseInt(st.nextToken()) - 1;
		b = Integer.parseInt(st.nextToken()) - 1;
		X = Integer.parseInt(st.nextToken());
		Y = Integer.parseInt(st.nextToken());
		p = new int[N+1];
		for(int i=1; i<=N; i++) p[i] = Integer.parseInt(br.readLine()) - 1;
		dp = new int[N+1][M+1];
		for(int i=1; i<=N; i++) Arrays.fill(dp[i], 1000*1000);
		
		for(int i=0; i<M; i++) {
			if(i == a) dp[0][i] = 0;
			else dp[0][i] = Math.abs(i-a) * Y;
		}
		
		for(int i=1; i<=N; i++) {
			for(int j=0; j<M; j++) {
				for(int k=0; k<M; k++) { // k : 이전 위치
					if(k == j && (p[i] == k || p[i] == k-1)) {// 내려오면서 연결되어 있으면 지운다
						dp[i][j] = Math.min(dp[i][j], dp[i-1][k] + X);
					} else if((k <= p[i] && p[i] <= j-1) || (j <= p[i] && p[i] <= k-1)) { // 가로선이 j와 k 사이에 존재할 때
						dp[i][j] = Math.min(dp[i][j], dp[i-1][k] + (Math.abs(j-k)-1) * Y);
					} else { // 가로선 존재 안할 때
						dp[i][j] = Math.min(dp[i][j], dp[i-1][k] + Math.abs(j-k) * Y);
					}
				}
			}
		}
		bw.write(dp[N][b] + "");
		bw.flush();
		bw.close();
		br.close();
	}
}
