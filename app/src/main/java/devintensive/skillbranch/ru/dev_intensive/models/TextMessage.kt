package devintensive.skillbranch.ru.dev_intensive.models

import devintensive.skillbranch.ru.dev_intensive.extensions.humanizeDiff
import java.util.*

class TextMessage(
        id:String,
        from: User?,
        chat:Chat,
        isIncoming : Boolean = false,
        date: Date = Date(),
        var text:String?
) : BaseMessage(id, from, chat, isIncoming, date) {
    override fun formatMessage(): String = "${from?.firstName}" +
        "${if(isIncoming) " получил" else " отправил"} сообщение \"$text\" ${date.humanizeDiff()}"
}