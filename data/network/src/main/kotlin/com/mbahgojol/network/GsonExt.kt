package com.mbahgojol.network

import com.google.gson.Gson
import io.ktor.client.statement.HttpResponse
import io.ktor.client.statement.bodyAsText
import org.json.JSONObject

suspend fun <T> HttpResponse.toDto(clazz: Class<T>): T = Gson().fromJson(bodyAsText(), clazz)
suspend fun HttpResponse.toJsonObject(): JSONObject = JSONObject(bodyAsText())

fun Any.toJson(): String = Gson().toJson(this)
