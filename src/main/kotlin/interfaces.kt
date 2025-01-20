package com.github.TilliboyF

interface SelectStep {
    fun columns(vararg columns: String): FromStep
    fun allColumns(): FromStep
}

interface FromStep {
    fun from(table: String): WhereStep
}

interface WhereStep {
    fun where(condition: String): OrderByStep
    fun noWhere(): OrderByStep
}

interface OrderByStep {
    fun orderBy(vararg columns: String): LimitStep
    fun noOrderBy(): LimitStep
}

interface LimitStep {
    fun limit(maxRows: Int): OffsetStep
    fun noLimit(): OffsetStep
}

interface OffsetStep {
    fun offset(numRows: Int): BuildStep
    fun noOffset(): BuildStep
}

interface BuildStep {
    fun build(): String
}
