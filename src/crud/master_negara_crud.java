/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package crud;
import static crud.database.connectionDB;
import static crud.master_pelabuhan_crud.connectionDB;
import java.sql.Connection;//untuk mendapatkan koneksinya
import java.sql.DriverManager;//menghubungkan database
import java.sql.PreparedStatement;//perintah sql simpan, ubah, hapus[crud]
import java.sql.ResultSet;
import java.sql.Statement;

/**
 *
 * @author Acer
 */
//public class adalah enkapsulasi
public class master_negara_crud {
    private String databaseName = "nurmala_sari_2210010392";
    private String username = "root";
    private String password = "";
    public static Connection connectionDB;
    
public master_negara_crud (){
    //try sama catch blok, untuk menangani pengecualihan, 
    //exception artinya pengecualian
    try {
        String location = "jdbc:mysql://localhost/" + databaseName;
        Class.forName("com.mysql.jdbc.Driver");
        connectionDB = DriverManager.getConnection(location,username,password);
        System.out.println("database terkoneksi");
    } catch (Exception e) {
        System.out.println(e.getMessage());
    }
}

public void simpanmaster_negara(Integer id_negara, String kode_negara, String nama_negara){
    try {
        String sql = "insert into master_negara (id_negara, kode_negara, nama_negara) value(?,?,?)";
        PreparedStatement perintah = connectionDB.prepareStatement(sql);
        perintah.setInt(1, id_negara);
        perintah.setString(2, kode_negara);
        perintah.setString(3, nama_negara);
        perintah.executeUpdate();
        System.out.println("Data berhasil disimpan");
    } catch (Exception e) {
        System.out.println(e.getMessage());   
    }
}

public void ubahmaster_negara(Integer id_negara, String kode_negara, String nama_negara){
    try {
        String sql = "update master_negara set kode_negara = ?, nama_negara = ? where id_negara =?";
        PreparedStatement perintah = connectionDB.prepareStatement(sql);
        perintah.setString(1, kode_negara);
        perintah.setString(2, nama_negara);
        perintah.setInt(3, id_negara);
        perintah.executeUpdate();
        System.out.println("Data berhasil diubah");
        
    } catch (Exception e) {
        System.out.println(e.getMessage());
    }
}

public void hapusmaster_negara(Integer id_negara){
    try {
        String sql = "delete from master_negara where id_negara = ?";
        PreparedStatement perintah = connectionDB.prepareStatement(sql);
        perintah.setInt(1, id_negara);
          
        perintah.executeUpdate();
        System.out.println("deleted");
    } catch (Exception e) {
        System.out.println(e.getMessage());
}
}


  public void carimaster_negara(String paramnik){
      try {
          String sql ="SELECT*FROM master_negara where id_negara=?";
          PreparedStatement perintah = connectionDB.prepareStatement(sql);
          perintah.setString(1,paramnik);
          ResultSet data = perintah.executeQuery();
          while(data.next()){
             System.out.println("id_negara :"+data.getString("id_negara"));
             System.out.println("kode_negara :"+data.getString("kode_negara"));
             System.out.println("nama_negara :"+data.getString("nama_negara"));
          }
      } catch (Exception e) {
          System.err.println(e.getMessage());
      }
  }
  
  
  public void datamaster_negara(){
      try {
          Statement stmt  = connectionDB.createStatement();
          ResultSet baris = stmt.executeQuery("SELECT*FROM master_negara ORDER BY id_negara ASC");
          while(baris.next()){
              System.out.println(baris.getString("id_negara")+" | "+
                      baris.getString("kode_negara")+" | "+
                      baris.getString("nama_negara"));
          }
      } catch (Exception e) {
          System.err.println(e.getMessage());
          
      }
  }
 
 
    
}
