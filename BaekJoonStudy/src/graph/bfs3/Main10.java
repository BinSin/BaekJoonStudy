
/*
 * BinSin
 * https://www.acmicpc.net/problem/8111
 */

package graph.bfs3;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;

public class Main10 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int T = Integer.parseInt(br.readLine());
		while(T-->0) {
			int N = Integer.parseInt(br.readLine());
			int[] from = new int[N];
			int[] how = new int[N];
			int[] dist = new int[N];
			
			for(int i=0; i<N; i++) { 
				from[i] = how[i] = dist[i] = -1;
			}
			
			Queue<Integer> q = new LinkedList<>();
			q.add(1%N);
			dist[1%N] = 0;
			how[1%N] = 1;
			while(!q.isEmpty()) {
				int now = q.remove();
				for(int i=0; i<=1; i++) {
					int num = now*10 + i;
					int next = num % N;
					if(dist[next] != -1) continue;
					dist[next] = dist[now] + 1;
					from[next] = now;
					how[next] = i;
					q.add(next);
				}
			}
			
			if(dist[0] == -1) {
				bw.write("BRAK\n");
			} else {
				StringBuilder answer = new StringBuilder();
				for(int i=0; i!=-1; i=from[i]) {
					answer.append(Integer.toString(how[i]));
				}
				bw.write(answer.reverse().toString() + "\n");
			}
		}
		bw.flush();
		bw.close();
		br.close();
	}
}
