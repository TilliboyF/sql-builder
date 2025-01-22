import com.github.TilliboyF.Query
import com.github.TilliboyF.row
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class InsertBuilderTest{

    @Test
    fun testBasicInsert(){
        val expected = "INSERT INTO Customers (CustomerName, City, Country)" +
                " VALUES" +
                " ('Cardinal', 'Stavanger', 'Norway')"
        val queryString = Query.insert()
            .into("Customers")
            .columns("CustomerName", "City", "Country")
            .values(row("Cardinal", "Stavanger", "Norway"))
            .build()
        assertEquals(expected, queryString)
    }

    @Test
    fun testMultipleInsert(){
        val expected = "INSERT INTO Customers (CustomerName, ContactName, Address, City, PostalCode, Country)" +
                " VALUES" +
                " ('Cardinal', 'Tom B. Erichsen', 'Skagen 21', 'Stavanger', '4006', 'Norway')," +
                " ('Greasy Burger', 'Per Olsen', 'Gateveien 15', 'Sandnes', '4306', 'Norway')," +
                " ('Tasty Tee', 'Finn Egan', 'Streetroad 19B', 'Liverpool', 'L1 0AA', 'UK')"
        val queryString: String = Query.insert()
            .into("Customers")
            .columns("CustomerName", "ContactName", "Address", "City", "PostalCode", "Country")
            .values(
                row("Cardinal", "Tom B. Erichsen", "Skagen 21", "Stavanger", 4006, "Norway"),
                row("Greasy Burger", "Per Olsen", "Gateveien 15", "Sandnes", 4306, "Norway"),
                row("Tasty Tee", "Finn Egan", "Streetroad 19B", "Liverpool", "L1 0AA", "UK"),
            ).build()
        assertEquals(expected, queryString)
    }

    @Test
    fun testInsertAllColumnsMultiple(){
        val expected = "INSERT INTO Customers" +
                " VALUES" +
                " ('Cardinal', 'Tom B. Erichsen', 'Skagen 21', 'Stavanger', '4006', 'Norway')," +
                " ('Greasy Burger', 'Per Olsen', 'Gateveien 15', 'Sandnes', '4306', 'Norway')," +
                " ('Tasty Tee', 'Finn Egan', 'Streetroad 19B', 'Liverpool', 'L1 0AA', 'UK')"
        val queryString: String = Query.insert()
            .into("Customers")
            .values(
                row("Cardinal", "Tom B. Erichsen", "Skagen 21", "Stavanger", 4006, "Norway"),
                row("Greasy Burger", "Per Olsen", "Gateveien 15", "Sandnes", 4306, "Norway"),
                row("Tasty Tee", "Finn Egan", "Streetroad 19B", "Liverpool", "L1 0AA", "UK"),
            ).build()
        assertEquals(expected, queryString)
    }

}