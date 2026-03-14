

//функция закрывающая уровень в зависимости от результатов игрока
fun gameOver(win: String, message: String ){
    when (win){
        "true" -> {
            time(3000)
            println("======================================================================================================================")
            println("                      --------< УРОВЕНЬ ПРОЙДЕН $message >-------- ")
            println("======================================================================================================================")
            println()
            time(3000)
        }
        "false" -> {
            time(3000)
            println("======================================================================================================================")
            println("                       --------< GAME OVER $message >--------  ")
            println("======================================================================================================================")
            println()
            time(3000)

        }
        else if (win == "==" && message == "==")-> {
            println("======================================================================================================================")
        }
        else if (win == "Go" && message == "Go")->{
            println("                    --------< $gameNumber,$gameHour,$gameDay >-------- ")
        }
        else -> {

            println("                    --------< $message >--------")}

    }
}

fun consentVerification(){
    do {
        print("---> ")
        val ready = readlnOrNull()?.trim() ?: ""
        if (ready.equals("yes", ignoreCase = true)) break

        println("Ты ввел полную хуйню, димон очень расстроен и недоволен," +
                " ходи оглядывайся или все-таки попытайся ввести похожее на consentVerification")
    }
    while (true)
}

fun time(threadSleep: Int){
    Thread.sleep(threadSleep.toLong())
}

fun clearConsole(){
    repeat(50){ println()}

}

fun readChoice(validOptions: List<String>): String {
         while (true) {
             print("---> ")
                val input = readlnOrNull()?.trim()?.lowercase() ?: ""
                if (input in validOptions) return input
                 println("Я нихуя не понял, выбери заново")
         }
}