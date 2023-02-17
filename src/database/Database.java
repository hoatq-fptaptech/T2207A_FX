package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

// singleton design pattern
public class Database {
    private static Database instance;

    private Statement statement;

    private Database() throws Exception {
        Class.forName("com.mysql.jdbc.Driver");
        String connectionString = "jdbc:mysql://localhost:3306/t2207a";
        String user = "root";
        String pwd = "root";
        Connection conn = DriverManager.getConnection(connectionString, user, pwd);
        this.statement = conn.createStatement();
    }

    public static Database getInstance() throws Exception{
        if(instance == null){
            instance = new Database();
        }
        return instance;
    }

    public Statement getStatement() {
        return statement;
    }
}
