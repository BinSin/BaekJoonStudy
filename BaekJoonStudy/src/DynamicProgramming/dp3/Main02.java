/*
 * BinSin
 * https://www.acmicpc.net/problem/4811
 */

package DynamicProgramming.dp3;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class Main02 {

	static long[][] dp = new long[31][31];
	
	// calc(f-1, h+1) 한 조각 먹는 경우
	// calc(f, h-1) 반 조각 먹는 경우
	static long calc(int f, int h) {
		if(dp[f][h] != -1) return dp[f][h];
		if(f == 0) return 1;
		if(h == 0) return dp[f][h] = calc(f-1, h+1);
		return dp[f][h] = calc(f-1, h+1) + calc(f, h-1);
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		for(int i=0; i<=30; i++) {
			Arrays.fill(dp[i], -1);
		}
		while(true) {
			int N = Integer.parseInt(br.readLine());
			if(N == 0) break;
			bw.write(calc(N, 0) + "\n");
		}
		bw.flush();
		bw.close();
		br.close();
	}
}
