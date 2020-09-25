/*
 * https://www.acmicpc.net/problem/11057
 * BinSin
 */

package DynamicProgramming.dp1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class Main10 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int N = Integer.parseInt(br.readLine());
		int[][] dp = new int[N+1][10];
		Arrays.fill(dp[1], 1);
		for(int i=2; i<=N; i++) {
			for(int j=0; j<10; j++) {
				for(int k=j; k<10; k++) {
					dp[i][k] += dp[i-1][j] % 10007;
				}
			}
		}
		int ans = Arrays.stream(dp[N]).sum() % 10007;
		bw.write(ans + "\n");
		
		bw.flush();
		bw.close();
		br.close();
	}
}
