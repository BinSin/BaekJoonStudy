/*
 * BinSin
 * https://www.acmicpc.net/problem/14225
 */

package bruteForce.bruteForce.level3;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main12 {

	static int MAX = 2000000;
	static int N;
	static int[] arr;
	static boolean[] p = new boolean[MAX];
	
	static void go(int index, int sum) {
		if(index == N) {
			p[sum] = true;
			return;
		}
		go(index+1, sum+arr[index]);
		go(index+1, sum);
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		N = Integer.parseInt(br.readLine());	
		arr = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
			p[arr[i]] = true;
		}
		go(0, 0);
		int ans;
		for(ans=1; ans<MAX; ans++) if(!p[ans]) break;
		bw.write(ans + "");
		bw.flush();
		bw.close();
		br.close();
	}
}
