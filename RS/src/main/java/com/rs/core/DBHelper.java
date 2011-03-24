package com.rs.core;

import java.sql.*;

public class DBHelper {
    private Connection con;
    private Statement statement;
    private ResultSet resultSet;
    private static DBHelper uniqueInstance;
    private DBHelper(){
        createConnection();
    }

    public static DBHelper getInstance(){
        if(uniqueInstance==null){
            uniqueInstance = new DBHelper();
        }
        return  uniqueInstance;
    }
    private void createConnection() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost/Recuritment", "root", "password");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public String[][] retrieveFromTable(String query) {

        try {
            statement = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            resultSet = statement.executeQuery(query);
            return createStringArray();
        } catch (SQLException e) {
            e.printStackTrace();
            return new String[0][0];
        }
    }

    private String[][] createStringArray() throws SQLException {
        int row = 0;
        String[][] result = new String[rowCount()][resultSet.getMetaData().getColumnCount()];
        do {
            for (int col = 1; col <= resultSet.getMetaData().getColumnCount(); col++) {
                result[row][col - 1] = resultSet.getString(col);
            }
            row++;
        } while (resultSet.next());
        return result;
    }

    private int rowCount() throws SQLException {
        resultSet.last();
        int count = resultSet.getRow();
        resultSet.first();
        return count;
    }

    public void insert(String query) throws SQLException {
        statement = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
        statement.execute(query);
    }
    public static void main(String[] ar){
        DBHelper db = DBHelper.getInstance();
        System.out.println(db.retrieveFromTable("select * from Job"));
    }
}
