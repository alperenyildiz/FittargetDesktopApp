package dao;

import entity.Kullanici;
import java.sql.Connection;
import java.sql.SQLException;
import util.DBConnection;

public  class SuperDAO {
     private DBConnection db;
    private Connection connection;
   
    public DBConnection getDb() throws SQLException {
        if(this.db==null)
            this.db=DBConnection.getInstance();
        return db;
    }
    
    public void setDb(DBConnection db) {
        this.db = db;
    }

    public Connection getConnection() throws SQLException {
        if(this.connection==null  || this.connection.isClosed())
            this.connection=DBConnection.getInstance().getConnection();
        return connection;
    }

    public void setConnection(Connection con) {
        this.connection = con;
    }
    
    public void disconnect() {
        try {
            if (connection != null && !connection.isClosed()) {
                connection.close();
            }
        } catch (SQLException e) {
           System.out.println(e.getMessage());
        }
    }
    

}
