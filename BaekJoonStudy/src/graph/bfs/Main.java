/*
 * https://www.acmicpc.net/problem/2178
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

public class Main {
	
	private static class Edge {
		int x, y;
		Edge(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
	
	public static void bfs(int[][] maze, int[][] val, int x, int y, int height, int width) {
		Queue<Edge> q = new LinkedList<Edge>();
		q.add(new Edge(x, y));
		val[x][y] = 1;
		Edge[] nextLocation = {new Edge(0, 1), new Edge(1, 0), new Edge(0, -1), new Edge(-1, 0)};
		
		while(!q.isEmpty()) {
			Edge first = q.poll();
			int nextX = first.x;
			int nextY = first.y;
			for(int i=0; i<nextLocation.length; i++) {
				int nx = nextX + nextLocation[i].x;
				int ny = nextY + nextLocation[i].y;
				if(0 <= nx && nx < height && 0 <= ny && ny < width)
					if(maze[nx][ny] == 1 && val[nx][ny] == 0) {
						q.add(new Edge(nx, ny));
						val[nx][ny] = val[nextX][nextY] + 1;
					}
				
			}
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int[][] maze = new int[N][M];
		for(int i=0; i<N; i++) {
			String s = br.readLine();
			for(int j=0; j<M; j++) {
				maze[i][j] = s.charAt(j) - '0';
			}
		}
		
		int[][] val = new int[N][M];
		bfs(maze, val, 0, 0, N, M);
		
		bw.write(val[N-1][M-1] + "");
		bw.flush();
		bw.close();
		br.close();
	}
}
