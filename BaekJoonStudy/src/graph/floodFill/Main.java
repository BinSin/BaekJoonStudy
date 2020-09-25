/*
 * https://www.acmicpc.net/problem/2667
 * BinSin
 */

package graph.floodFill;

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
	
	public static class Pair {
		int x, y;
		Pair(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
	
	public static void bfs(int[][] map, int[][] visited, int x, int y, int count) {
		Queue<Pair> q = new LinkedList<Pair>();
		q.add(new Pair(x, y));
		visited[x][y] = count;
		int size = map.length;
		Pair[] nextPair = {new Pair(0, 1), new Pair(0, -1), new Pair(1, 0), new Pair(-1, 0)};
		
		while(!q.isEmpty()) {
			Pair first = q.poll();
			int nextX = first.x;
			int nextY = first.y;
			for(int i=0; i<4; i++) {
				int nx = nextX - nextPair[i].x;
				int ny = nextY - nextPair[i].y;
				if(0 <= nx && nx < size && 0 <= ny && ny < size) {
					if(map[nx][ny] != 0 && visited[nx][ny] == 0) {
						q.add(new Pair(nx, ny));
						visited[nx][ny] = count;
					}
				}
			}
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int N = Integer.parseInt(br.readLine());
		int[][] map = new int[N][N];
		for(int i=0; i<N; i++) {
			String s = br.readLine();
			for(int j=0; j<N; j++) {
				map[i][j] = s.charAt(j) - '0';
			}
		}
		
		int[][] visited = new int[N][N];
		int count = 0;
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				if(map[i][j] != 0 && visited[i][j] == 0)
					bfs(map, visited, i, j, ++count);
			}
		}
		
		int[] answer = new int[count+1];
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				if(visited[i][j] != 0)
					answer[visited[i][j]]++;
				
			}
		}
		
		Arrays.sort(answer);
		
		bw.write(count + "\n");
		for(int ans : answer)
			if(ans != 0) bw.write(ans + "\n");
		
		bw.flush();
		bw.close();
		br.close();
	}
}
