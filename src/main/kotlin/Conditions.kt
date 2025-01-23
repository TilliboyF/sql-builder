package com.github.TilliboyF

interface Condition{
    fun toSql(): String
}

private class BasicCondition(
    private val column: String,
    private val value: Any,
    private val operator: String
): Condition{
    override fun toSql(): String = "$column $operator $value"
}

fun smaller(column: String, value: Any): Condition{
    return BasicCondition(column, value, "<")
}

fun greater(column: String, value: Any): Condition{
    return BasicCondition(column, value, ">")
}

fun equal(column: String, value: Any): Condition{
    return BasicCondition(column, "'$value'", "=")
}

private class ConditionChain(
    private val conditions: List<Condition>,
    private val chain: String
): Condition{
    override fun toSql(): String {
        val conditionsString = conditions.joinToString(" $chain "){it.toSql()}
        return "($conditionsString)"
    }
}

fun or(condition1: Condition, condition2: Condition, vararg conditions: Condition): Condition{
    val cond = mutableListOf(condition1,condition2) + conditions
    return ConditionChain(cond, "OR")
}

fun and(condition1: Condition, condition2: Condition, vararg conditions: Condition): Condition{
    val cond = mutableListOf(condition1, condition2) + conditions
    return ConditionChain(cond, "AND")
}

