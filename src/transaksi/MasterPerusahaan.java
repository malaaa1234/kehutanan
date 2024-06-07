/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package transaksi;

/**
 *
 * @author Acer
 */

public class MasterPerusahaan {
    private String idPerusahaan;
    private String namaPerusahaan;
    private String alamatPerusahaan;

    public MasterPerusahaan(String idPerusahaan, String namaPerusahaan, String alamatPerusahaan) {
        this.idPerusahaan = idPerusahaan;
        this.namaPerusahaan = namaPerusahaan;
        this.alamatPerusahaan = alamatPerusahaan;
    }

    public String getIdPerusahaan() {
        return idPerusahaan;
    }

    public void setIdPerusahaan(String idPerusahaan) {
        this.idPerusahaan = idPerusahaan;
    }

    public String getNamaPerusahaan() {
        return namaPerusahaan;
    }

    public void setNamaPerusahaan(String namaPerusahaan) {
        this.namaPerusahaan = namaPerusahaan;
    }

    public String getAlamatPerusahaan() {
        return alamatPerusahaan;
    }

    public void setAlamatPerusahaan(String alamatPerusahaan) {
        this.alamatPerusahaan = alamatPerusahaan;
    }

    public void tampilkanInfo() {
        System.out.println("ID Perusahaan: " + idPerusahaan);
        System.out.println("Nama Perusahaan: " + namaPerusahaan);
        System.out.println("Alamat Perusahaan: " + alamatPerusahaan);
    }
}
