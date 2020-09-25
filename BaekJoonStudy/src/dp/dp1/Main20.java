/*
 * https://www.acmicpc.net/problem/13398
 * BinSin
 */

package dp;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;
import java.util.stream.IntStream;

public class Main20 {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int n = Integer.parseInt(br.readLine());
		int[] perm = new int[n+1];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=1; i<=n; i++) {
			perm[i] = Integer.parseInt(st.nextToken());
		}
		
		int[] left = new int[n+1];
		int[] right = new int[n+2];
		for(int i=1; i<=n; i++) {
			if(left[i-1] >= 0) {
				left[i] = left[i-1] + perm[i];
			} else {
				left[i] = perm[i];
			}
			
			if(right[n+2-i] >= 0) {
				right[n+1-i] = right[n+2-i] + perm[n+1-i];
			} else {
				right[n+1-i] = perm[n+1-i];
			}
		}
		
		
		int max = -1001;
		int[] answer = new int[n+2];
		for(int i=1; i<=n; i++) {
			answer[i] = left[i-1] + right[i+1];
			max = Math.max(left[i], Math.max(max, answer[i]));
		}
		
		bw.write(max + "\n");
		
		bw.flush();
		bw.close();
		br.close();
	}
}
