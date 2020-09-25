/*
 * BinSin
 * https://www.acmicpc.net/problem/12996
 */

package dp3;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main04 {

	static final long mod = 1000000007;
	static long[][][][] dp;

	/*
	public static long go(int S, int D, int K, int H) {
		if (D < 0 || K < 0 || H < 0) return 0;
		if (S == 0) {
			if (D + K + H == 0)
				return 1;
			else
				return 0;
		}
		long ans = dp[S][D][K][H];
		if (ans != -1)
			return ans;
		ans = 0;
		for (int i = 0; i < 2; i++) {
			for (int j = 0; j < 2; j++) {
				for (int k = 0; k < 2; k++) {
					if (i + j + k == 0)
						continue;
					ans += go(S - 1, D - i, K - j, H - k);
				}
			}
		}
		ans %= mod;
		dp[S][D][K][H] = ans;
		return ans;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int S = Integer.parseInt(st.nextToken());
		int D = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		int H = Integer.parseInt(st.nextToken());
		dp = new long[S + 1][D + 1][K + 1][H + 1];
		for (int i = 0; i <= S; i++) {
			for (int j = 0; j <= D; j++) {
				for (int k = 0; k <= K; k++) {
					Arrays.fill(dp[i][j][k], -1);
				}
			}
		}
		bw.write(go(S, D, K, H) + "");
		bw.flush();
		bw.close();
		br.close();
	}
	*/
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int S = Integer.parseInt(st.nextToken());
		int D = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		int H = Integer.parseInt(st.nextToken());
		dp = new long[S + 1][D + 1][K + 1][H + 1];
		dp[0][0][0][0] = 1;
		for (int i = 1; i <= S; i++) {
			for (int j = 0; j <= D; j++) {
				for (int k = 0; k <= K; k++) {
					for(int l = 0; l <= H; l++) {
						for(int a=0; a<2; a++) {
							for(int b=0; b<2; b++) {
								for(int c=0; c<2; c++) {
									if(j-a < 0 || k-b < 0 || l-c < 0) continue;
									if(a+b+c == 0) continue;
									dp[i][j][k][l] += dp[i-1][j-a][k-b][l-c];
									dp[i][j][k][l] %= mod;
								}
							}
						}
					}
				}
			}
		}
		
		
		bw.write(dp[S][D][K][H] + "");
		bw.flush();
		bw.close();
		br.close();
	}
}
