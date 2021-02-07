package com.ngoopy.movieku.utils

class Duration {
    fun toPrint(minute: Int): String {
        val hours = (minute/60)
        val min = if (hours>0) minute-(hours*60) else minute

        return if (hours>0) "$hours:$min" else "$min"
    }
}