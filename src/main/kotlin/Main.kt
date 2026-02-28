import kotlin.concurrent.timer
import kotlin.random.Random

var gameNumber: String = "День 1 "
var gameHour: String = "- 07:20 AM -"
var gameDay: String = "Понедельник"
fun main(){



//ВЫЗОВ ФУНКЦИЙ
    clearConsole()
    if (!intro() ){ // Начало игры/приветствие
        return}

    if (!morning()){ // Начало игры/Утро
        return
    }

    if (!introSecond()){
        return
    }

    if (!morningLunch()) { //Начало игры/ утро - обед
        return
    }






}
