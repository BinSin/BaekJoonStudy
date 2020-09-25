/*
 * BinSin
 * https://www.acmicpc.net/problem/12906
 */

package graph.bfs5;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main10 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		String[] sa = new String[3];
		for(int i=0; i<3; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			if(N == 0) sa[i] = "";
			else sa[i] = st.nextToken();
		}
		int[] count = {0, 0, 0};
		for(String s : sa) {
			for(char c : s.toCharArray()) {
				count[c-'A']++;
			}
		}
		
		HashMap<List<String>, Integer> hm = new HashMap<>();
		Queue<List<String>> q = new LinkedList<>();
		q.add(Arrays.asList(sa));
		// Collections.unmodifiableList : 기존의 List를 인자로 받아 새로운 리스트를 리턴 받는 매소드
		// 불필요한 리스트 복자 동작을 피하기 할 수 있다.
		// 다만 리턴되는 리스트의 래퍼런스는 'Read-Only' 이므로 수정하려하면 익셉션 발생한다.
		hm.put(Collections.unmodifiableList(Arrays.asList(sa)), 0);
		while(!q.isEmpty()) {
			String[] now = q.remove().toArray(new String[3]);
			for(int i=0; i<3; i++) {
				for(int j=0; j<3; j++) {
					if(i == j) continue;
					if(now[i].length() == 0) continue;
					String[] next = {now[0], now[1], now[2]};
					next[j] += next[i].charAt(next[i].length()-1);
					next[i] = next[i].substring(0, next[i].length()-1);
					List<String> nextQ = Collections.unmodifiableList(Arrays.asList(next));
					if(!hm.containsKey(nextQ)) {
						q.add(nextQ);
						hm.put(nextQ, hm.get(Arrays.asList(now)) + 1);
					}
				}
			}
		}
		String[] ans = new String[3];
		for(int i=0; i<3; i++) {
			ans[i] = "";
			for(int j=0; j<count[i]; j++) {
				ans[i] += (char)('A' + i);
			}
		}
		bw.write(hm.get(Arrays.asList(ans)) + "");
		bw.flush();
		bw.close();
		br.close();
	}
}
