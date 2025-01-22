import com.github.TilliboyF.Query
import com.github.TilliboyF.equal
import com.github.TilliboyF.smaller
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





}