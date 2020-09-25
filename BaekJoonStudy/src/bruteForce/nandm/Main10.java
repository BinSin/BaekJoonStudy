/*
 * https://www.acmicpc.net/problem/15664
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

public class Main10 {
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	
	public static void go(int[] ans, int[] arr, int[] check, int N, int M, int start, int index) throws IOException {
		if(index == M) {
			for(int i=0; i<M; i++) {
				bw.write(ans[i] + " ");
			}
			bw.write("\n");
			return;
		}
		
		for(int i=start; i<N; i++) {
			if(check[arr[i]] == 0) continue;
			
			for(int j=i+1; j<N; j++) {
				if(arr[i] == arr[j])
					i++;
			}
			
			check[arr[i]]--;
			ans[index] = arr[i];
			go(ans, arr, check, N, M, i, index+1);
			check[arr[i]]++;
		}
		
	}
	
	public static void main(String[] args) throws IOException {
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int[] arr = new int[N];
		int[] check = new int[10001];
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
			check[arr[i]]++;
		}
		Arrays.sort(arr);
		int[] ans = new int[M];
		
		go(ans, arr, check, N, M, 0, 0);
		
		bw.flush();
		br.close();
		bw.close();
		
	}
}