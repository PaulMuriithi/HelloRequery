import com.zaxxer.hikari.HikariDataSource
import io.requery.sql.*
import model.Models

fun main(args: Array<String>) {
    val configuration = KotlinConfiguration(dataSource = dataSource(), model = Models.DEFAULT)
    val tables = SchemaModifier(configuration)
    tables.createTables(TableCreationMode.CREATE_NOT_EXISTS)
    val dataStore: KotlinEntityDataStore<Any> = KotlinEntityDataStore(configuration)
}

fun dataSource(): HikariDataSource {
    val dataSource = HikariDataSource()
    dataSource.jdbcUrl = "jdbc:postgresql://localhost:5432/requery_test?ssl=false"
    dataSource.username = ""
    dataSource.password = ""
    return dataSource
}