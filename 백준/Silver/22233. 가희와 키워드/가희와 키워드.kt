fun main() {

    // 키워드는 모두 다르며, 총 N개가 존재
    // 최대 10개의 키워드에 대해서 글을 작성
    // 키워드는 글을 쓴 이후 메모장에서 지움
    // 메모장에 있는 키워드 개수 구하기

    // N, M은 2만 이하

    val (N, M) = readln().split(" ").map {it.toInt()}

    val keywords = HashSet<String>()
    repeat(N){
        val keyword = readln()
        keywords.add(keyword)
    }
    var res = N
    val sb = StringBuilder()
    repeat(M){
        val use = readln().split(",").map {it}
        for(element in use){
            if(keywords.remove(element))
                res--
        }

        sb.append("$res\n")
    }
    
    println(sb)
}