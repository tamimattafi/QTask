package com.tamimattafi.qtask.model.repository.tasks

import java.lang.StringBuilder

class UrlBuilder(baseUrl: String = "") {

    private var url: String = baseUrl

    fun baseLink(baseUrl: String): UrlBuilder
        = this.also { it.url = baseUrl }

    fun path(path: String): UrlBuilder
        = this.also {
        url = url.build().apply {
            val newPath = path.removeSuffix("/")
            if (endsWith("/")) {
                if (newPath.startsWith("/")) append(newPath.removePrefix("/"))
                else append(newPath)
            } else {
                if (newPath.startsWith("/")) append(newPath)
                else append("/$newPath")
            }
        }.toString()
    }

    fun query(query: Map<String, String>): UrlBuilder
        = this.also {
            url = url.build().apply {
                if (!this.endsWith("?")) append("?")
                query.keys.forEachIndexed { index, key ->
                    append("$key=${query[key]}" + if (index == query.size -1) "" else "&")
                }

                removePrefix("&")
            }.toString()
        }



    private fun String.build(): StringBuilder
        = StringBuilder().append(this)

    fun build(): String = url
}