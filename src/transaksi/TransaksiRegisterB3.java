/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package transaksi;

/**
 *
 * @author Acer
 */
public class TransaksiRegisterB3 {
    private String idTransaksi;
    private String tanggalTransaksi;
    private MasterPerusahaan perusahaan;

    public TransaksiRegisterB3(String idTransaksi, String tanggalTransaksi, MasterPerusahaan perusahaan) {
        this.idTransaksi = idTransaksi;
        this.tanggalTransaksi = tanggalTransaksi;
        this.perusahaan = perusahaan;
    }

    public String getIdTransaksi() {
        return idTransaksi;
    }

    public void setIdTransaksi(String idTransaksi) {
        this.idTransaksi = idTransaksi;
    }

    public String getTanggalTransaksi() {
        return tanggalTransaksi;
    }

    public void setTanggalTransaksi(String tanggalTransaksi) {
        this.tanggalTransaksi = tanggalTransaksi;
    }

    public MasterPerusahaan getPerusahaan() {
        return perusahaan;
    }

    public void setPerusahaan(MasterPerusahaan perusahaan) {
        this.perusahaan = perusahaan;
    }

    public void tampilkanInfo() {
        System.out.println("ID Transaksi: " + idTransaksi);
        System.out.println("Tanggal Transaksi: " + tanggalTransaksi);
        perusahaan.tampilkanInfo();
    }
}

