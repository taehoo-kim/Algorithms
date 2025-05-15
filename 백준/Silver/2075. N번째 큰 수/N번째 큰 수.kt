import java.util.Collections
import java.util.PriorityQueue

fun main() {
    val N = readln().toInt()

    val heap = PriorityQueue<Int>(Collections.reverseOrder())
    for(i in 0 until N){
        val input = readln().split(" ").map {it.toInt()}

        for(j in 0 until N){
            heap.add(input[j])
        }
    }

    for(i in 0 until N - 1){
        heap.poll()
    }

    print(heap.poll())
}
