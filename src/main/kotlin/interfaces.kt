package com.github.TilliboyF

interface SelectStep {
    fun columns(column: String, vararg columns: String): FromStep
    fun all(): FromStep
}

interface InsertStep{
    fun into(table: String): ColumnsStep
}

interface ColumnsStep: ValueStep{
    fun columns(column: String, vararg columns: String): ValueStep
}

interface ValueStep{
    fun values(row: SqlRow, vararg rows: SqlRow): BuildAble
}

interface FromStep: BuildAble {
    fun from(table: String): WhereStep
}

interface WhereStep : BuildAble {
    fun where(condition: Condition ,vararg conditions: Condition): BuildAble
}

interface BuildAble {
    fun build(): String
}

