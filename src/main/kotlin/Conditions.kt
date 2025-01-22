package com.github.TilliboyF

interface Condition{
    fun toSql(): String
}

private class SmallerCondition(
    private val column: String,
    private val value: Any,
): Condition{
    override fun toSql(): String = "$column < $value"
}

fun smaller(column: String, value: Any): Condition{
    return SmallerCondition(column, value)
}

private class GreaterCondition(
    private val column: String,
    private val value: Any,
): Condition{
    override fun toSql(): String = "$column > $value"
}

fun greater(column: String, value: Any): Condition{
    return GreaterCondition(column, value)
}

private class EqualCondition(
    private val column: String,
    private val value: Any,
): Condition{
    override fun toSql(): String = "$column = '$value'"
}

fun equal(column: String, value: Any): Condition{
    return EqualCondition(column, value)
}

