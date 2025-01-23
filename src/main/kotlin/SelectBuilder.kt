package com.github.TilliboyF

class SelectBuilder(
    private val query: MutableList<String>
) : SelectStep, FromStep, WhereStep {

    override fun columns(column: String, vararg columns: String): FromStep{
        val allColumns = listOf(column) + columns
        allColumns.forEach {
            query.add(it)
        }
        return this
    }

    override fun all(): FromStep{
        query.add("*")
        return this
    }

    override fun from(table: String): WhereStep {
        query.add("FROM")
        query.add(table)
        return this
    }

    override fun where(condition: Condition, vararg conditions: Condition): BuildAble {
        val allConditions = listOf(condition) + conditions
        val conditionsString = allConditions.joinToString(" AND "){ it.toSql()}
        query.add("WHERE $conditionsString")
        return this
    }

    override fun whereOr(condition1: Condition, condition2: Condition, vararg conditions: Condition): BuildAble {
        val all = listOf(condition1, condition2) + conditions
        val conditionsString = all.joinToString(" OR "){it.toSql()}
        query.add("WHERE $conditionsString")
        return this
    }

    override fun whereAnd(condition1: Condition, condition2: Condition, vararg conditions: Condition): BuildAble {
        val all = listOf(condition1,condition2) + conditions
        val conditionString = all.joinToString(" AND ") { it.toSql() }
        query.add("WHERE $conditionString")
        return this
    }

    override fun build(): String{
        return query.joinToString(" ")
    }
}