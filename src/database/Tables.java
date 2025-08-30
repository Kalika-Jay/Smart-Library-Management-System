package database;

import java.sql.Connection;
import java.sql.Statement;

public class Tables {
    public static void initialize() {
        try (Connection conn = db.connect();
             Statement stmt = conn.createStatement()) {

            String createBooksTable = """
                CREATE TABLE IF NOT EXISTS books (
                    id SERIAL PRIMARY KEY,
                    title VARCHAR(255) NOT NULL,
                    author VARCHAR(255),
                    is_available BOOLEAN DEFAULT TRUE
                );
            """;

            String createUsersTable = """
                CREATE TABLE IF NOT EXISTS users (
                    id VARCHAR(50) PRIMARY KEY,
                    name VARCHAR(100) NOT NULL,
                    role VARCHAR(50) NOT NULL
                );
            """;

            stmt.execute(createBooksTable);
            stmt.execute(createUsersTable);

            System.out.println("Tables created or already exist.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
