# 그래프의 탐색 (DFS/BFS)
- 목적 : 모든 정점을 1번씩 방문

## DFS
- 깊이 우선 탐색
- 끝까지 탐색하다 다시 돌아와서 탐색

## BFS
- 너비 우선 탐색
- 한 정점에서 갈 수 있는 모든 곳을 탐색

### 연결 요소
- 그래프가 나누어져 있는 경우 연결 요소 라고 한다.
- 두 개로 나누어져 있는 경우 연결 요소는 2개

### 이분 그래프
- 그래프를 A와 B 로 나누는데 A끼리, B끼리는 연결되어 있지 않는 그래프
- A를 빨강, B를 파랑이라고 하면 DFS, BFS 검사 시 빨강-파랑-빨강-파랑 이런 식
- 결국, 자기 자신과 인접한 정점들의 색깔은 서로 다르다.
