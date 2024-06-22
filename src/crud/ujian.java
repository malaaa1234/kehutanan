/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package crud;
import java.sql.Connection;//untuk mendapatkan koneksinya
import java.sql.DriverManager;//menghubungkan database
import java.sql.PreparedStatement;//perintah sql simpan, ubah, hapus[crud]
import java.sql.ResultSet;
import java.sql.Statement;

/**
 *
 * @author Acer
 */
public class ujian {
    String npm;  //nama varibel
    Double nilai1, nilai2, rata;
    int hasilujian;
    
        public ujian() {} 
    
    //nama constructor 2
    public ujian (String npm){
        this.npm = npm;
    }
    
    //nama constructor 3
    public ujian (String ujian, Double nilai1){
        this.npm = npm;
        this.nilai1 = nilai1;
    }
    
    //nama constructor 4
    public ujian (String npm, Double nilai1, Double nilai2){
        this.npm = npm;
        this.nilai1 = nilai1;
        this.nilai2 = nilai2;
        
    }
    
    //nama constructor 4
    public ujian (String npm, Double nilai1, Double nilai2, Double rata){
        this.npm = npm;
        this.nilai1 = nilai1;
        this.nilai2 = nilai2;
         this.rata = rata;
        
    }
    
    public void setnpm(String npm) {  
        this.npm = npm; //II
    }   
    
    public void inputnpm (String npm) {
        this.npm = npm;
    }
    
    public int ambilhasilujian (){
        if (this.npm.equals("A")){
            this.hasilujian=10;
        }else if (this.npm.equals("B")){
            this.hasilujian=9;
        }else if (this.npm.equals("C")){
            this.hasilujian=6;
        }else if (this.npm.equals("D")){
            this.hasilujian=5;
        }else{
            this.hasilujian = 7;
        }
        return this.hasilujian;
    }
    
    public int hasilujian(){
        return hasilujian();

    }
    
}