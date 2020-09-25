/*
 * BinSin
 * https://www.acmicpc.net/problem/12851
 */

package graph.bfs3;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main5 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		int MAX = Math.max(N, K);
		
		int[] distance = new int[MAX*2+1];
		int[] count = new int[MAX*2+1];
		Arrays.fill(distance, -1);
		distance[N] = 0;
		count[N] = 1;
		
		Queue<Integer> q = new LinkedList<>();
		q.add(N);
		while(!q.isEmpty()) {
			int l = q.poll();
			int[] next = {l-1, l+1, l*2};
			for(int n : next) {
				if(0 <= n && n <= MAX*2) {
					if(distance[n] == -1) {
						q.add(n);
						distance[n] = distance[l] + 1;
						count[n] = count[l];
					}
					else if(distance[n] == distance[l] + 1) {
						count[n] += count[l];
					}
				}
			}
		}
		bw.write(distance[K] + "\n" + count[K]);
		bw.flush();
		bw.close();
		br.close();
		
	}
}
