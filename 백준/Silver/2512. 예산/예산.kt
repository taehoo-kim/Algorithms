fun main() {

    // 시간 제한 1초, 메모리 제한 128MB
    // 정해진 총액 이하에서 가능한 한 최대의 총 예산을 다음과 같은 방법으로 배정
    // 1. 모든 요청이 배정될 수 있는 경우에는 요청한 금액을 그대로 배정
    // 2. 모든 요청이 배정될 수 없는 경우에는 특정한 정수 상한액을 계산하여
    // 그 이상인 예상 요청에는 모두 상한액을 배정한다.
    // 상한액 이하의 예산요청에 대해서는 요청한 금액을 그대로 배정한다.
    // 3 <= N <= 10,000 / N <= M <= 1,000,000,000

    val N = readln().toInt() // 지방의 수
    val requestMoney = readln().split(" ").map {it.toInt()}
    val M = readln().toInt() // 국가예산 총액
    var res = 0
    var right = requestMoney.maxOrNull()!!
    // 1번의 경우
    if(requestMoney.sum() <= M){
        res = right
    }
    else {
        var left: Int = M / N

        while(left <= right){
            val mid = (left + right) / 2
            var total = 0L

            for (money in requestMoney){
                total += if (money > mid) mid else money
                if(total > M) break
            }

            if(total <= M){
                res = mid
                left = mid + 1
            } else {
                right = mid - 1
            }
        }

    }

    print(res)

}