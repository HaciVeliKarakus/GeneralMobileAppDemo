package com.hvk.gm.demo

fun cleanJsonString(jsonString: String): String {
    // Gereksiz boşlukları temizlemek için regex kullan
    val regex = "\\s{2,}".toRegex()  // Birden fazla boşluğu tek boşlukla değiştir
    val cleanedString = jsonString.replace(regex, " ")
    return cleanedString
}


