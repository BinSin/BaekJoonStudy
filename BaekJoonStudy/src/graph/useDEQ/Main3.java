/*
 * https://www.acmicpc.net/problem/1261
 * BinSin
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

public class Main3 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int[][] maze = new int[M][N];
		for(int i=0; i<M; i++) {
			String s = br.readLine();
			for(int j=0; j<N; j++) {
				maze[i][j] = s.charAt(j) - '0';
			}
		}
		ArrayDeque<int[]> deq = new ArrayDeque<int[]>();
		int[][] dist = new int[M][N];
		for(int i=0; i<M; i++) {
			Arrays.fill(dist[i], -1);
		}
		deq.add(new int[] {0, 0});
		dist[0][0] = 0;
		while(!deq.isEmpty()) {
			int[] now = deq.poll();
			for(int[] next : new int[][] {new int[] {now[0]-1, now[1]}, {now[0], now[1]-1}, {now[0]+1, now[1]}, {now[0], now[1]+1}}) {
				if(0 <= next[0] && next[0] < M && 0 <= next[1] && next[1] < N) {
					int i = next[0]; 
					int j = next[1];
					if(dist[i][j] == -1) {
						if(maze[i][j] == 0) {
							deq.addFirst(new int[] {i, j});
							dist[i][j] = dist[now[0]][now[1]];
						} else {
							deq.addLast(new int[] {i, j});
							dist[i][j] = dist[now[0]][now[1]] + 1;
						}
					}
				}
			}
		}
		bw.write(dist[M-1][N-1] + "");
		bw.flush();
		bw.close();
		br.close();
	}
}
