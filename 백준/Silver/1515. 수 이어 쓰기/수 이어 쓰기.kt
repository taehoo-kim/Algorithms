fun main() {

    // 1부터 N까지 모든 수를 공백없이 한 줄에 씀
    // 마음에 드는 몇 개의 숫자를 지움
    // 똑같이 쓰려고 하지만 N이 기억이 나지 않음
    // 남은 수를 이어 붙인 수가 주어질 때, N의 최솟값을 구하시오
    // (아무 것도 지우지 않을 수 있음.)

    var input = readln()

    var index = 0
    var n = 0
    
    while(index < input.length){
        n++
        val curr = n.toString()
        for (c in curr){
            if(index < input.length && c == input[index])
                index++
        }
    }
    
    println(n)
}