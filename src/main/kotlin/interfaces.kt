package com.github.TilliboyF

interface SelectStep {
    fun columns(column: String, vararg columns: String): FromStep
    fun all(): FromStep
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

