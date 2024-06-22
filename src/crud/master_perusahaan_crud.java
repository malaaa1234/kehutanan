/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package crud;
import static crud.database.connectionDB;
import static crud.master_negara_crud.connectionDB;
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
//public class enkapsulasi
public class master_perusahaan_crud {
    private String databaseName = "nurmala_sari_2210010392";
    private String username = "root";
    private String password = "";
    public static Connection connectionDB;
    
    
public master_perusahaan_crud(){
    try {
        String location = "jdbc:mysql://localhost/" + databaseName;
        Class.forName("com.mysql.jdbc.Driver");
        connectionDB = DriverManager.getConnection(location,username, password);
        System.out.println("database terkoneksi");
    } catch (Exception e) {
        System.out.println(e.getMessage());
    }
}

public void simpanmaster_perusahaan(String id_perusahaan, String nama_perusahaan, String alamat_perusahaan, String provinsi, String telepon, String npwp, String api, String nama_pic, String tlp_pic, String bidang_usaha, String jenis_importir){
    try {
        String sql = "insert into master_perusahaan (id_perusahaan, nama_perusahaan, alamat_perusahaan, provinsi, telepon, npwp, api, nama_pic, tlp_pic, bidang_usaha, jenis_importir) value (?,?,?,?,?,?,?,?,?,?,?)";
        PreparedStatement perintah = connectionDB.prepareStatement(sql);
        perintah.setString(1, id_perusahaan);
        perintah.setString(2, nama_perusahaan);
        perintah.setString(3, alamat_perusahaan);
        perintah.setString(4, provinsi);
        perintah.setString(5, telepon);
        perintah.setString(6, npwp);
        perintah.setString(7, api);
        perintah.setString(8, nama_pic);
        perintah.setString(9,tlp_pic );
        perintah.setString(10, bidang_usaha);
        perintah.setString(11, jenis_importir);
        perintah.executeUpdate();
        System.out.println("Data berhasil disimpan");
    } catch (Exception e) {
        System.out.println(e.getMessage());
    }
}

public void ubahmaster_perusahaan(String id_perusahaan, String nama_perusahaan, String alamat_perusahaan, String provinsi, String telepon, String npwp, String api, String nama_pic, String tlp_pic, String bidang_usaha, String jenis_importir){
    try {
        String sql = "update master_perusahaan set nama_perusahaan = ? , alamat_perusahaan = ? , provinsi = ? , telepon = ? , npwp = ? , api = ? , nama_pic = ? , tlp_pic = ? , bidang_usaha = ? , jenis_importir = ? where id_perusahaan =?";
        PreparedStatement perintah = connectionDB.prepareStatement(sql);
        perintah.setString(1, nama_perusahaan);
        perintah.setString(2, alamat_perusahaan);
        perintah.setString(3, provinsi);
        perintah.setString(4, telepon);
        perintah.setString(5, npwp);
        perintah.setString(6, api);
        perintah.setString(7, nama_pic);
        perintah.setString(8,tlp_pic );
        perintah.setString(9, bidang_usaha);
        perintah.setString(10, jenis_importir);
        perintah.setString(11, id_perusahaan);
        perintah.executeUpdate();
        System.out.println("Data berhasil diubah");
        
    } catch (Exception e) {
        System.out.println(e.getMessage());
    }
}

public void hapusmaster_perusahaan(String id_perusahaan){
    try {
        String sql = "delete from master_perusahaan where id_perusahaan = ?";
        PreparedStatement perintah = connectionDB.prepareStatement(sql);
        perintah.setString(1, id_perusahaan);
          
        perintah.executeUpdate();
        System.out.println("deleted");
    } catch (Exception e) {
        System.out.println(e.getMessage());
    }
}


public void carimaster_perusahaan(String paramnik){
      try {
          String sql ="SELECT*FROM master_perusahaan where id_perusahaan=?";
          PreparedStatement perintah = connectionDB.prepareStatement(sql);
          perintah.setString(1,paramnik);
          ResultSet data = perintah.executeQuery();
          while(data.next()){
             System.out.println("id_perusahaan :"+data.getString("id_perusahaan"));
             System.out.println("nama_perusahaan :"+data.getString("nama_perusahaan"));
             System.out.println("alamat_perusahaan :"+data.getString("alamat_perusahaan"));
             System.out.println("provinsi :"+data.getString("provinsi"));
             System.out.println("telepon :"+data.getString("telepon"));
             System.out.println("npwp :"+data.getString("npwp"));
             System.out.println("api :"+data.getString("api"));
             System.out.println("nama_pic :"+data.getString("nama_pic"));
             System.out.println("tlp_pic :"+data.getString("tlp_pic"));
             System.out.println("bidang_usaha :"+data.getString("bidang_usaha"));
             System.out.println("jenis_importir :"+data.getString("jenis_importir"));
          }
      } catch (Exception e) {
          System.err.println(e.getMessage());
      }
  }


  public void datamaster_perusahaan(){
      try {
          Statement stmt  = connectionDB.createStatement();
          ResultSet baris = stmt.executeQuery("SELECT*FROM master_perusahaan ORDER BY id_perusahaan ASC");
          while(baris.next()){
              System.out.println(baris.getString("id_perusahaan")+" | "+
                      baris.getString("nama_perusahaan")+" | "+
                      baris.getString("alamat_perusahaan")+" | "+
                      baris.getString("provinsi")+" | "+
                      baris.getString("telepon")+" | "+
                      baris.getString("npwp")+" | "+
                      baris.getString("api")+" | "+
                      baris.getString("nama_pic")+" | "+
                      baris.getString("tlp_pic")+" | "+
                      baris.getString("bidang_usaha")+" | "+
                      baris.getString("jenis_importir"));
          }
      } catch (Exception e) {
          System.err.println(e.getMessage());
          
      }
  }
 
}
