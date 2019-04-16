package bfs_concept;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Bfs {

	private static int N; // 노드의 개수
	private static int E; // 간선의 개수
	private static int S; // 시작 노드의 번호
	
	private static int x;
	private static int y;
	
	private static ArrayList<Integer> [] graph;
	
	private static ArrayList<Integer> bfs;
	
	private static boolean[] visit; // 이미 방문한 노드의 정보를 담을 배열
	
	private static Queue<Integer> Q;
	
	private static BufferedReader br;
	private static BufferedWriter bw;
	
	private static StringTokenizer st;
	
	public static void main(String[] args) throws IOException {
		br= new BufferedReader(new InputStreamReader(System.in));
		bw= new BufferedWriter(new OutputStreamWriter(System.out));
		
		st= new StringTokenizer(br.readLine());
		
		N= Integer.parseInt(st.nextToken());
		E= Integer.parseInt(st.nextToken());
		S= Integer.parseInt(st.nextToken());
		
		graph= new ArrayList[E+1];
		
		for(int i= 1; i <= E; i++) { // 각 노드와 간선으로 연결되어 있는 노드들에 대한 정보를 담을 리스트를 초기화
			graph[i]= new ArrayList<Integer>();
		}
		
		for(int i= 0; i< E; i++) {
			st= new StringTokenizer(br.readLine());
			x= Integer.parseInt(st.nextToken());
			y= Integer.parseInt(st.nextToken());
			
			graph[x].add(y); // 방향성이 없는 그래프이기 때문에 연결되는 양쪽에 서로에 대한 정보를 넣어준다.
			graph[y].add(x); 
		}
		
		for(int i= 1; i <= E; i++) { // 연결된 간선 정보를 정렬
			Collections.sort(graph[i]);
		}
		
		bfsSolution();
		
		for (int i= 0; i< bfs.size(); i++) {
			System.out.print(bfs.get(i)+ " ");
		}
	}

	private static void bfsSolution() {
		bfs= new ArrayList<Integer>();
		visit= new boolean[E+1];
		Q= new LinkedList<Integer>();
		
		Q.add(S); // 시작노드를 큐에 넣는다.
		
		visit[S]= true; // 시작노드를 방문했다는 정보를 저장
		
		while(!Q.isEmpty()) { // 큐에 노드가 남아 있다면 계속 수행
			int q= Q.poll(); // 큐에서 노드를 뺌
			bfs.add(q);
			
			for(int i : graph[q]) { // 큐에서 빼낸 노드들과 연결되어 있는 노드들을 큐에 넣고 visit 배열에 체크 
				if(!visit[i]) {
					Q.add(i);
					visit[i]= true;
				}
			}
		}
	}
}