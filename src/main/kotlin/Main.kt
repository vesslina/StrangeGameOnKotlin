import kotlin.concurrent.timer
import kotlin.random.Random

var gameNumber: String = "День 1 "
var gameHour: String = "- 07:20 AM -"
var gameDay: String = "Понедельник"


var boshki = false  // false, димон не курил бошки и завтракал тухлыми яйцами либо вообще не завтракал
var sral = false  //срал димон в уровне "Утро" или нет
var eating = false //Ел ли димон тухлые яйца
var dimonProebalTralik: Boolean = false  // true - если димон проебал тралик и ехал на чем-то другом в колледж
var taxiBoshki = false // Ехал ли димон накуренный на такси
var taxi = false // Ехал ли димон на такси


fun main(){
     //ВЫЗОВ ФУНКЦИЙ
    clearConsole()// Чистит консоль для красоты
    intro() // Интро игры

    if (!morning()){ // Начало игры/Утро
        return
    }

   introSecond()//Интро после прохождения уровня "утро"

    if (!morningLunch()) { //Начало игры/ утро - обед
        return
    }






}
