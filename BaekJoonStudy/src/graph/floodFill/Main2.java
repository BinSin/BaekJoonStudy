/*
 * https://www.acmicpc.net/problem/4963
 * BinSin
 */

package graph.floodFill;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main2 {
	
	public static class Pair {
		int x, y;
		Pair(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
	
	public static void bfs(int[][] map, boolean[][] visited, int x, int y, int width, int height) {
		Queue<Pair> q = new LinkedList<Pair>();
		q.add(new Pair(x, y));
		Pair[] nextPair = 	{
							new Pair(-1, -1), new Pair(0, -1), new Pair(1, -1), 
							new Pair(-1, 0), new Pair(1, 0),
							new Pair(-1, 1), new Pair(0, 1), new Pair(1, 1)
							};
		
		while(!q.isEmpty()) {
			Pair first = q.poll();
			int nextX = first.x;
			int nextY = first.y;
			for(int i=0; i<nextPair.length; i++) {
				int nx = nextX - nextPair[i].x;
				int ny = nextY - nextPair[i].y;
				if(0 <= nx && nx < height && 0 <= ny && ny < width) {
					if(map[nx][ny] != 0 && !visited[nx][ny]) {
						q.add(new Pair(nx, ny));
						visited[nx][ny] = true;
					}
				}
			}
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		String s;
		while(!(s = br.readLine()).equals("0 0")) {
			StringTokenizer st = new StringTokenizer(s);
			int w = Integer.parseInt(st.nextToken());
			int h = Integer.parseInt(st.nextToken());
			int[][] map = new int[h][w];
			for(int i=0; i<h; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j=0; j<w; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			boolean[][] visited = new boolean[h][w];
			int count = 0;
			for(int i=0; i<h; i++) {
				for(int j=0; j<w; j++) {
					if(map[i][j] != 0 && !visited[i][j]) {
						count++;
						bfs(map, visited, i, j, w, h);
					}
				}
			}
			
			bw.write(count + "\n");
		}
		
		bw.flush();
		bw.close();
		br.close();
	}
}
