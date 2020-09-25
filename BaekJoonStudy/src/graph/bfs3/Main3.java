/*
 * BinSin
 * https://www.acmicpc.net/problem/1525
 */

package graph.bfs3;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main3 {

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
		int start = 0;
		for(int i=0; i<3; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j=0; j<3; j++) {
				int n = Integer.parseInt(st.nextToken());
				if(n == 0) n = 9;
				start = n + start * 10;
			}
		}
		
		HashMap<Integer, Integer> hm = new HashMap<>();
		hm.put(start, 0);
		Queue<Integer> q = new LinkedList<>();
		q.add(start);
		while(!q.isEmpty()) {
			Integer n = q.poll();
			String sn = n.toString();
			int i = sn.indexOf('9');
			int x = i / 3;
			int y = i % 3;
			Pair[] p = {new Pair(x+1, y), new Pair(x-1, y), new Pair(x, y+1), new Pair(x, y-1)};
			for(Pair np : p) {
				int nx = np.x;
				int ny = np.y;
				if(0 <= nx && nx < 3 && 0 <= ny && ny < 3) {
					StringBuilder sb = new StringBuilder(sn);
					int ni = nx * 3 + ny;
					char a = sn.charAt(i);
					char b = sn.charAt(ni);
					sb.setCharAt(i, b);
					sb.setCharAt(ni, a);
					
					int nn = Integer.parseInt(sb.toString());
					if(!hm.containsKey(nn)) {
						q.add(nn);
						hm.put(nn, hm.get(n)+1);
					}
				}
			}
		}
		
		if(hm.containsKey(123456789))
			bw.write(hm.get(123456789) + "");
		else
			bw.write("-1");
		
		bw.flush();
		bw.close();
		br.close();
		
	}
}
