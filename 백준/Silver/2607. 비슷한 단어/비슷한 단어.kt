fun main() {

    // 같은 구성
    // 두 개의 단어가 같은 종류의 문자로 이루어져 있다.
    // 같은 문자는 같은 개수 만큼 있다.
    // -> 이건 그냥 정렬했을 때 같은 단어가 나오면 됨..

    // 한 단어에서 한 문자를 더하거나, 빼거나, 하나의 문자를 다른 문자로 치환해서
    // 나머지 한 단어와 같은 구성을 갖게 되는 경우에 비슷한 단어라고 함

    // 하나의 문자만 다르거나
    // 빼거나
    // 더하거나 (길이가 하나가 하나만큼 길고 그걸 제외한 문자가 다 같음)

    val N = readln().toInt()

    var firstWord = readln()
    firstWord = firstWord.toList().sorted().joinToString("")
    var res = 0



    for(i in 0 until N - 1){
        var tempWord = readln()
        tempWord = tempWord.toList().sorted().joinToString("")
        val visited = mutableListOf<Int>()
        if(tempWord.length + 1 == firstWord.length){
            // 길이가 1이 긴 경우,
            var cnt = 0
            for(j in tempWord){
                var find = 0
                for(idx in 0 until firstWord.length){
                    if(j == firstWord[idx] && find == 0){
                        if(idx !in visited) {
                            visited.add(idx)
                            find = 1
                            cnt++
                        }
                    }
                }
            }
            if(cnt == tempWord.length) res++
        } else if(tempWord.length - 1 == firstWord.length){
            // 길이가 1이 짧은 경우,
            var cnt = 0
            for(j in firstWord){
                var find = 0
                for(idx in 0 until tempWord.length){
                    if(j == tempWord[idx] && find == 0) {
                        if(idx !in visited){
                            visited.add(idx)
                            find = 1
                            cnt++
                        }
                    }
                }
            }
            if(cnt == firstWord.length) res++

        } else if(tempWord.length == firstWord.length) {
            // 길이가 같은 경우
            var cnt = 0
            for(j in tempWord){
                var find = 0
                for(idx in 0 until firstWord.length){
                    if(j == firstWord[idx] && find == 0) {
                        if(idx !in visited) {
                            visited.add(idx)
                            find = 1
                            cnt++
                        }
                    }
                }
            }

            if(cnt >= firstWord.length - 1) res++

        }


        // 나머지는 없다
    }

    print(res)
}