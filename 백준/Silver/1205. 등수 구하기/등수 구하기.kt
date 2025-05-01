fun main() {
    val (N, newScore, P) = readln().split(" ").map {it.toInt()}
    if(N == 0){
        print(1)
        return
    }
    val rankList = readln().split(" ").map {it.toInt()}

    var rank = 1

    for(i in 0 until rankList.size) {
        if (newScore < rankList[i]) {
            rank++
        }
    }

    if(rankList.size + 1 > P){
        if(rankList[rankList.size - 1] >= newScore){
           print("-1")
        } else {
            print("$rank")
        }
    } else {
        print("$rank")
    }

}