/*
 * https://www.acmicpc.net/problem/15655
 * BinSin
 */

package bruteForce.nandm;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main6 {
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	
	public static void go(int[] ans, int[] arr, boolean[] check, int N, int M, int start, int index) throws IOException {
		if(index == M) {
			for(int i=0; i<M; i++) {
				bw.write(ans[i] + " ");
			}
			bw.write("\n");
			return;
		}
		
		for(int i=start; i<N; i++) {
			if(check[arr[i]]) continue;
			check[arr[i]] = true;
			ans[index] = arr[i];
			go(ans, arr, check, N, M, i+1, index+1);
			check[arr[i]] = false;
		}
		
	}
	
	public static void main(String[] args) throws IOException {
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		boolean[] check = new boolean[10001];
		int[] arr = new int[N];
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(arr);
		int[] ans = new int[M];
		
		go(ans, arr, check, N, M, 0, 0);
		
		bw.flush();
		br.close();
		bw.close();
		
	}
}