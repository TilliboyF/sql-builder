package com.github.TilliboyF

class InsertBuilder(
    private val query: MutableList<String>
): InsertStep, ColumnsStep, BuildAble{
    override fun into(table: String): ColumnsStep {
        query.add(table)
        return this
    }

    override fun columns(column: String, vararg columns: String): ValueStep{
        val allColumns = mutableListOf(column) + columns
        val cols = allColumns.joinToString(", ")
        query.add("($cols)")
        return this
    }

    override fun values(row: SqlRow, vararg rows: SqlRow): BuildAble {
        query.add("VALUES")
        val allValues = mutableListOf(row) + rows
        val rowStrings = allValues.map { it.toSql() }
        query.add(rowStrings.joinToString(", "))
        return this
    }

    override fun build(): String{
        return query.joinToString(" ")
    }
}