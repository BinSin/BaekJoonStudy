/*
 * BinSin
 * https://www.acmicpc.net/problem/4991
 */

package graph.bfs3;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main8 {

	static class Pair {
		int x, y;
		Pair(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
	
	public static void swap(int[] p, int a, int b) {
		int tmp = p[a];
		p[a] = p[b];
		p[b] = tmp;
	}
	
	public static boolean next_permutation(int[] p) {
		int I = -1, J = 0;
		for(int i=p.length-1; i>0; i--) {
			if(p[i-1] < p[i]) {
				I = i-1;
				break;
			}
		}
		
		if(I == -1) return false;
		
		for(int j=p.length-1; j>=0; j--) {
			if(p[I] < p[j]) {
				J = j;
				break;
			}
		}
		
		swap(p, I, J);
		
		J = p.length - 1;
		while(I < J) {
			swap(p, I+1, J);
			I++;
			J--;
		}
		
		return true;
	}
	
	public static int[][] bfs(char[][] room, Pair start, int h, int w) {
		int[][] count = new int[h][w];
		for(int i=0; i<h; i++) Arrays.fill(count[i], -1);
		Queue<Pair> q = new LinkedList<>();
		count[start.x][start.y] = 0; 
		q.add(start);
		
		while(!q.isEmpty()) {
			Pair p = q.poll();
			int x = p.x;
			int y = p.y;
			Pair[] next = {new Pair(x+1, y), new Pair(x, y-1), new Pair(x-1, y), new Pair(x, y+1)}; 
			for(Pair n : next) {
				int nx = n.x;
				int ny = n.y;
				if(nx < 0 || nx >= h || ny < 0 || ny >= w) continue;
				if(count[nx][ny] >= 0 || room[nx][ny] == 'x') continue;
				count[nx][ny] = count[x][y] + 1;
				q.add(new Pair(nx, ny));
			}
		}
		
		return count;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		while(true) {
			st = new StringTokenizer(br.readLine());
			int w = Integer.parseInt(st.nextToken());
			int h = Integer.parseInt(st.nextToken());
			if(h == 0 && w == 0) break;
			
			List<Pair> dirty = new LinkedList<>();
			dirty.add(new Pair(0, 0));
			char[][] room = new char[h][w];
			for(int i=0; i<h; i++) {
				String s = br.readLine();
				for(int j=0; j<w; j++) {
					char c = s.charAt(j);
					room[i][j] = c;
					if(c == 'o') dirty.set(0, new Pair(i, j));
					else if(c == '*') dirty.add(new Pair(i, j));
				}
			}
			
			int length = dirty.size();
			
			int[][] d = new int[length][length];
			boolean check = true;
			for(int i=0; i<length; i++) {
				Pair s = dirty.get(i);
				int[][] dist = bfs(room, s, h, w);
				for(int j=0; j<length; j++) {
					Pair e = dirty.get(j);
					d[i][j] = dist[e.x][e.y];
					if(d[i][j] == -1) {
						check = false;
						break;
					}
				}
				if(!check) {
					break;
				}
			}
			
			int answer = Integer.MAX_VALUE;
			
			if(!check) {
				answer = -1;
				bw.write(answer + "\n");
				continue;
			}
			
			int[] per = new int[length-1];
			for(int i=0; i<length-1; i++) {
				per[i] = i + 1;
			}
			
			do {
				int now = d[0][per[0]];
				for(int i=0; i<length-2; i++) {
					now += d[per[i]][per[i+1]];
				}
				answer = answer > now ? now : answer;
			} while(next_permutation(per));
			
			bw.write(answer + "\n");
		}
		bw.flush();
		bw.close();
		br.close();
	}
}
