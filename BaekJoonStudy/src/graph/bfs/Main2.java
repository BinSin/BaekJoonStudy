/*
 * https://www.acmicpc.net/problem/7576
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

public class Main2 {
	
	private static class Edge {
		int x, y;
		Edge(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
	
	public static int allLipen(int[][] fruits, int[][] dist, int width, int height) {
		int max = 0;
		for(int i=0; i<height; i++) {
			for(int j=0; j<width; j++) {
				if(dist[i][j] == 0 && fruits[i][j] == 0) return -1;
				else if(dist[i][j] > 0) {
					if(max < dist[i][j]) max = dist[i][j];
				}
			}
		}
		return max;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int M = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(st.nextToken());
		int[][] fruits = new int[N][M];
		int[][] dist = new int[N][M];
		Queue<Edge> q = new LinkedList<Edge>();
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<M; j++) {
				int val = Integer.parseInt(st.nextToken());
				if(val == 1) {
					q.add(new Edge(i, j));
				}
				fruits[i][j] = val;
				dist[i][j] = val == -1 ? -1 : 0;
			}
		}
		
		Edge[] nextLocation = {new Edge(0, 1), new Edge(1, 0), new Edge(0, -1), new Edge(-1, 0)};
		
		while(!q.isEmpty()) {
			Edge first = q.poll();
			int nextX = first.x;
			int nextY = first.y;
			for(int i=0; i<nextLocation.length; i++) {
				int nx = nextX + nextLocation[i].x;
				int ny = nextY + nextLocation[i].y;
				if(0 <= nx && nx < N && 0 <= ny && ny < M)
					if(fruits[nx][ny] == 0 && dist[nx][ny] == 0) {
						q.add(new Edge(nx, ny));
						dist[nx][ny] = dist[nextX][nextY] + 1;
					}
				
			}
		}
		
		bw.write(allLipen(fruits, dist, M, N) + "");
		
		bw.flush();
		bw.close();
		br.close();
	}
}
