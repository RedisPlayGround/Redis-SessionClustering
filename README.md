# RedisSessionClustering

### 문제 : Server는 세션 정보를 저장해야한다.

하지만 Server가 여러 대라면 최초 로그인한 Server가 아닌 Server는 세션 정보를 알지 못한다

세션 정보를 Server간에 공유할 방법이 필요한데.. SessionClustering을 해야한다

#### `Why?`

- 세션 데이터는 단순 key-value 구조
- 세션 데이터는 영속성이 필요 없음
- 세션 데이터는 변경이 빈번하고 빠른 액세스 속도가 필요


