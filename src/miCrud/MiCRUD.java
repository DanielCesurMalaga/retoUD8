package miCrud;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class MiCRUD {
    // atributtes
    private String driver = "com.mysql.cj.jdbc.Driver";
    private String url = "jdbc:mysql://localhost:3306/";
    private String user = "root";
    private String password = "";
    private Connection connection;
    private Statement statement;

    // constructor

    public MiCRUD(String cinema) {
        this.url = this.url.concat(cinema);
    }

    public boolean initConnection() {
        this.connection = null;
        try {
            this.connection = DriverManager.getConnection(url, user, password);
            return true;
        } catch (SQLException e) {
            return false;
        }
    }

    public boolean closeConnection() {
        try {
            this.connection.close();
            return true;
        } catch (SQLException e) {
            return false;
        } catch (NullPointerException e) {
            return false;
        }
    }

    public boolean createStatement() {
        try {
            this.statement = connection.createStatement();
            return true;
        } catch (SQLException e) {
            return false;
        }
    }

    public boolean insertRow(String table, String[] columns, Object[] values) {

        String query = "INSERT INTO " + table + " (";

        for (int i = 0; i < columns.length - 1; i++) {
            query = query + columns[i] + ", ";
        }
        query = query + columns[columns.length - 1] + ") VALUES (";

        for (int i = 0; i < values.length - 1; i++) {
            if (values[i].getClass() == Integer.class) {
                query = query + values[i] + ", ";
            } else {
                query = query + "'" + values[i] + "'" + ", ";
            }

        }
        if (values[values.length - 1].getClass() == Integer.class) {
            query = query + values[values.length - 1] + ");";
        } else {
            query = query + "'" + values[values.length - 1] + "'" + ");";
        }
        try {
            this.statement.executeUpdate(query);
            return true;
        } catch (SQLException e) {
            return false;
        }
    }

}
