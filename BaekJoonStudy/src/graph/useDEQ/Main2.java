/*
 * https://www.acmicpc.net/problem/13549
 * BinSin
 * Deque 사용
 */

package graph.useDEQ;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main2 {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		int MAX = 100000;
		int[] dist = new int[MAX+1];
		Arrays.fill(dist, -1);
		ArrayDeque<Integer> q = new ArrayDeque<Integer>();
		q.add(N);
		dist[N] = 0;
		
		while(!q.isEmpty()) {
			int now = q.poll();
			for(int next : new int[] {now*2, now-1, now+1}) {
				if(0 <= next && next <= MAX) {
					if(dist[next] == -1) {
						if(now * 2 == next) {
							dist[next] = dist[now];
							q.addFirst(next);
						} else {
							dist[next] = dist[now] + 1;
							q.addLast(next);
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