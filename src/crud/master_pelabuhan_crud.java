/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package crud;
import static crud.database.connectionDB;
import static crud.master_negara_crud.connectionDB;
import java.sql.Connection;//untuk mendapatkan koneksinya
import java.sql.DriverManager;//menghubungkan database
import java.sql.PreparedStatement;//perintah sql simpan, ubah, hapus[crud]
import java.sql.ResultSet;
import java.sql.Statement;

/**
 *
 * @author Acer
 */
public class master_pelabuhan_crud {
  private String databaseName = "nurmala_sari_2210010392";  
  private String username = "root";
  private String password = "";
  public static Connection connectionDB;


public master_pelabuhan_crud(){
    try {
        String location = "jdbc:mysql://localhost/" + databaseName;
        Class.forName("com.mysql.jdbc.Driver");
        connectionDB = DriverManager.getConnection(location, username,password);
        System.out.println("database terkoneksi");
    } catch (Exception e) {
          System.out.println(e.getMessage());
   }
}

public void simpanmaster_pelabuhan(String id_pelabuhan, String kode_pelabuhan, String nama_pelabuhan){
    try {
        String sql = "insert into master_pelabuhan (id_pelabuhan, kode_pelabuhan, nama_pelabuhan) value (?,?,?)";
        PreparedStatement perintah = connectionDB.prepareStatement(sql);
        perintah.setString(1, id_pelabuhan);
        perintah.setString(2, kode_pelabuhan);
        perintah.setString(3, nama_pelabuhan);
        perintah.executeUpdate();
        System.out.println("data berhasil dirsimpan");    
    } catch (Exception e) {
        System.out.println(e.getMessage());
   }
}

public void ubahmaster_pelabuhan(String id_pelabuhan, String kode_pelabuhan, String nama_pelabuhan){
    try {
        String sql = "update master_pelabuhan set kode_pelabuhan = ?, nama_pelabuhan = ? where id_pelabuhan =?";
        PreparedStatement perintah = connectionDB.prepareStatement(sql);
        perintah.setString(1, kode_pelabuhan);
        perintah.setString(2, nama_pelabuhan);
        perintah.setString(3, id_pelabuhan);
        perintah.executeUpdate();
        System.out.println("data berhasil diubah");
        
    } catch (Exception e) {
        System.out.println(e.getMessage());
   }
}

public void hapusmaster_pelabuhan(String id_pelabuhan){
    try {
        String sql = "delete from master_pelabuhan where id_pelabuhan = ?";
        PreparedStatement perintah = connectionDB.prepareStatement(sql);
          perintah.setString(1, id_pelabuhan);
          
          perintah.executeUpdate();
          System.out.println("deleted");
    } catch (Exception e) {
        System.out.println(e.getMessage());
    }
}


public void carimaster_pelabuhan(String paramnik){
      try {
          String sql ="SELECT*FROM master_pelabuhan where id_pelabuhan=?";
          PreparedStatement perintah = connectionDB.prepareStatement(sql);
          perintah.setString(1,paramnik);
          ResultSet data = perintah.executeQuery();
          while(data.next()){
             System.out.println("id_pelabuhan :"+data.getString("id_pelabuhan"));
             System.out.println("kode_pelabuhan :"+data.getString("kode_pelabuhan"));
             System.out.println("nama_pelabuhan :"+data.getString("nama_pelabuhan"));
          }
      } catch (Exception e) {
          System.err.println(e.getMessage());
      }
  }


  public void datamaster_pelabuhan(){
      try {
          Statement stmt  = connectionDB.createStatement();
          ResultSet baris = stmt.executeQuery("SELECT*FROM master_pelabuhan ORDER BY id_pelabuhan ASC");
          while(baris.next()){
              System.out.println(baris.getString("id_pelabuhan")+" | "+
                      baris.getString("kode_pelabuhan")+" | "+
                      baris.getString("nama_pelabuhan"));
          }
      } catch (Exception e) {
          System.err.println(e.getMessage());
          
      }
  }
 
}
