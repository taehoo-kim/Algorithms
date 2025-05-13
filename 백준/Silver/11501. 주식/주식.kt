var res = 0L

fun invest(start: Int, end: Int, prices: List<Int>){

    if(start == end) return

    var maxPrice = -1
    var maxIndex = 0
    for(i in start until end){
        if(maxPrice < prices[i]) maxPrice = prices[i]
    }
    for(i in start until prices.size){
        if(maxPrice == prices[i])
            maxIndex = i
    }

    for(i in start until maxIndex){
        res += (maxPrice - prices[i])
    }

    invest(maxIndex + 1, end, prices)

}


fun main() {

    // 주식 하나를 산다.
    // 원하는 만큼 가지고 있는 주식을 판다.
    // 아무것도 안한다.

    // 날 별로 주식의 가격을 알려주었을 때,
    // 최대 이익이 얼마나 되는지 계산
    val T = readln().toInt()
    var sb = StringBuilder()
    repeat(T){
        res = 0L

        val N = readln().toInt()
        val prices = readln().split(" ").map {it.toInt()}

        invest(0, N, prices)

        sb.appendLine(res.toString())
    }

    println(sb)
}