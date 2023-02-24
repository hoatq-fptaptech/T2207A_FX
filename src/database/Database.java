package database;

import java.io.DataInputStream;
import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

// singleton design pattern
public class Database {
    private static Database instance;

    private Statement statement;

    private Database() throws Exception {
        FileInputStream fis = new FileInputStream("config.txt");
        DataInputStream dis = new DataInputStream(fis);
        Class.forName(dis.readLine());
        String connectionString = dis.readLine();
        String user = dis.readLine();
        String pwd = dis.readLine();
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
