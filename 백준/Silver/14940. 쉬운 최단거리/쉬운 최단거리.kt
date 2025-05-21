import java.util.*

val directionX = arrayOf(1, -1, 0, 0)
val directionY = arrayOf(0, 0, -1, 1)

fun main() {
    val (n, m) = readln().split(" ").map { it.toInt() }
    val arr = Array(n) { IntArray(m) }
    val dist = Array(n) { IntArray(m) { -1 } }

    var startX = -1
    var startY = -1

    for (i in 0 until n) {
        val line = readln().split(" ").map { it.toInt() }
        for (j in 0 until m) {
            arr[i][j] = line[j]
            if (arr[i][j] == 2) {
                startX = i
                startY = j
            }
            if (arr[i][j] == 0) {
                dist[i][j] = 0 // 갈 수 없는 땅은 무조건 0 출력
            }
        }
    }

    val q: Queue<Pair<Int, Int>> = ArrayDeque()
    q.add(Pair(startX, startY))
    dist[startX][startY] = 0

    while (q.isNotEmpty()) {
        val (x, y) = q.remove()
        for (d in 0 until 4) {
            val nx = x + directionX[d]
            val ny = y + directionY[d]
            if (nx in 0 until n && ny in 0 until m) {
                if (arr[nx][ny] == 1 && dist[nx][ny] == -1) {
                    dist[nx][ny] = dist[x][y] + 1
                    q.add(Pair(nx, ny))
                }
            }
        }
    }

    for (i in 0 until n) {
        for (j in 0 until m) {
            print("${dist[i][j]} ")
        }
        println()
    }
}
