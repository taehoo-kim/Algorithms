fun main() {
    // 0~N을 밝히게 가로등을 설치해 달라
    // 가로등을 설치할 개수 M과 각 가로등의 위치 x
    // 가로등은 높이만큼 주위를 비출 수 있다.
    // 이미 가로등 위치 결정은 x로 정해짐
    // 높이가 높을수록 가격이 비쌈
    // 최소한의 예산으로 들 높이
    val N = readln().toInt()
    val M = readln().toInt()
    val xList = readln().split(" ").map {it.toInt()}

    // 0 ~ xList[0], xList[0] ~ xList[1] , ... , xList[M-2] ~ xList[M-1] , xList[M-1] ~ N
    // 근데 끝 부분을 제외하고는 겹치는 부분이 분명 있겠지.

    // 2~4라고 가정했을 때는 h가 1이여도 가능함 -> 즉 차이가 짝수인 경우
    // 2~5라고 가정했을 때는 h가 2이여야 가능함 -> 즉 차이가 홀수인 경우
    // 처음, 끝, 그리고 사이 값 중 최대값을 구해야 함

    val first = xList[0] - 0;
    val end = N - xList[M - 1];
    val subList = mutableListOf<Int>()


    for(i in 0 until M - 1){
        val sub = xList[i + 1] - xList[i]

        if(sub % 2 == 0){
            subList.add(sub/2)
        } else {
            subList.add(sub/2 + 1)
        }
    }

    val subListMax = subList.maxOrNull() ?: 0

    val res = maxOf(first, end, subListMax)

    print(res)
}