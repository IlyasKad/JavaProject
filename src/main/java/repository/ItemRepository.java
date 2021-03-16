package repository;

import models.Category;
import models.Item;
import models.ItemType;


import java.sql.*;

public class ItemRepository {

    private Connection connection;
    private Database database;

    public ItemRepository() throws SQLException {
        database = Database.getDatabase();
        connection = database.getConnection();
    }

    public void create(Item item) {
        try{
            String sqlCommand = "INSERT INTO items (Description, ItemTypeId, Weight, Calories) VALUES";
            sqlCommand += String.format(" ('%s' , '%s' , '%s', '%s')",
                    item.description, item.itemType.id, item.weight,item.calories);
            Statement statement = connection.createStatement();
            statement.executeUpdate(sqlCommand);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Item findById(int id) {
        Item item = null;
        PreparedStatement stmt = null;
        try {
            stmt = connection.prepareStatement(
                    "SELECT items.Id as itemsId, items.Description, items.Weight, items.Calories, " +
                    "itemtypes.Id as itemtypesId, itemtypes.Name as itemtypesName, " +
                    "categories.Id as categoriesId, categories.Name as categoriesName " +
                    "FROM items, itemtypes, categories " +
                    "WHERE ItemTypeId = itemtypes.Id AND itemtypes.CategoryId = categories.id AND items.id = ?");
            stmt.setInt(1, id);
            ResultSet resultSet = stmt.executeQuery();
            if (resultSet.next()) {
                Category category = new Category();
                category.id = resultSet.getInt("categoriesId");
                category.name = resultSet.getString("categoriesName");

                ItemType itemType = new ItemType();
                itemType.id = resultSet.getInt("itemtypesId");
                itemType.category = category;
                itemType.name = resultSet.getString("itemtypesName");

                item = new Item();
                item.id = resultSet.getInt("itemsId");
                item.description = resultSet.getString("Description");
                item.itemType = itemType;
                item.weight = resultSet.getDouble("Weight");
                item.calories = resultSet.getDouble("Calories");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (stmt != null) {
                    stmt.close();
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        return item;
    }
}
