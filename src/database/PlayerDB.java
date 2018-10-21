/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import start.*;

/**
 *This is the Database class which has the add and read method, also it can create the table and avoid create duplicate table.
 * @author RuotongXu
 */
public class PlayerDB {
    Connection conn = null;
    String url = "jdbc:derby:PlayerDataBase;create=true";
    String username ="Admins";
    String password = "16935995";
    Statement statement;
    ResultSet rs;
    /**
     * This is the method which can create a new table to store player.
     */
    public void autoconnectPlayerDB(){
        try{
            checkTableExisting("PLAYER");
            statement.executeUpdate("CREATE TABLE PLAYER (NAME VARCHAR(20),ATTACK INT,DEFENSE INT,LEVELE INT,HEALTHMAX INT,HEALTH DOUBLE,MONEY INT,ROWE INT,COLUMNE INT,"
                    + "             M1DEFEATE BOOLEAN,M2DEFEATE BOOLEAN,M3DEFEATE BOOLEAN,EXP DOUBLE)");
        }catch (SQLException ex) {
            System.err.println("SQL Exception: " + ex.getMessage());
        }
    }
    /**
     * This method is used to add the player information into the database.
     * @param m 
     */
    public void addinfo(Map m){
        try{
            String name = m.getP().getName();
            int attack = m.getP().getAttack();
            int defense = m.getP().getdefense();
            int levele = m.getP().getLevel();
            int healthmax = m.getP().getHealthmax();
            double health = m.getP().getHealth();
            int money = m.getP().getMoney();
            int rowe = m.getP().getRow();
            int columne = m.getP().getColumn();
            boolean m1defeate = m.getP().isM1defeat();
            boolean m2defeate = m.getP().isM2defeat();
            boolean m3defeate = m.getP().isM3defeat();
            double exp = m.getP().getExp();
            conn = DriverManager.getConnection(url,username,password);
            statement = conn.createStatement();
            autoconnectPlayerDB();
            System.out.println("INSERT INTO PLAYER VALUES('"+name+"',"+attack+","+defense+","+levele+","+
                    healthmax+","+health+","+money+","+rowe+","+columne+","+m1defeate+","+m2defeate+","+m3defeate+","+exp+")");
            statement.executeUpdate("INSERT INTO PLAYER VALUES('"+name+"',"+attack+","+defense+","+levele+","+
                    healthmax+","+health+","+money+","+rowe+","+columne+","+m1defeate+","+m2defeate+","+m3defeate+","+exp+")");
            
        } catch(SQLException ex){
            System.err.println("SQL Exception: " + ex.getMessage());
        }
    }
    /**
     * This method is used to get the information in this database and give the value to player while player want to loading the progress.
     * @param m 
     */
    public void getinfo(Map m){
        try{
            
            Statement statement = conn.createStatement();
            System.out.println("SELECT NAME,ATTACK,DEFENSE,LEVELE,HEALTHMAX,HEALTH,MONEY,ROWE,"
                    + "COLUMNE,M1DEFEATE,M2DEFEATE,M3DEFEATE,EXP "
                    + "FROM PLAYER");
            rs = statement.executeQuery("SELECT NAME,ATTACK,DEFENSE,LEVELE,HEALTHMAX,HEALTH,MONEY,ROWE,"
                    + "COLUMNE,M1DEFEATE,M2DEFEATE,M3DEFEATE,EXP "
                    + "FROM PLAYER");
            
                    if (rs.next()) {
                        m.getP().setName(rs.getString(1));
                        m.getP().setAttack(rs.getInt(2));
                        m.getP().setdefense(rs.getInt(3));
                        m.getP().setLevel(rs.getInt(4));
                        m.getP().setHealthmax(rs.getInt(5));
                        m.getP().setHealth(rs.getInt(6));
                        m.getP().setMoney(rs.getInt(7));
                        m.getP().setRow(rs.getInt(8));
                        m.getP().setColumn(rs.getInt(9));
                        m.getP().setM1defeat(rs.getBoolean(10));
                        m.getP().setM2defeat(rs.getBoolean(11));
                        m.getP().setM3defeat(rs.getBoolean(12));
                        m.getP().setExp(rs.getDouble(13));
                    }
        } catch (SQLException ex) {
            System.err.println("SQL Exception: " + ex.getMessage());
        }

        
    }
    /**
     * This method is used to check are there the same table already in this database, so that to avoid create duplicate table.
     * @param newTableName 
     */
    private void checkTableExisting(String newTableName) {
        try {
            System.out.println("check existing tables.... ");
            String[] types = {"TABLE"};
            DatabaseMetaData dbmd = conn.getMetaData();
            ResultSet rsDBMeta = dbmd.getTables(null, null, null, null);//types);
            Statement dropStatement = null;

            while (rsDBMeta.next()) {
                String tableName = rsDBMeta.getString("TABLE_NAME");
                System.out.println("found: " + tableName);
                if (tableName.compareToIgnoreCase(newTableName) == 0) {
                    System.out.println(tableName + "  needs to be deleted");
                    String sqlDropTable = "DROP TABLE " + newTableName;
                    dropStatement = conn.createStatement();
                    dropStatement.executeUpdate(sqlDropTable);
                    System.out.println("table deleted");
                }
            }
            if (rsDBMeta != null) {
                rsDBMeta.close();
            }
            if (dropStatement != null) {
                dropStatement.close();
            }

        } catch (SQLException ex) {
        }

    }
    /**
     * This is the constructor of this class which connect to the database and print out the derby version.
     */
    public PlayerDB(){
        try {
            conn = DriverManager.getConnection(url,username,password);
            statement = conn.createStatement();
             DatabaseMetaData dbmd = conn.getMetaData();
            String productName = dbmd.getDatabaseProductName();
            String productVersion = dbmd.getDatabaseProductVersion();
            System.out.println("Using " + productName + " " + productVersion);
            System.out.println("DATABASE CONNECT SUCCESSFULLY..");
        } catch (SQLException ex) {
            Logger.getLogger(PlayerDB.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
