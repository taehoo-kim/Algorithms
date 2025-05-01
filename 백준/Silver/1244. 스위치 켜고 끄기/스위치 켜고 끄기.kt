fun switchOnOff(statusSwitch: MutableList<Int>, idx: Int){
    if(statusSwitch[idx] == 1){
        statusSwitch[idx] = 0
    } else {
        statusSwitch[idx] = 1
    }
}

fun main() {
    val N = readln().toInt()

    // 0, 1, 2, 3 인덱스인 걸
    // 1, 2, 3, 4 라고 생각해야 함
    val statusSwitch = readln().split(" ").map {it.toInt()}.toMutableList()

    val stuN = readln().toInt()

    for(i in 0 until stuN){
        val (gender, number) = readln().split(" ").map {it.toInt()}
        if(gender == 1){ // 남학생인 경우
            for(idx in number - 1 until N step number){
                switchOnOff(statusSwitch, idx)
            }
        } else { // 여학생인 경우
            var left = number - 1
            var right = number - 1

            while (left - 1 >= 0 && right + 1 < N && statusSwitch[left - 1] == statusSwitch[right + 1]) {
                left--
                right++
            }

            for (idx in left..right){
                switchOnOff(statusSwitch, idx)
            }
        }
    }

    for(i in 0 until N){
        print("${statusSwitch[i]} ")
        if((i + 1) % 20 == 0) println()
    }


}