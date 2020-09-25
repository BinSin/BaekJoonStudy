/*
 * BinSin
 * https://www.acmicpc.net/problem/5557
 */

package DynamicProgramming.dp2;

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
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		int[] num = new int[N+1];
		for(int i=1; i<=N; i++) num[i] = Integer.parseInt(st.nextToken());
		long[][] dp = new long[N][21];
		dp[1][num[1]] = 1;
		for(int i=2; i<N; i++) {
			int n = num[i];
			for(int j=0; j<=20; j++) {
				if(j - n >= 0 && dp[i-1][j-n] > 0) {
					dp[i][j] += dp[i-1][j-n];
				}
				if(j + n <= 20 && dp[i-1][j+n] > 0) {
					dp[i][j] += dp[i-1][j+n];
				}
			}
		}
		bw.write(dp[N-1][num[N]] + "");
		bw.flush();
		bw.close();
		br.close();
	}
}
