abstract class Player(val firstName: String, val secondName: String, val funName: List<String> = listOf("Димка")) {


    //Уровень утро
    var smokeGrass: Boolean = false      // курил ли траву
    var sral: Boolean = false            // срал в уровне "Утро"
    var eatingEgs: Boolean = false          // ел ли тухлые яйца ex eating
    var cleanTeeth: Boolean = false      // чистил ли зубы утром

    //Уровень Обед-Утро
    var missedTrolleybus: Boolean = false  // проебал ли тралик ex dimonProebalTralik
    var stonedTaxi : Boolean = false          // ехал на такси накуренным ex taxiBoshki
    var tookTaxi: Boolean = false                // ехал ли на такси вообще ex taxi


    //Накопительный счетчик, после достижения определенной отметки игра что-то сделает, будет сделано позже через функцию
    var chekSral = 0  //Предупреждение о том что игроку нужно посрать
    var chekEating  = 0// нужно поесть


    //Инвентарь
    val inventory = mutableListOf<String>()

    //Игровые функции
    var playerMood: Int = 100  //Начальное настроение, min 0 and max 100
    var playerHealth: Int = 100 //Пока не используются
    var score: Int = 0  //Рандом переменная, за какие-то действия я буду давать игроку очки, они не влияют на ход игры

    fun checkInventory(): String {
        return if (inventory.isEmpty()) {
            "Кажется карманы $firstName пусты"
        } else {
            "в карманах  ${dropRandomName()} нашел: ${inventory.joinToString()}"
        }
    }
    //Пример вызова: println(dimka.checkInventory())


    //Изменение жизней
    fun changeHealth(amount: Int) {
        playerMood += amount
        // Ограничиваем от 0 до 100
        if (playerHealth > 100) playerHealth = 100
        if (playerHealth < 0) playerHealth = 0
        println("Количество hp изменено на $amount. Количество hp $playerHealth/100")
    }


    //Изменение настроения
    fun changeMood(amount: Int) {
        playerMood += amount
        // Ограничиваем от 0 до 100
        if (playerMood > 100) playerMood = 100
        if (playerMood < 0) playerMood = 0
        println("Настроение изменено на $amount. Настроение $playerMood/100")
    }
    //Отображение полной игровой статистики
    fun fullShowStatus() {
        println("""
            Вывод полной игровой статистики:
            
            $playerHealth/100 - Оставшееся здоровье игрока 
            $playerMood/100 - Оставшееся настроение игрока 
            
            Предметы в карманах: ${checkInventory()}
            
            Суммарное количество очков: $score
            
            Уровень 1: Утро.
            Ходил срать утром: ${if (sral) "Да" else "Нет"}
            Ел ли тухлые яйца: ${if (eatingEgs) "Да" else "Нет"}
            Курил ли бошки: ${if (smokeGrass) "Да" else "Нет"}
            Чистил ли зубы: ${if (cleanTeeth) "Да" else "Нет"}
            
            Уровень 2: Обед-Утро.
            Проебал ли тралик: ${if (missedTrolleybus) "Да" else "Нет"}
            Ехал на такси: ${if (tookTaxi) "Да" else "Нет"}
            ${
            if (tookTaxi) {
                if (stonedTaxi) 
                        "Статус: Ехал накуренный"
                else "   Статус: Ехал трезвый"
            } else ""  }
            
            
        """.trimIndent())
    }

    fun dropRandomName(): String {
        return funName.random()
       //Пример вызова: println(Old.dimka.dropRandomName())
    }

}



class Dmitry(firstName: String = "Дмитрий" ,secondName: String = "Павлов", funName: List<String> = listOf("Димка", "Димон", "Димасик", "Дмитрий")): Player(firstName, secondName, funName) {

}