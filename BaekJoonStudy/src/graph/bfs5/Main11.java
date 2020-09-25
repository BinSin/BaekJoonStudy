/*
 * BinSin
 * https://www.acmicpc.net/problem/14395
 */

package graph.bfs5;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;
import java.util.StringTokenizer;

public class Main11 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		Long s = Long.parseLong(st.nextToken());
		Long t = Long.parseLong(st.nextToken());
		if(s == t) {
			bw.write("0");
		} else {
			List<String> ans = new ArrayList<>();
			Queue<Long> q = new LinkedList<>();
			Set<String> set = new HashSet<>();
			q.add(s);
			set.add("");
			while(!q.isEmpty()) {
				
			}
			if(ans.isEmpty()) bw.write("-1");
			else {
				Collections.sort(ans);
				bw.write(ans.get(0) + "");
			}
		}
		bw.flush();
		bw.close();
		br.close();
	}
}
