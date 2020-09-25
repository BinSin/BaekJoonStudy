/*
 * BinSin
 * https://www.acmicpc.net/problem/12865
 */

package dp2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

public class Main10 {

	static public class Item {
		int w, v;
		Item(int w, int v) {
			this.w = w;
			this.v = v;
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		Item[] item = new Item[N+1];
		for(int i=1; i<=N; i++) {
			st = new StringTokenizer(br.readLine());
			int W = Integer.parseInt(st.nextToken());
			int V = Integer.parseInt(st.nextToken());
			item[i] = new Item(W, V);
		}
		
		int[] dp = new int[K+1];
		for(int i=1; i<=N; i++) {
			for(int j=K; j>0; j--) {
				if(j - item[i].w >= 0) {
					dp[j] = Math.max(dp[j], dp[j-item[i].w] + item[i].v);
				}
			}
		}
		bw.write(dp[K] + "");
		bw.flush();
		bw.close();
		br.close();
	}
}
