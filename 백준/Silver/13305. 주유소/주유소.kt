fun main() {

    // 시간제한 2초, 메모리 512MB
    // N개의 도시, 1km 당 1리터
    // 각 도시에 단 하나의 주유소 (도시마다 리터당 가격 다름)
    // 최소 비용 찾기

    val N = readln().toInt()
    val dist = readln().split(" ").map {it.toInt()}
    val cost = readln().split(" ").map {it.toInt()}
    var minCost: Long = 0
    var minOil = cost[0] // 현재 오일 최솟값을 저장해놓는다.
    var oil = 0

    for (i in 0..N - 1){
        if(i == N - 1) break // 끝까지 도착했을 때, 반복문 종료
        if(cost[i] < minOil) // 현재 가격이 만약 최소인 경우엔 업데이트
            minOil = cost[i]
        minCost += (dist[i] - oil) * minOil
    }

    print(minCost)
}