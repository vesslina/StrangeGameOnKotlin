class Game(private val player: Player) {

    // Информация об игре
    var levelName: String = "Уровень: Утро."
    var gameHour: String = "07:20 AM"
    var gameDay: String = "Понедельник"

    // Состояние игры (private - скрыто от внешнего мира)
    private var isRunning: Boolean = false  // Идёт ли игра сейчас
    var currentLevel: Int = 0       // Номер текущего уровня

    init {
        println("--------< Игра инициализирована! >--------")
        println("--------< Игрок: ${player.firstName} >--------")
        println("--------< Настроение: ${player.playerMood} >--------")
    }


    fun start(){
        isRunning = true
        currentLevel = 0
        clearConsole()

            val levels = listOf(LevelOne(this, player as Dmitry),
                LevelTwo(this, player as Dmitry)) //Мы создаем обьекты уровней прямо в листе
        for (level in levels) {
            if (!level.play()) {
                println("Конец игры")
                return
            }
        }
    }
    fun stop(){
        isRunning = false
    }


//Сервисные функции
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

    fun time(threadSleep: Int){
        Thread.sleep(threadSleep.toLong())
    }

    fun consentVerification(){
        do {
            print("---> ")
            val ready = readlnOrNull()?.trim() ?: ""
            if (ready.equals("yes", ignoreCase = true)) break

            println("Ты ввел полную хуйню, димон очень расстроен и недоволен," +
                    " ходи оглядывайся или все-таки попытайся ввести похожее на Old.consentVerification")
        }
        while (true)
    }

    //функция закрывающая уровень в зависимости от результатов игрока
    fun gameOver(win: String, message: String,) {
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
          println("                    --------< ${levelName} ${gameHour},${gameDay }>-------- ")
            }
            else -> {

                println("                    --------< $message >--------")}

        }
    }
}