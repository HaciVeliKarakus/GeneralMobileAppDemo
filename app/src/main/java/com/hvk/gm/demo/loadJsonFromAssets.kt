package com.hvk.gm.demo

import android.content.Context
import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.json.Json
import java.io.IOException

fun loadJsonFromAssets(context: Context, fileName: String): String? {
    return try {
        val inputStream = context.assets.open(fileName)
        val size = inputStream.available()
        val buffer = ByteArray(size)
        inputStream.read(buffer)
        inputStream.close()
        String(buffer, Charsets.UTF_8)
    } catch (ex: IOException) {
        ex.printStackTrace()
        null
    }
}

@OptIn(ExperimentalSerializationApi::class)
val format = Json { explicitNulls = false }

inline fun <reified T> parseJson(jsonString: String): T {
    return format.decodeFromString(cleanJsonString(jsonString))
}