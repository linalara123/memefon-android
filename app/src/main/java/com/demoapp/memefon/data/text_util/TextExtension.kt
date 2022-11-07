package com.demoapp.memefon.data.text_util

import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
import org.ocpsoft.prettytime.PrettyTime

fun String.getSocialPostDate(): String {
    val parsedDate = LocalDateTime.parse(this, DateTimeFormatter.ISO_DATE_TIME)
    val p = PrettyTime()
    return p.format(parsedDate).orEmpty()
}