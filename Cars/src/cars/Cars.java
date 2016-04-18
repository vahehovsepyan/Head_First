/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cars;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Cars {

    public static void main(String[] args) {
        // TODO code application logic here
        Connection con = null;// хранит соеденение с базой 
        Statement stmt = null;//хранит и выполняет запросы
        ResultSet rs= null;//получает резултаты запросов
        try {
            Driver d = (Driver)Class.forName("org.sqlite.JDBC").newInstance();
            
            String url = "jdbc:sqlite:C:\\Users\\Vahe\\Documents\\NetBeansProjects\\Cars\\CarShop.db";      
            con=DriverManager.getConnection(url);
            
            
            //подготовка SQL запроса
            String sql = "Select * From spr_Brand";
            stmt=con.createStatement();
            
            //выполнение SQL запроса
            rs=stmt.executeQuery(sql);
            
            while(rs.next()){
                System.out.println(rs.getString("name_en"));
            }            
            
        }catch(SQLException e){
            e.printStackTrace();
        }catch (Exception e) {
        }finally{
            try{
                if(rs!=null) rs.close();
                if(stmt!=null) stmt.close();
            }catch(Exception ex){
                ex.printStackTrace();
            }
        }
    }
    
}
