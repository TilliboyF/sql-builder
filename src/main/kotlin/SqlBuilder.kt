
package com.github.TilliboyF
class SqlBuilder :SelectStep, FromStep, WhereStep, OrderByStep,LimitStep, OffsetStep, BuildStep{

    private val query = mutableListOf<String>()
    override fun columns(vararg columns: String): FromStep {
        TODO("Not yet implemented")
    }

    override fun allColumns(): FromStep {
        TODO("Not yet implemented")
    }

    override fun from(table: String): WhereStep {
        TODO("Not yet implemented")
    }

    override fun where(condition: String): OrderByStep {
        TODO("Not yet implemented")
    }

    override fun noWhere(): OrderByStep {
        TODO("Not yet implemented")
    }

    override fun orderBy(vararg columns: String): LimitStep {
        TODO("Not yet implemented")
    }

    override fun noOrderBy(): LimitStep {
        TODO("Not yet implemented")
    }

    override fun limit(maxRows: Int): OffsetStep {
        TODO("Not yet implemented")
    }

    override fun noLimit(): OffsetStep {
        TODO("Not yet implemented")
    }

    override fun offset(numRows: Int): BuildStep {
        TODO("Not yet implemented")
    }

    override fun noOffset(): BuildStep {
        TODO("Not yet implemented")
    }

    override fun build(): String {
        TODO("Not yet implemented")
    }


}