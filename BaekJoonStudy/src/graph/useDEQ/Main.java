/*
 * https://www.acmicpc.net/problem/13549
 * BinSin
 * Queue 사용
 */

package graph.useDEQ;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		if(N >= K) {
			bw.write(N - K + "");
			bw.flush();
			return;
		}
		int MAX = N == 0 ? K : N * (K / N + 1);
		MAX = MAX > 100000 ? 100000 : MAX;
		
		int[] dist = new int[MAX+1];
		Arrays.fill(dist, -1);
		Queue<Integer> q = new LinkedList<Integer>();
		q.add(N);
		dist[N] = 0;
		if(N != 0) {
			for(int i=N*2; i<=MAX; i*=2) {
				dist[i] = 0;
				q.add(i);
			}
		}
		while(!q.isEmpty()) {
			int now = q.poll();
			int[] next = {-1, 1};
			for(int i=0; i<next.length; i++) {
				int n = now + next[i];
				if(0 <= n && n <= MAX) {
					if(dist[n] == -1) {
						q.add(n);
						dist[n] = dist[now] + 1;
						if(n != 0) {
							for(int j=n*2; j<=MAX; j*=2) {
								if(dist[j] == -1) {
									q.add(j);
									dist[j] = dist[now] + 1;
								}
							}
						}
					}
				}
			}
		}
		
		bw.write(dist[K] + "");
		bw.flush();
		bw.close();
		br.close();
	}
}
