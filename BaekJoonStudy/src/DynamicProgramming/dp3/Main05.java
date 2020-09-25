/*
 * BinSin
 * https://www.acmicpc.net/problem/12872
 */

package DynamicProgramming.dp3;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main05 {

	static final long mod = 1000000007;
	static int N, M, P;
	static long[][] dp;
	
	public static long go(int pos, int x) { // X : 추가한 노래
		int y = N - x; // : y : 추가되지 않은 노래
		if(pos == P) {
			if(y == 0) return 1;
			else return 0;
		}
		// 삼항 연산자는 속도 측면에서 좋지 않다!!!
		long ans = dp[pos][x];
		if(ans != -1) return ans;
		ans = 0;
		if(y > 0) {
			ans += go(pos+1, x+1) * y;
		}
		if(x > M) {
			ans += go(pos+1, x) * (x-M);
		}
		ans %= mod;
		dp[pos][x] = ans;
		return ans;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		P = Integer.parseInt(st.nextToken());
		dp = new long[P+1][N+1];
		for(int i=0; i<=P; i++) Arrays.fill(dp[i], -1);
		bw.write(go(0, 0) + "");
		bw.flush();
		bw.close();
		br.close();
	}
}
