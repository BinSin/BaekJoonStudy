/*
 * https://www.acmicpc.net/problem/15652
 * BinSin
 */

package bruteForce.nandm;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main4 {
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	
	public static void go(int[] ans, int N, int M, int start, int index) throws IOException {
		if(index == M) {
			for(int i=0; i<M; i++) {
				bw.write(ans[i] + " ");
			}
			bw.write("\n");
			return;
		}
		
		for(int i=start; i<=N; i++) {
			ans[index] = i;
			go(ans, N, M, i, index+1);
		}
		
	}
	
	public static void main(String[] args) throws IOException {
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int[] ans = new int[M];
		
		go(ans, N, M, 1, 0);
		
		bw.flush();
		br.close();
		bw.close();
		
	}
}