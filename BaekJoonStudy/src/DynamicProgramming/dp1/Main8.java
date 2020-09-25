/*
 * https://www.acmicpc.net/problem/15990
 * BinSin
 */

package DynamicProgramming.dp1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class Main8 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int T = Integer.parseInt(br.readLine());
		long[][] dp = new long[100001][4];
		dp[1][1] = 1;
		dp[2][2] = 1;
		dp[3][1] = 1; dp[3][2] = 1; dp[3][3] = 1;
		for(int i=4; i<=100000; i++) {
			for(int j=1; j<=3; j++) {
				for(int k=1; k<=3; k++) {
					if(j == k) continue;
					dp[i][j] += dp[i-j][k] % 1000000009;
				}
			}
		}
		
		while(T-->0) {
			int n = Integer.parseInt(br.readLine());
			long ans = Arrays.stream(dp[n]).sum() % 1000000009;
			bw.write(ans + "\n");
		}
		bw.flush();
		bw.close();
		br.close();
	}
}
