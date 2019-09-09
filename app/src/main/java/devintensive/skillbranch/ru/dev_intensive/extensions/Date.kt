package devintensive.skillbranch.ru.dev_intensive.extensions

import java.text.SimpleDateFormat
import java.util.*

const val SECOND = 1000L
const val MINUTE = 60 * SECOND
const val HOUR = 60 * MINUTE
const val DAY = 24 * HOUR

fun Date.format(pattern:String = "HH:mm:ss dd.MM.yy"):String {
    val dateFormat = SimpleDateFormat(pattern, Locale("ru"))
    return dateFormat.format(this)
}

fun Date.add(value:Int, units: TimeUnits = TimeUnits.SECOND) : Date{
        var time = this.time
   time += when(units){
        TimeUnits.SECOND -> value * SECOND
        TimeUnits.MINUTE -> value * MINUTE
        TimeUnits.HOUR -> value * HOUR
        TimeUnits.DAY -> value * DAY
    }
    this.time = time
    return this
}

fun Date.humanizeDiff(date:Date = Date()): String? {
    /*var str:String? = ""
    when(units)
    {
        TimeUnits.SECOND -> when(value) {
            (value>=0)&&(value<=1) -> str+="сейчас"
            (value >= 45)&&(value <= 75) -> str+="через минуту"
            (value>1)&&(value<45) -> str+="через несколько секунд"
            (value<-1)&&(value>-45) -> str+="несколько секунд назад"
            (value <= -45)&&(value >= -75) -> str+="минуту назад"
            (value < 0)&&(value>=-1) -> str+="только что"
        }
        TimeUnits.MINUTE -> when(value) {
            (value >= 45)&&(value <= 75) -> str+="через час"
            (value == 11)||(value == 12) ||(value ==13)||(value ==14) ->str+="через $value минут"
            (value%10 == 1) -> str+="через $value минуту"
            (value%10 == 2)||(value%10 == 3)||(value%10 == 4) ->str+="через $value минуты"
            (value%10 == 5)||(value%10 == 6)||(value%10 == 7)||(value%10 == 8)||(value%10 == 9)||(value%10 == 0) -> str+="через $value минут"
            (value <= -45)&&(value >= -75) -> str+="час назад"
        }
        TimeUnits.HOUR -> when(value) {
            1, 21 -> str+="через $value час"
            2, 3, 4, 22 -> str+="через $value часа"
            5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20 -> str+="через $value часов"
            23, 24, 25, 26 -> str+="через день"
        }
        TimeUnits.DAY -> when(value) {
             value > 360 -> str+="более чем через год"
            (value%10 == 1) -> str+="через $value день"
            (value%10 == 2)||(value%10 == 3)||(value%10 == 4) ->str+="через $value дня"
            (value == 11)||(value == 12) ||(value ==13)||(value ==14)||((value>100)&&(value%100==11)||(value%100==12)||(value%100==13)||(value%100==14)) -> str+="через $value дней"
            (value%10 == 5)||(value%10 == 6)||(value%10 == 7)||(value%10 == 8)||(value%10 == 9)||(value%10 == 0) -> str+="через $value дней"
        }
        }
    }
    */
    return ""
}

enum class TimeUnits{
    SECOND,
    MINUTE,
    HOUR,
    DAY
}