package devintensive.skillbranch.ru.dev_intensive.utility

object Utils {
    fun parseFullName(fullName: String?): Pair<String?, String?> {
        val parts: List<String>? = fullName?.split(" ")

        val firstName = parts?.getOrNull(0)
        val lastName = parts?.getOrNull(1)
        if(fullName.isNullOrBlank()) return Pair("null", "null") else if ((firstName != null)&&(lastName.isNullOrBlank())) return Pair(firstName, "null")  else if((firstName != null) && (lastName != null)) return Pair(firstName, lastName)  else return Pair("null", "null")
    }
    fun stripHtml(first_str: String) : String
    {
        var str:String = ""
        var i:Int = 0
        while(i!= first_str.length)
        {
            if(first_str.get(i) == '<')
            {
                while(first_str.get(i)!='>') {
                    str += ""
                    i++
                }
                i++
            }
            else if(first_str.get(i) == '&')
            {
                while(first_str.get(i)!=' ') {
                    str += ""
                    i++
                }
            }
            else if(first_str.get(i) == ' ')
            {
                str+=' '
                while(first_str.get(i+1)==' ') {
                    str+=""
                    i++
                }
                i++
            }
            else {str+=first_str.get(i)
                i++}
        }
        return str
    }
    fun truncate(first_str: String, value: Int = 16) : String
    {
        var str:String = ""
        for(i in 0..(value-1))
        {
            if(((value-1) == i)&&(first_str.get(i) == ' ')) break
            str+=first_str.get(i)
        }
        str+="..."
        return str
    }
    fun transliteration(payload: String, divider: String = " "): String? {
        var i: Int? = 0
        var str: String? = ""
        for(i in 0 until payload.length) {
            when (payload.get(i)) {
                'А' -> str += 'A'
                'Б' -> str += 'B'
                'В' -> str += 'V'
                'Г' -> str += 'G'
                'Д' -> str += 'D'
                'Е' -> str += 'E'
                'Ё' -> str += 'E'
                'Ж' -> str += "Zh"
                'З' -> str += 'Z'
                'И' -> str += 'I'
                'Й' -> str += 'I'
                'К' -> str += 'K'
                'Л' -> str += 'L'
                'М' -> str += 'M'
                'Н' -> str += 'N'
                'О' -> str += 'O'
                'П' -> str += 'P'
                'Р' -> str += 'R'
                'С' -> str += 'S'
                'Т' -> str += 'T'
                'У' -> str += 'U'
                'Ф' -> str += 'F'
                'Х' -> str += 'H'
                'Ц' -> str += 'C'
                'Ч' -> str += "Ch"
                'Ш' -> str += "Sh"
                'Щ' -> str += "Sh'"
                'Э' -> str += 'E'
                'Ю' -> str += "Yu"
                'Я' -> str += "Ya"
                'a' -> str += 'a'
                'б' -> str += 'b'
                'в' -> str += 'v'
                'г' -> str += 'g'
                'д' -> str += 'd'
                'е' -> str += 'e'
                'ё' -> str += 'e'
                'ж' -> str += "zh"
                'з' -> str += 'z'
                'и' -> str += 'i'
                'й' -> str += 'i'
                'к' -> str += 'k'
                'л' -> str += 'l'
                'м' -> str += 'm'
                'н' -> str += 'n'
                'о' -> str += 'o'
                'п' -> str += 'p'
                'р' -> str += 'r'
                'с' -> str += 's'
                'т' -> str += 't'
                'у' -> str += 'u'
                'ф' -> str += 'f'
                'х' -> str += 'h'
                'ц' -> str += 'c'
                'ч' -> str += "ch"
                'ш' -> str += "sh"
                'щ' -> str += "sh'"
                'ъ' -> str += ""
                'ы' -> str += 'i'
                'ь' -> str += ""
                'э' -> str += 'e'
                'ю' -> str += "yu"
                'я' -> str += "ya"
                ' ' -> str += divider
                else -> {
                    str += payload.get(i)
                }
            }
        }
        return str
    }
    fun toInitials(firstName: String?, lastName: String?): String? {
        if(firstName.isNullOrBlank())
            return "null"

       else if ((firstName != null) && (lastName.isNullOrBlank())) {
            var first: String = firstName.get(0).toString()
            first.toUpperCase()

            return "$first"
        }

        else if ((firstName !=null) && (lastName != null)) {
            var first: String = firstName.get(0).toString()
            var second: String = lastName.get(0).toString()
            first.toUpperCase()
            second.toUpperCase()
            return "$first$second"
        }
        else return "null"
    }
}




