/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package crud;
import static crud.database.connectionDB;
import static crud.master_perusahaan_crud.connectionDB;
//import static crud.master_negara_crud.connectionDB;
//import static crud.master_pelabuhan_crud.connectionDB;
//import static crud.master_perusahaan_crud.connectionDB;
import java.sql.Connection;//untuk mendapatkan koneksinya
import java.sql.DriverManager;//menghubungkan database
import java.sql.PreparedStatement;//perintah sql simpan, ubah, hapus[crud]
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.Timestamp;



/**
 *
 * @author Acer
 */
public class transaksi_registerb3_crud {
    private String databaseName = "nurmala_sari_2210010392";
    private String username = "root";
    private String password = "";
    public static Connection connectionDB;
    
    
public transaksi_registerb3_crud(){
    try {
        String location = "jdbc:mysql://localhost/" + databaseName;
        Class.forName("com.mysql.jdbc.Driver");
        connectionDB = DriverManager.getConnection(location,username,password);
        System.out.println("database terkoneksi");
    } catch (Exception e) {
        System.out.println(e.getMessage());
    }
}

public void simpantransaksi_registerb3(String id_register, String id_perusahaan, String no_surat_regis, Date tanggal_berlaku, Date ltr_dtstart, Date ltr_dtend, String ltr_duration, String created_at){
    try {
        String sql = "insert into transaksi_registerb3 (id_register, id_perusahaan, no_surat_regis, tanggal_berlaku, ltr_dtstart, ltr_dtend, ltr_duration, created_at) value (?,?,?,?,?,?,?,?)";
        PreparedStatement perintah = connectionDB.prepareStatement(sql);
        perintah.setString(1, id_register);
        perintah.setString(2, id_perusahaan);
        perintah.setString(3, no_surat_regis);
        perintah.setDate(4, tanggal_berlaku);
        perintah.setDate(5, ltr_dtstart);
        perintah.setDate(6, ltr_dtend);
        perintah.setString(7, ltr_duration);
        perintah.setString(8, created_at);
        perintah.executeUpdate();
        System.out.println("Data berhasil disimpan");
    } catch (Exception e) {
        System.out.println(e.getMessage());
    }
}

public void ubahtransaksi_registerb3(String id_register, String id_perusahaan, String no_surat_regis, Date tanggal_berlaku, Date ltr_dtstart, Date ltr_dtend, String ltr_duration, String created_at){
    try {
        String sql = "update transaksi_registerb3 set id_perusahaan = ? , no_surat_regis = ? , tanggal_berlaku = ? , ltr_dtstart = ? , ltr_dtend = ? , ltr_duration = ? , created_at = ? where id_register = ? ";
        PreparedStatement perintah = connectionDB.prepareStatement(sql);
        perintah.setString(1, id_perusahaan);
        perintah.setString(2, no_surat_regis);
        perintah.setDate(3, tanggal_berlaku);
        perintah.setDate(4, ltr_dtstart);
        perintah.setDate(5, ltr_dtend);
        perintah.setString(6, ltr_duration);
        perintah.setString(7, created_at);
        perintah.setString(8, id_register);
        perintah.executeUpdate();
        System.out.println("Data berhasil diubah");
    } catch (Exception e) {
        System.out.println(e.getMessage());
    }
}

public void hapustransaksi_registerb3(String id_register){
    try {
        String sql = "delete from transaksi_registerb3 where id_register = ?";
        PreparedStatement perintah = connectionDB.prepareStatement(sql);
        perintah.setString(1, id_register);
          
        perintah.executeUpdate();
        System.out.println("deleted");
    } catch (Exception e) {
        System.out.println(e.getMessage());
    }
  }

public void caritransaksi_registerb3(String paramnik){
      try {
          String sql ="SELECT*FROM transaksi_registerb3 where id_register=?";
          PreparedStatement perintah = connectionDB.prepareStatement(sql);
          perintah.setString(1,paramnik);
          ResultSet data = perintah.executeQuery();
          while(data.next()){
             System.out.println("id_register :"+data.getString("id_register"));
             System.out.println("id_perusahaan :"+data.getString("id_perusahaan"));
             System.out.println("no_surat_regis :"+data.getString("no_surat_regis"));
             System.out.println("tanggal_berlaku :"+data.getString("tanggal_berlaku"));
             System.out.println("ltr_dtstart :"+data.getString("ltr_dtstart"));
             System.out.println("ltr_dtend :"+data.getString("ltr_dtend"));
             System.out.println("ltr_duration :"+data.getString("ltr_duration"));
             System.out.println("created_at :"+data.getString("created_at"));
          }
      } catch (Exception e) {
          System.err.println(e.getMessage());
      }
  }

  public void datatransaksi_registerb3(){
      try {
          Statement stmt  = connectionDB.createStatement();
          ResultSet baris = stmt.executeQuery("SELECT*FROM transaksi_registerb3 ORDER BY id_register ASC");
          while(baris.next()){
              System.out.println(baris.getString("id_register")+" | "+
                      baris.getString("id_perusahaan")+" | "+
                      baris.getString("no_surat_regis")+" | "+
                      baris.getString("tanggal_berlaku")+" | "+
                      baris.getString("ltr_dtstart")+" | "+
                      baris.getString("ltr_dtend")+" | "+
                      baris.getString("ltr_duration")+" | "+
                      baris.getString("created_at"));
          }
      } catch (Exception e) {
          System.err.println(e.getMessage());
          
      }
  }
 
}
