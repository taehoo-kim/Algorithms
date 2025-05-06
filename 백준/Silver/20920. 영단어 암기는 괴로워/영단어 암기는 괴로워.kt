import java.io.*
import java.util.*

fun main() {

    // 시간 제한 1초, 메모리 제한 1024MB
    // 우선순위는 다음과 같다.
    // 1. 자주 나오는 단어일수록 앞에 배치
    // 2. 해당 단어의 길이가 길수록 앞에 배치한다
    // 3. 알파벳 사전 순으로 앞에 있는 단어일수록 앞에 배치한다
    // 길이가 M이상인 단어들만
    // 1 <= N <= 100,000 / 1 <= M <= 10
    val br = BufferedReader(InputStreamReader(System.`in`))
    val (N, M) = StringTokenizer(br.readLine()).run{
        nextToken().toInt() to nextToken().toInt()
    }

    val words = mutableMapOf<String, Int>()


    for(i in 0 until N){
        val temp = br.readLine()
        if(temp.length < M) continue // 길이가 M 미만이면, 건너뛴다.
        if(temp in words.keys)
            words[temp] = words[temp]!! + 1 // 이미 존재하면 기존 값에 1 더하기
        else
            words[temp] = 1 // 처음이라면 1로 초기화
    }

    val sortedList = words.keys.sortedWith(
        compareByDescending<String> {words[it] ?: 0}
            .thenByDescending { it.length }
            .thenBy { it }
    )
    
    println(sortedList.joinToString("\n"))

}