import com.github.TilliboyF.*
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class SelectBuilderTest{

    @Test
    fun testBasicSelect(){
        val query = "SELECT * FROM users"
        val createdQuery = Query
            .select()
            .all()
            .from("users")
            .build()
        assertEquals(query, createdQuery)
    }

    @Test
    fun testWhereSelect(){
        val query = "SELECT * FROM users WHERE age < 25 AND status = 'active'"
        val createdQuery = Query
            .select()
            .all()
            .from("users")
            .where(
                smaller("age", 25),
                equal("status", "active"))
            .build()
        assertEquals(query, createdQuery)
    }

    @Test
    fun testWhereAnd(){
        val query = "SELECT * FROM users WHERE age < 25 AND status = 'active'"
        val createdQuery = Query
            .select()
            .all()
            .from("users")
            .whereAnd(
                smaller("age", 25),
                equal("status", "active")
            )
            .build()
        assertEquals(query, createdQuery)
    }

    @Test
    fun testWhereOr(){
        val query = "SELECT * FROM users WHERE age < 25 OR status = 'active'"
        val createdQuery = Query
            .select()
            .all()
            .from("users")
            .whereOr(
                smaller("age", 25),
                equal("status", "active")
            )
            .build()
        assertEquals(query, createdQuery)
    }

    @Test
    fun testWhereOrAnd(){
        val query = "SELECT * FROM users WHERE (age < 25 AND status = 'active') OR city = 'New York'"
        val createdQuery = Query
            .select()
            .all()
            .from("users")
            .whereOr(
                and(
                    smaller("age", 25),
                equal("status", "active")
                ), equal("city", "New York")
            ).build()
        assertEquals(query, createdQuery)
    }

    @Test
    fun testWhereAndOr(){
        val query = "SELECT * FROM users WHERE (age < 25 OR age > 30) AND (status = 'active' OR status = 'pending')"
        val createdQuery = Query
            .select()
            .all()
            .from("users")
            .whereAnd(
                or(
                smaller("age", 25),
                greater("age", 30)
                ),
                or(
                    equal("status", "active"),
                    equal("status", "pending")
                )
            ).build()
        assertEquals(query, createdQuery)
    }

    @Test
    fun testWhereComplex(){
        val query = "SELECT * FROM users WHERE ((age < 25 AND status = 'active') OR (age > 30 AND status = 'inactive')) AND city = 'New York'"
        val createdQuery = Query
            .select()
            .all()
            .from("users")
            .whereAnd(
                or(
                    and(
                       smaller("age", 25),
                        equal("status", "active")
                    ),
                    and(
                        greater("age", 30),
                        equal("status", "inactive")
                    )
                ),
                equal("city", "New York")
            )
            .build()
        assertEquals(query, createdQuery)
    }

}