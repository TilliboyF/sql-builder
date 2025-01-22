package com.github.TilliboyF

class Query {
    companion object{
        fun select(): SelectStep{
            return SelectBuilder(mutableListOf("SELECT"))
        }

        fun insert(): InsertStep{
            return InsertBuilder(mutableListOf("INSERT INTO"))
        }


    }
}