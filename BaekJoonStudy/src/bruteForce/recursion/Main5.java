/*
 * https://www.acmicpc.net/problem/14501
 * BinSin
 */

package bruteForce.recursion;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main5 {
	
	static int answer = 0;
	
	public static void maxProfit(int[] T, int[] P, int sum, int i) {
		if(i == T.length) {
			if(answer < sum) {
				answer = sum;
				return;
			} else {
				return;
			}
		}
		if(i > T.length)
			return;
		
		maxProfit(T, P, sum + P[i], i + T[i]);
		maxProfit(T, P, sum, i+1);
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int N = Integer.parseInt(br.readLine());
		int[] T = new int[N];
		int[] P = new int[N];
		for(int i=0; i<N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			T[i] = Integer.parseInt(st.nextToken());
			P[i] = Integer.parseInt(st.nextToken());
		}
		
		maxProfit(T, P, 0, 0);
		
		bw.write(answer + "");
		br.close();
		bw.flush();
		bw.close();
	}
}
