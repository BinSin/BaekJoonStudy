/*
 * BinSin
 * https://www.acmicpc.net/problem/9328
 */

package graph.bfs3;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main7 {
	
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
		
		int T = Integer.parseInt(br.readLine());
		while(T-->0) {
			int answer = 0;
			
			StringTokenizer st = new StringTokenizer(br.readLine());
			int h = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			h += 2;
			w += 2;
			
			boolean[][] check = new boolean[h][w];
			char[][] building = new char[h][w];
			for(int i=1; i<h-1; i++) {
				String s = br.readLine();
				for(int j=1, k=0; j<w-1; j++, k++) {
					building[i][j] = s.charAt(k);
				}
			}
			for(int i=0; i<h; i++) {
				building[i][0] = '.';
				building[i][w-1] = '.';
			}
			for(int i=1; i<w-1; i++) {
				building[0][i] = '.';
				building[h-1][i] = '.';
			}
			
			boolean[] key = new boolean[26];
			String s = br.readLine();
			if(!s.equals("0")) {
				for(int i=0; i<s.length(); i++) {
					key[s.charAt(i) - 'a'] = true;
				}
			}
			
			Queue<Pair> q = new LinkedList<>();
			Queue<Pair>[] door = new LinkedList[26];
			for(int i=0; i<26; i++) door[i] = new LinkedList<Pair>();
			
			q.add(new Pair(0, 0));
			check[0][0] = true;
			while(!q.isEmpty()) {
				Pair p = q.poll();
				int px = p.x;
				int py = p.y;
				Pair[] next = {new Pair(px-1, py), new Pair(px, py-1), new Pair(px+1, py), new Pair(px, py+1)}; 
				for(Pair np : next) {
					int nx = np.x;
					int ny = np.y;
					if(0 <= nx && nx < h && 0 <= ny && ny < w) {
						if(check[nx][ny]) continue;
						check[nx][ny] = true;
						
						char c = building[nx][ny];
						if(c == '*') continue;
						else if(c == '.') q.add(new Pair(nx, ny));
						else if(c == '$') {
							q.add(new Pair(nx, ny));
							answer++;
						} else if('a' <= c && c <= 'z') {
							int index = c - 'a';
							q.add(new Pair(nx, ny));
							if(!key[index]) {
								key[index] = true;
								while(!door[index].isEmpty()) {
									q.add(door[index].poll());
								}
							}
						} else {
							int index = c - 'A';
							if(key[index]) q.add(new Pair(nx, ny));
							else door[index].add(new Pair(nx, ny));
						}
					}
				}
			}
			bw.write(answer + "\n");
		}
		bw.flush();
		bw.close();
		br.close();
	}
}
