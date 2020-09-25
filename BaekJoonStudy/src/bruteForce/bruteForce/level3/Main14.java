/*
 * BinSin
 * https://www.acmicpc.net/problem/16198
 */

package bruteForce.bruteForce.level3;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main14 {

	static int answer = 0;
	
	static void go(int N, int[] energy, int sum) {
		if(N == 2) {
			answer = Math.max(answer, sum);
			return;
		}
		for(int i=1; i<N-1; i++) {
			int[] ec = new int[N-1];
			int k = 0;
			for(int j=0; j<N; j++) {
				if(j == i) continue;
				ec[k++] = energy[j];
			}
			go(N-1, ec, sum+(energy[i-1]*energy[i+1]));
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int N = Integer.parseInt(br.readLine());
		int[] energy = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) energy[i] = Integer.parseInt(st.nextToken());
		go(N, energy, 0);
		bw.write(answer + "");
		bw.flush();
		bw.close();
		br.close();
	}
}
