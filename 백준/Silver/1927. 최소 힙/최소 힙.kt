import java.util.PriorityQueue

fun main() {

    // 최소 힙을 사용
    // 배열에 자연수 x를 넣는다.
    // 배열에서 가장 작은 값을 출력하고, 그 값을 배열에서 제거한다.

    val N = readln().toInt()
    val arr = PriorityQueue<Int>()
    var sb = StringBuilder()

    repeat(N){
        val input = readln().toInt()

        if(input == 0){
            if(arr.size == 0) sb.appendLine(0)
            else sb.appendLine(arr.poll())
        } else {
            arr.add(input)
        }
    }

    print(sb)

}