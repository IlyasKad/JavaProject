package repository;

import models.*;
import org.springframework.stereotype.Repository;

import java.sql.*;

@Repository
public class OrderRepository {
    private final Connection connection;
    private final Database database;

    public OrderRepository() throws SQLException {
        database = Database.getDatabase();
        connection = database.getConnection();
    }

    // return OrderId
    public int create(Order order) {
        PreparedStatement stmt = null;
        try {
            stmt = connection.prepareStatement("INSERT INTO orders (Delivery, Payment, IsPaid, UserId) " +
                    "VALUES (?, ?, ?, ?)", Statement.RETURN_GENERATED_KEYS);
            stmt.setString(1, order.delivery);
            stmt.setString(2, order.payment);
            stmt.setBoolean(3, false);
            stmt.setInt(4, order.user.id);
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
