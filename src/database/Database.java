package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class Database {
    private Statement statement;
    public Database() throws Exception {
        Class.forName("com.mysql.jdbc.Driver");
        String connectionString = "jdbc:mysql://localhost:3306/t2207a";
        String user = "root";
        String pwd = "root";
        Connection conn = DriverManager.getConnection(connectionString, user, pwd);
        this.statement = conn.createStatement();
    }

    public Statement getStatement() {
        return statement;
    }
}
