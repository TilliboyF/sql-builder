package com.github.TilliboyF

class Query {
    companion object{
        fun Select(): SelectStep{
            return SqlBuilder(mutableListOf("SELECT"))
        }
    }
}