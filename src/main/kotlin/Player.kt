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


    //Инвентарь
    val inventory = mutableListOf<String>()

    //Игровые функции
    var playerMood: Int = 100  //Начальное настроение, min 0 and max 100
    var playerHealth: Int = 100 //Пока не используются

    fun checkInventory(): String {
        return if (inventory.isEmpty()) {
            "Кажется карманы $firstName пусты"
        } else {
            "в карманах  ${dropRandomName()} нашел: ${inventory.joinToString()}"
        }
    }
    //Пример вызова: println(Old.dimka.checkInventory())


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