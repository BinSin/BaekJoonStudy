/*
 * https://www.acmicpc.net/problem/9465
 * BinSin
 */

package DynamicProgramming.dp1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main12 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int T = Integer.parseInt(br.readLine());
		while(T-->0) {
			int n = Integer.parseInt(br.readLine());
			int[][] sticker = new int[2][n+1];
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int i=1; i<=n; i++) {
				sticker[0][i] = Integer.parseInt(st.nextToken());
			}
			st = new StringTokenizer(br.readLine());
			for(int i=1; i<=n; i++) {
				sticker[1][i] = Integer.parseInt(st.nextToken());
			}
			
			int[][] dp = new int[2][n+1];
			dp[0][1] = sticker[0][1];
			dp[1][1] = sticker[1][1];
			for(int i=2; i<=n; i++) {
				int max = dp[0][i-2] > dp[1][i-2] ? dp[0][i-2] : dp[1][i-2];
				dp[0][i] = max > dp[1][i-1] ? max + sticker[0][i] : dp[1][i-1] + sticker[0][i];
				dp[1][i] = max > dp[0][i-1] ? max + sticker[1][i] : dp[0][i-1] + sticker[1][i];
			}
			
			int max = dp[0][n] > dp[1][n] ? dp[0][n] : dp[1][n];
			bw.write(max + "\n");
		}
		bw.flush();
		bw.close();
		br.close();
	}
}
