/*
 * BniSin
 * https://www.acmicpc.net/problem/15558
 * 
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

public class Main11 {

	static class Pair {
		int x, y;
		Pair(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		char game[][] = new char[2][N];
		String s = br.readLine();
		for(int i=0; i<N; i++) {
			game[0][i] = s.charAt(i);
		}
		s = br.readLine();
		for(int i=0; i<N; i++) {
			game[1][i] = s.charAt(i);
		}
		
		int[][] dist = new int[2][N];
		for(int i=0; i<=1; i++) Arrays.fill(dist[i], -1);
		Queue<Pair> q = new LinkedList<>();
		q.add(new Pair(0,0));
		dist[0][0] = 0;
		boolean check = false;
		while(!q.isEmpty()) {
			Pair p = q.remove();
			int px = p.x;
			int py = p.y;
			Pair[] next = {new Pair(px, py-1), new Pair(px, py+1), new Pair((px+1)%2, py+k)};
			for(Pair n : next) {
				int nx = n.x;
				int ny = n.y;
				
				if(ny >= N) {
					check = true;
					break;
				}
				
				if(nx < 0 || nx > 1 || ny < 0 || ny >= N) continue;
				if(dist[nx][ny] != -1 || game[nx][ny] == '0') continue;
				if(ny <= dist[px][py]) continue; // 없어지는 칸보다 위에 있어야 한다
				dist[nx][ny] = dist[px][py] + 1;
				q.add(new Pair(nx, ny));
				
			}
		}
		
		String answer = "0";
		if(check) answer = "1";
		bw.write(answer);
		bw.flush();
		bw.close();
		br.close();
	}
}
