fun main() {
    println("Введите имя:")
    val rawName = readln()

    println("Введите возраст (можно оставить пустым):")
    val rawAge = readln()

    println("Введите город:")
    val rawCity = readln()

    val name = rawName.trim()
        .takeIf { it.isNotEmpty() }
        ?.replaceFirstChar { it.uppercase() }
        ?: "не указано"

    val age: Int? = rawAge.trim()
        .takeIf { it.isNotEmpty() }
        ?.toIntOrNull()

    val city = rawCity.trim()
        .takeIf { it.isNotEmpty() }
        ?: "не указан"

    val status = when {
        age == null -> "недостаточно данных"
        age < 18 -> "несовершеннолетний"
        age in 18..60 -> "взрослый пользователь"
        else -> "пожилой пользователь"
    }

    val ageText = age?.toString() ?: "не указан"

    val report = """
        Профиль пользователя:
        Имя: $name
        Возраст: $ageText
        Город: $city

        Статус: $status
    """.trimIndent()

    println(report)
}