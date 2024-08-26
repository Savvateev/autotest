package ru.netolohy

fun commission(ammount : Int, cntDay : Int = 0, cntMonth : Int = 0, cardType : String) : Int {
    val ERROR_LIMIT = -100
    val ERROR_CARD_TYPE = -200
    val dayLimit = 150000
    val monthLimit = 600000
    val vkDayLimit = 15000
    val vkMonthLimit = 40000

    return when (cardType) {
        "VK Pay" -> {
            when {
                (cntDay > vkDayLimit || cntMonth > vkMonthLimit) -> ERROR_LIMIT
                else -> 0
            }
        }
        "МИР", "Visa" -> {
            when {
                (cntDay > dayLimit || cntMonth > monthLimit) -> ERROR_LIMIT
                else -> {
                    when {
                        (ammount * 0.0075 > 35) -> (ammount * 0.0075).toInt()
                        else -> 35
                    }
                }
            }
        }
        "Mastercard", "Maestro" -> {
            when {
                (cntDay > dayLimit || cntMonth > monthLimit) -> ERROR_LIMIT
                else -> {
                    when {
                        (cntMonth < 75000) -> 0
                        else -> (((cntMonth - 75000) * 0.006) + 20).toInt()
                    }
                }
            }
        }
        else -> ERROR_CARD_TYPE
    }
}
fun main() {
    var cntDay : Int = 0
    var cntMonth : Int = 0

    println("transfer by VK Pay 10000 ${commission(10000,cntDay,cntMonth,"VK Pay")}")

}
