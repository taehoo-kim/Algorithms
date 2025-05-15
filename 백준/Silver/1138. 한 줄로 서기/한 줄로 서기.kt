fun main() {

    // N은 10보다 작거나 같은 자연수
    // 줄을 선 순서대로 키를 출력
    val N = readln().toInt()
    val heightList = readln().split(" ").map {it.toInt()}
    val resArr = IntArray(N)
    
    // 0인 경우에는 체크.
    
    for(i in 0 until N){
        var height = heightList[i]
        for (j in 0 until N){
            if(resArr[j] == 0){
                if(height == 0){
                    resArr[j] = i + 1
                    break
                }
                height--
            }
        }
    }
    
    println(resArr.joinToString(" "))


}
