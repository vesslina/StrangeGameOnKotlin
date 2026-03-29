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
        //LevelTwo(this, player as Dmitry)
        //LevelOne(this, player as Dmitry)
            val levels = listOf(LevelTwo(this, player as Dmitry),) //Мы создаем объекты уровней прямо в листе
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


    fun gameOver(message: String,) {
        println("                    --------< $message >--------")

    }
    //функция закрывающая уровень в зависимости от результатов игрока
    fun gameOver(win: Boolean, message: String,){
        when (win) {
            true -> {
                time(3000)
                println("======================================================================================================================")
                println("                      --------< УРОВЕНЬ ПРОЙДЕН $message >-------- ")
                println("======================================================================================================================")
                println()
                time(3000)
            }

            false -> {
                time(3000)
                println("======================================================================================================================")
                println("                       --------< GAME OVER $message >--------  ")
                println("======================================================================================================================")
                println()
                time(3000)

            }
        }
    }

    fun gameOver(win: Boolean, message: Boolean,){
        when{
            (win == false && message == false)-> {
                println("======================================================================================================================")
            }
            (win && message)->{
                println("                    --------< ${levelName} ${gameHour},${gameDay }>-------- ")
            }


        }

    }


    fun luckNumberRandom(): Boolean{

        val compNumbers = List(3) { (1..10).random() }

        val prompts = listOf(
            "Введи своё первое число от 1 до 10!",
            "Эмм.. Окей, теперь введи второе число....",
            "А теперь третье..."
        )

        val playerNumbers = prompts.map { prompt ->
            println(prompt)
            readlnOrNull()?.trim()?.toInt() ?: 0
        }

        val hasWon = playerNumbers.any { it in compNumbers }
        println("\nТвои числа: $playerNumbers")
        time(3000)
        println("Иии... Момент истины, вены на лбу Димки щас лопнут нахуй....")
        time(3000)
        println("Числа компьютера: $compNumbers")

        return hasWon

    }

}