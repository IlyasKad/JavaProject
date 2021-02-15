package models.database;

import models.pojo.Item;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class ItemRepository {

    private Connection connection;
    private Database database;

//    public ItemRepository(Connection connection) {
//        this.connection = connection;
//    }

    public ItemRepository() throws SQLException {
        database = Database.getDatabase();
        connection = database.getConnection();
    }

    public void create(String name, int subcategoryId) throws SQLException {
        String sqlCommand = "INSERT INTO items (subcategory_id, name) VALUES";
        sqlCommand += String.format(" ('%s' , '%s' )", subcategoryId, name);
        Statement statement = connection.createStatement();
        statement.executeUpdate(sqlCommand);
    }

    public void create(Item item) throws SQLException {
        String sqlCommand = "INSERT INTO items (subcategory_id, name) VALUES";
        sqlCommand += String.format(" ('%s' , '%s' )", item.getSubcategory().getId(), item.getName());
        Statement statement = connection.createStatement();
        statement.executeUpdate(sqlCommand);
    }
}
