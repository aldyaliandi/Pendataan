/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pendataan.model;

/**
 *
 * @author Aldy
 */
public class pendataan {

    
    private String nama;
    private String nrp;
    private String kelas;
    private String email;
    private int sudah_daftar;
    
    public pendataan(String nama, String kelas, String nrp, String email, int sudah_daftar){
            this.nama = nama;
            this.nrp = nrp;
            this.kelas = kelas;
            this.email = email;
            this.sudah_daftar = sudah_daftar;
    }

    public int getSudah_daftar() {
        return sudah_daftar;
    }

    public void setSudah_daftar(int sudah_daftar) {
        this.sudah_daftar = sudah_daftar;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getNrp() {
        return nrp;
    }

    public void setNrp(String nrp) {
        this.nrp = nrp;
    }

    public String getKelas() {
        return kelas;
    }

    public void setKelas(String kelas) {
        this.kelas = kelas;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}