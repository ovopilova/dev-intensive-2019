package devintensive.skillbranch.ru.dev_intensive

import devintensive.skillbranch.ru.dev_intensive.extensions.TimeUnits
import devintensive.skillbranch.ru.dev_intensive.extensions.add
import devintensive.skillbranch.ru.dev_intensive.extensions.format
import devintensive.skillbranch.ru.dev_intensive.extensions.toUserView
import devintensive.skillbranch.ru.dev_intensive.models.*
import devintensive.skillbranch.ru.dev_intensive.utility.Utils
import devintensive.skillbranch.ru.dev_intensive.utility.Utils.toInitials
import org.junit.Test

import org.junit.Assert.*
import java.util.*

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class ExampleUnitTest {
    @Test
    fun addition_isCorrect() {
        assertEquals(4, 2 + 2)
    }
    @Test
    fun test_instance() {
        println(Utils.transliteration("Amazing Петр", "_"))
    }
    @Test
    fun test_truncate() {
        println(Utils.stripHtml("<p class=\"title\">Образовательное IT-сообщество Skill Branch</p>"))

    }


    @Test
    fun test_instance2() {
    val user = User.makeUser("")
    println("Hi! My name is ${user.firstName} ${user.lastName}")
}
    @Test
    fun test_facroty() {
        //val user = User.makeUser("John Cena")
        //val user2 = User.makeUser("John Wick")
        val user = User.makeUser("John Wick")
        val user2 = user.copy(id ="2", lastName = "Cena", lastVisit = Date())
        print("$user \n$user2")

    }
    @Test
    fun test_decomposition() {
        val user = User.makeUser("John Wick")
        fun getUserInfo() = user
        val (id, firstName, lastName) = getUserInfo()

        println("$id, $firstName, $lastName")
        println("${user.component1()}, ${user.component2()},${user.component3()},")
    }
    @Test
    fun test_copy() {
        val user = User.makeUser("John Wick")
        var user2 = user.copy(lastVisit = Date())
        var user3 = user.copy(lastVisit = Date().add(-2, TimeUnits.SECOND))
        var user4 = user.copy(lastName = "Cena", lastVisit = Date().add(2, TimeUnits.HOUR))
        println("""
            ${user.lastVisit?.format()}
            ${user2.lastVisit?.format()}
            ${user3.lastVisit?.format()}
            ${user4.lastVisit?.format()}
        """.trimIndent())
        //val user2 = user.copy(id = "2", lastVisit = Date())


       // if(user == user2) {
       //     println("equals data and hash \n${user.hashCode()} $user \n ${user2.hashCode()} $user2")
       // }else{
       //     println ("not equals data and hash \n${user.hashCode()} $user \n ${user2.hashCode()} $user2")

       // }
       // if(user === user2) {
       // println("equals address ${System.identityHashCode(user)}, ${System.identityHashCode(user2)}")
       // }else{
       //     println("not equals address ${System.identityHashCode(user)}, ${System.identityHashCode(user2)}")

       // }

    }
    @Test
    fun test_dataq_maping() {
        val user = User.makeUser("Макеев Михаил")
        val newUser = user.copy(lastVisit = Date().add(-7, TimeUnits.SECOND))
        println(newUser)

        val userView = newUser.toUserView()
        userView.printMe()

    }
    @Test
    fun test_abstract_factory() {
        val user = User.makeUser("Макеев Михаил")
        val txtMessage = BaseMessage.makeMessage(user, Chat("0"), payload = "any text message", type = "text")
        val imgMessage = BaseMessage.makeMessage(user, Chat("0"), payload = "any image url", type = "image")

        println(txtMessage.formatMessage())
        println(imgMessage.formatMessage())


    }
}
