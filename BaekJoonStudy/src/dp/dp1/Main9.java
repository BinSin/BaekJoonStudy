/*
 * https://www.acmicpc.net/problem/15990
 * BinSin
 */

package dp;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class Main9 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int N = Integer.parseInt(br.readLine());
		long[][] dp = new long[101][10];
		Arrays.fill(dp[1], 1); 
		dp[1][0] = 0;
		for(int i=2; i<=100; i++) {
			for(int j=0; j<10; j++) {
				if(j - 1 >= 0) dp[i][j] += dp[i-1][j-1] % 1000000000;
				if(j + 1 < 10) dp[i][j] += dp[i-1][j+1] % 1000000000;
			}
		}
		// stream ��뺸�� for�� ����� ���ɿ� �� ����
		long ans = Arrays.stream(dp[N]).sum() % 1000000000;
		bw.write(ans + "\n");
		
		bw.flush();
		bw.close();
		br.close();
	}
}
