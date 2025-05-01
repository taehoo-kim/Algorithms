fun main() {
    val N = readln().toInt()
//    val temp = Array(N) {CharArray(N)}
//
//    for(i in 0 until N){
//        val line = readLine()!!
//        for (j in 0 until N) {
//            temp[i][j] = line[j]
//        }
//    }

    val arr = Array(N){
        readln().toCharArray()
    }

    var visitedHead = false
    var heartPos: Pair<Int, Int>? = null
    for (i in 0 until N) {
        for (j in 0 until N){
            if(arr[i][j] == '*' && !visitedHead){
                visitedHead = true
                heartPos = Pair(i+1, j)
            }
        }
    }

    var leftArm = 0
    var rightArm = 0
    var waist = 0
    var leftLeg = 0
    var rightLeg = 0

    if(heartPos != null) {
        val row = heartPos.first
        val col = heartPos.second
        val x = row + 1
        val y = col + 1
        for (i in 0 until col) {
            if (arr[row][i] == '*')
                leftArm++
        }

        for (i in col + 1 until N)
            if (arr[row][i] == '*')
                rightArm++

        for (i in row + 1 until N)
            if (arr[i][col] == '*')
                waist++

        for (i in row + 1 until N)
            if (arr[i][col - 1] == '*')
                leftLeg++

        for (i in row + 1 until N) {
            if (arr[i][col + 1] == '*')
                rightLeg++
        }

        println("$x $y")

        print("$leftArm $rightArm $waist $leftLeg $rightLeg")
    }
}