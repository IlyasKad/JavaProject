package repository;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.io.FileReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Database {
    private static Database db;
    private Connection connection;
    private String url;
    private String login;
    private String password;

    private Database() throws SQLException
    {
        JSONParser parser = new JSONParser();
        try {
            FileReader fr = new FileReader("./src/main/java/config.json");
            JSONObject config = (JSONObject) parser.parse(fr);
            JSONObject databaseConfig = (JSONObject) config.get("database");
            url = (String) databaseConfig.get("url");
            login = (String) databaseConfig.get("login");
            password = (String) databaseConfig.get("password");
            connection = DriverManager.getConnection(url, login, password);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static Database getDatabase() throws SQLException {
        if (db == null) {
            db = new Database();
        }
        return db;
    }

    public Connection getConnection() {
        return connection;
    }

    public void closeConnection() throws SQLException {
        connection.close();
    }
}
