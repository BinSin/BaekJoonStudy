/*
 * BinSin
 * https://www.acmicpc.net/problem/1767
 */

package DynamicProgramming.dp3;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class Main06 {

	static final long mod = 1000001;
	static int N, M, K;
	static long[][][] dp;
	
	public static long go(int n, int m, int k) {
		if(k == 0) return 1;
		if(n <= 0 || m <= 0 || k < 0) return 0;		
		long ans = dp[n][m][k];
		if(ans != -1) return ans;
		ans = go(n-1, m, k) + // n 행에 룩을 놓지 않을 때
			go(n-1, m-1, k-1) * m + // n 행에 룩을 놓고 공격 받지 않을 때
			go(n-1, m-2, k-2) * m * (m-1) / 2 + // n 행에 룩 두개 놓을 때
			go(n-2, m-1, k-2) * m * (n-1); // n 행에 룩 놓고 다른 룩에게 공격 받을 때
		ans %= mod;
		dp[n][m][k] = ans;
		return ans;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		N = Integer.parseInt(br.readLine());
		M = Integer.parseInt(br.readLine());
		K = Integer.parseInt(br.readLine());
		dp = new long[N+1][M+1][K+1];
		for(int i=0; i<=N; i++) 
			for(int j=0; j<=M; j++)
				Arrays.fill(dp[i][j], -1);
		bw.write(go(N, M, K) + "");
		bw.flush();
		bw.close();
		br.close();
		
	}
}
