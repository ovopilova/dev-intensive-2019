package devintensive.skillbranch.ru.dev_intensive.extensions

import devintensive.skillbranch.ru.dev_intensive.models.User
import devintensive.skillbranch.ru.dev_intensive.models.UserView
import devintensive.skillbranch.ru.dev_intensive.utility.Utils
import java.util.*

fun User.toUserView() : UserView {
    val nickName = Utils.transliteration("$firstName $lastName")
    val initials = Utils.toInitials(firstName, lastName)
    //val status = if(lastVisit == null) "Еще ни разу не был" else if (isOnline) "online" else "Последний раз был ${lastVisit.humanizeDiff()}"
    return UserView(
            id,
            fullName = "$firstName $lastName",
            nickName = nickName,
            initials = initials ,
            avatar = avatar)
    //        status = status)


}

