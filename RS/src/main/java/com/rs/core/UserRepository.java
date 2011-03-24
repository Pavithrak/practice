package com.rs.core;

import java.sql.SQLException;

public class UserRepository {
    String query;
    DBHelper dbHelper;

    public UserRepository() {
        this.query = "";
        this.dbHelper = DBHelper.getInstance();
    }

    public User authenticate(String user, String pswd) {
        query = "select * from users where email='" + user + "' and password='" + pswd + "'";
        return buildUser(dbHelper.retrieveFromTable(query));
    }

    private User buildUser(String[][] records) {
        return new User(records[0][0],records[0][1],records[0][2],records[0][3],records[0][4],records[0][5],records[0][6],Integer.parseInt(records[0][7]));
    }


    public void save_map(int jobID, int userID) throws SQLException {
        String query = "insert into user_job values("+userID+","+jobID+")";
        dbHelper.insert(query);
    }

    public int[] getAppliedJob(int userID) {
        String query = "select job_id from user_job where user_id="+userID;
        return toIntArray(dbHelper.retrieveFromTable(query));
    }

    private int[] toIntArray(String[][] strings) {
        int[] result = new  int[strings.length];
        int i =0;
        for(String[] st : strings ){
            result[i++] = Integer.parseInt(st[0]);
        }
        return result;
    }


    public User save(String name, String email, String mobile, String gender, String experience, String industry, String password) throws SQLException {
        query="insert into users (name,email,mobile,gender,experience,pref_ind,password)" +
                " values('"+name+"','"+email+"','"+mobile+"','"+gender+"','"+experience+"','"+industry+"','"+password+"')";
        dbHelper.insert(query);
        return authenticate(email,password);
    }
}
