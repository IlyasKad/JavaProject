package repository;

import models.*;
import org.springframework.stereotype.Repository;

import java.sql.*;

@Repository
public class BackpackRepository {

    private final Connection connection;
    private Database database;

    public BackpackRepository() throws SQLException {
        database = Database.getDatabase();
        connection = database.getConnection();
    }

    // return BackpackId
    public int create(Backpack backpack) {
        PreparedStatement stmt = null;
        try {
            stmt = connection.prepareStatement("INSERT INTO backpacks (Weight) VALUES (?)", Statement.RETURN_GENERATED_KEYS);
            stmt.setInt(1, backpack.weight);
            stmt.executeUpdate();
            ResultSet generatedKeys = stmt.getGeneratedKeys();
            if (generatedKeys.next()) {
                return generatedKeys.getInt(1);
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
        return -1;
    }
}
