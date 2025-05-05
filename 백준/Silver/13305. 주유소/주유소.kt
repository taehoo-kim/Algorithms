fun main() {

    // 시간제한 2초, 메모리 512MB
    // N개의 도시, 1km 당 1리터
    // 각 도시에 단 하나의 주유소 (도시마다 리터당 가격 다름)
    // 최소 비용 찾기

    val N = readln().toInt()
    val dist = readln().split(" ").map {it.toInt()}
    val cost = readln().split(" ").map {it.toInt()}
    var minCost = 0
    var oil = 0

    var restDist = 0

    for(i in 0 until dist.size){
        restDist += dist[i]
    }

    for (i in 0..N - 1){
        if(i == N - 1) break // 끝까지 도착했을 때, 반복문 종료
        if(oil >= restDist) break // 현재 기름이 남은 거리보다 같거나 많아지는 순간, 반복문 종료
        restDist -= dist[i] // 남은 거리 갱신해주고 . 사실 무조건 가긴 해야하니

        if(oil < dist[i]) { // 만약 내가 지금 바로 갈 거리보다 기름이 없는 경우
            minCost += (dist[i] - oil) * cost[i] // 결과 비용에 추가해주고

            // 현재 갈 거리의 기름은 바로 쓰니깐.. 따로 처리 안하고

            if(i < N - 1) { // 최종 목적지가 아니고
                if (cost[i] < cost[i + 1]) { // 지금 가격이 더 싼 경우..

                    if(restDist < dist[i + 1] + oil){
                        minCost += restDist * cost[i]
                        oil += restDist
                    } else {
                        oil += dist[i + 1] // 기름을 다음 거리만큼 추가하고
                        minCost += dist[i + 1] * cost[i] // 지금 선결제한다.
                    }
                }
            }

        } else { // 기름이 충분한 경우엔
            oil -= dist[i] // 우선 기름 소비

            if(i < N - 1){ // 최종에 다다르지 않았다면
                if (cost[i] < cost[i + 1]) { // 지금 가격이 더 싸면
                    // 하지만 남은 거리에 따라 또 다르긴 함..

                    // 남은 거리보다 추가했을 경우가 더 크면
                    if(restDist < dist[i + 1] + oil){
                        minCost += restDist * cost[i] // 남은 거리만큼만 충전함
                        oil += restDist
                    } else {
                        oil += dist[i + 1]
                        minCost += dist[i + 1] * cost[i] // 미리 선 결제한다.
                    }
                }
            }
        }
    }

    print(minCost)
}