package com.github.TilliboyF



interface SqlRow{
    fun toSql(): String
}
private class Row(
    private val values: List<String>
): SqlRow {
    override fun toSql(): String{
        val valuesString = values.joinToString(", ")
        return "($valuesString)"
    }
}

fun row(value: Any, vararg values: Any): SqlRow{
    val allValues = mutableListOf(value) + values
    return Row(allValues.map{"'$it'"})
}