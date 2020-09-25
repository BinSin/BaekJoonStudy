/*
 * https://www.acmicpc.net/problem/11054
 * BinSin
 */

package DynamicProgramming.dp1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;
import java.util.stream.IntStream;

public class Main18 {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int N = Integer.parseInt(br.readLine());
		int[] perm = new int[N+2];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=1; i<=N; i++) {
			perm[i] = Integer.parseInt(st.nextToken());
		}
		
		int[] left = new int[N+1];
		for(int i=1; i<=N; i++) {
			for(int j=i-1; j>=0; j--) {
				if(perm[j] < perm[i] && left[i] < left[j] + 1) {
					left[i] = left[j] + 1;
				}
			}
		}
		
		int[] right = new int[N+2];
		for(int i=N; i>0; i--) {
			for(int j=i+1; j<=N+1; j++) {
				if(perm[j] < perm[i] && right[i] < right[j] + 1) {
					right[i] = right[j] + 1;
				}
			}
		}
		
		
		int[] result = new int[N+1];
		Arrays.parallelSetAll(result, i -> left[i] + right[i] - 1);
		bw.write(Arrays.stream(result).max().getAsInt() + "\n");
		
		bw.flush();
		bw.close();
		br.close();
	}
}
