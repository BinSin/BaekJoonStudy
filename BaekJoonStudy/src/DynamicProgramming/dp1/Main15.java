/*
 * https://www.acmicpc.net/problem/14002
 * BinSin
 */

package DynamicProgramming.dp1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main15 {
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	
	public static void go(int[] perm, int p[], int i) throws IOException {
		if(i == 0) return;
		go(perm, p, p[i]);
		bw.write(perm[i] + " ");
	}
	
	public static void main(String[] args) throws IOException {
		int N = Integer.parseInt(br.readLine());
		int[] perm = new int[N+1];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=1; i<=N; i++) {
			perm[i] = Integer.parseInt(st.nextToken());
		}
		
		int[] dp = new int[N+1];
		int[] p = new int[N+1];
		for(int i=1; i<=N; i++) {
			for(int j=i-1; j>=0; j--) {
				if(perm[i] > perm[j] && dp[i] < dp[j] + 1) {
					dp[i] = dp[j] + 1;
					p[i] = j;
				}
			}
		}
		
		int index = 0;
		int max = 0;
		for(int i=1; i<=N; i++) {
			if(max < dp[i]) {
				max = dp[i];
				index = i;
			}
		}
		
		bw.write(max + "\n");
		
		go(perm, p, index);
		
		bw.flush();
		bw.close();
		br.close();
	}
}
