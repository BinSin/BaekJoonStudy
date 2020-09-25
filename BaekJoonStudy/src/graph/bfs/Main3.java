/*
 * https://www.acmicpc.net/problem/1697
 * BinSin
 */

package graph.bfs;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main3 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		if(N == K) bw.write("0");
		else {
			int[] dist = new int[100001];
			Queue<Integer> q = new LinkedList<Integer>();
			q.add(N);
			while(!q.isEmpty()) {
				int now = q.poll();
				int[] next = {now - 1, now + 1, now * 2};
				for(int i=0; i<3; i++) {
					int n = next[i];
					if(0 <= n && n <= 100000) {
						if(dist[n] == 0) {
							q.add(n);
							dist[n] = dist[now] + 1;
						}
					}
				}
			}
			bw.write(dist[K] + "");
		}
		bw.flush();
		bw.close();
		br.close();
	}
}
