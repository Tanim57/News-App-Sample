package com.tanim.newsapp.utils

import com.google.gson.JsonDeserializer
import com.google.gson.JsonElement
import com.google.gson.JsonDeserializationContext
import java.lang.Exception
import java.lang.reflect.Type
import java.time.DayOfWeek
import java.time.LocalTime
import java.time.format.DateTimeFormatter

object JsonDeserializerUtils {

    var deserializerLocalDateTime =
        JsonDeserializer<LocalTime> label@{ json: JsonElement?, typeOfT: Type?, context: JsonDeserializationContext? ->
            try {
                if (json == null) {
                    return@label null
                } else {
                    val dateString = json.asString
                    return@label LocalTime.parse(dateString, DateTimeFormatter.ISO_DATE_TIME)
                }
            } catch (e: Exception) {
                return@label null
            }
        }

    var deserializerLocalTime =
        JsonDeserializer<LocalTime> label@{ json: JsonElement?, typeOfT: Type?, context: JsonDeserializationContext? ->
            try {
                if (json == null) {
                    return@label null
                } else {
                    val dateString = json.asString
                    return@label LocalTime.parse(dateString)
                }
            } catch (e: Exception) {
                return@label null
            }
        }

    var deserializerDayOfWeek =
        JsonDeserializer<DayOfWeek> label@{ json: JsonElement?, typeOfT: Type?, context: JsonDeserializationContext? ->
            try {
                if (json == null) {
                    return@label null
                } else {
                    val dateString = json.asString
                    return@label DayOfWeek.valueOf(dateString)
                }
            } catch (e: Exception) {
                return@label null
            }
        }

}