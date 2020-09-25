/*
 * BinSin
 * https://www.acmicpc.net/problem/10422
 */

package dp2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class Main13 {
	
	static long mod = 1000000007;
	
	public static long go(long[] dp, int l) {
		if(l == 0) return 1;
		if(dp[l] >= 0) return dp[l];
		dp[l] = 0;
		for(int i=2; i<=l; i+=2) {
			dp[l] += (go(dp, i-2) * go(dp, l-i));
			dp[l] %= mod;
		}
		return dp[l];
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int N = Integer.parseInt(br.readLine());
		
		// 방법1
		long[] dp = new long[5001];
		Arrays.fill(dp, -1);
		while(N --> 0) {
			int L = Integer.parseInt(br.readLine());
			if(L%2 == 0) {
				bw.write(go(dp, L) + "\n");
			} else {
				bw.write("0\n");
			}
		}
		
		bw.flush();
		bw.close();
		br.close();
		
		// 방법 2
		long[][] dp2 = new long[5001][5001];
        for (int i=1; i<=5000; i++) {
            for (int j=0; j<=i; j++) {
                dp2[i][j] = 0;
                if (j+1 <= i) {
                    dp2[i][j] += dp2[i-1][j+1];
                }
                if (j-1 >= 0) {
                    dp2[i][j] += dp2[i-1][j-1];
                }
                dp2[i][j] %= mod;
            }
        }
	}
}
