/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pendataan.query;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import pendataan.connection.SQLConnection;
import pendataan.interfaces.interface_pendataan;
import pendataan.model.pendataan;

/**
 *
 * @author Aldy
 */
    public class query_pendataan implements interface_pendataan{
    private Connection conn = SQLConnection.getConnection();

    @Override
    public boolean insert(pendataan p) {
        String sql = "INSERT INTO data_mhs values (?,?,?,?,?)";
        try {
            PreparedStatement statement = conn.prepareStatement(sql);
            
            statement.setString(1, p.getNama());
            statement.setString(2, p.getNrp());
            statement.setString(3, p.getKelas());
            statement.setString(4, p.getEmail());
            statement.setInt(5, p.getSudah_daftar());
            int row = statement.executeUpdate();
            if (row > 0){
                return true;
            }
            statement.close();
        } catch (SQLException ex) {
            Logger.getLogger(pendataan.class.getName()).log(Level.SEVERE, null, ex); 
        }
        return false;
    }

    @Override
    public boolean update(pendataan p) {
        String sql = "UPDATE data_mhs SET nama=?, nrp=? kelas=? email=?"
                + "WHERE sudah_daftar=?";
        try {
            PreparedStatement statement = conn.prepareStatement(sql);
            
            
            statement.setString(1, p.getNama());
            statement.setString(2, p.getNrp());
            statement.setString(3, p.getKelas());
            statement.setString(4, p.getEmail());
            statement.setInt(5, p.getSudah_daftar());
            int row = statement.executeUpdate();
            if (row > 0){
                return true;
            }
            statement.close();
        } catch (SQLException ex) {
            Logger.getLogger(pendataan.class.getName()).log(Level.SEVERE, null, ex); 
        }
        return false;
    }

    @Override
    public boolean delete(int sudah_daftar) {
        String sql = "DELETE FROM data_mhs where sudah_daftar=?";
        try {
            PreparedStatement statement = conn.prepareStatement(sql);
            
            statement.setInt(1, sudah_daftar);
            int row = statement.executeUpdate();
            if (row > 0){
                return true;
            }
            statement.close();
        } catch (SQLException ex) {
            Logger.getLogger(pendataan.class.getName()).log(Level.SEVERE, null, ex); 
        }
        return false;
    }

    @Override
    public int generateID() {
        int sudah_daftar = 0;
        String sql = "EXEC genSudah_daftar";
        try {
            PreparedStatement statement = conn.prepareStatement(sql);

            ResultSet rs = statement.executeQuery();
            while (rs.next()){
                sudah_daftar = rs.getInt(1);
            }
            statement.close();
        } catch (SQLException ex) {
            Logger.getLogger(pendataan.class.getName()).log(Level.SEVERE, null, ex); 
        }
        return sudah_daftar;
    }

    @Override
    public List<pendataan> getAllpendataan() {
        List<pendataan> listpendataan = new ArrayList<>();
        String sql = "Select * from data_mhs";
        try {
            if (SQLConnection.getConnection()==null){
                return null;
            }else{
                PreparedStatement statement = conn.prepareStatement(sql);
                
                ResultSet rs = statement.executeQuery();
                while (rs.next()){
                    pendataan p = new pendataan (
                            
                            rs.getString (1),
                            rs.getString(2),
                            rs.getString (3),
                            rs.getString(4),
                            rs.getInt(5)
                    );
                    listpendataan.add(p);
                }
                statement.close();
            }
        }catch (SQLException ex) {
            Logger.getLogger(pendataan.class.getName()).log(Level.SEVERE, null, ex); 
    }
    return listpendataan;
    }

    @Override
    public pendataan getOnependataanByID(int sudah_daftar) {
        pendataan output = null;
        String sql = "Select * from pendataan where sudah_daftar=?";
        try{
            if (SQLConnection.getConnection()==null){
                return null;
            }else{
                PreparedStatement statement = conn.prepareStatement(sql);
                statement.setInt(1, sudah_daftar);
                
                ResultSet rs = statement.executeQuery();
                while (rs.next()){
                    output = new pendataan(rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getInt(1));        
            }
            statement.close();
            }
            
        }catch (SQLException ex) {
            Logger.getLogger(pendataan.class.getName()).log(Level.SEVERE, null, ex);    
    }
    return output;
    }

    @Override
    public List<pendataan> getAllpendataanbyName(String nama) {
        List<pendataan> listpendataan = new ArrayList<>();
        String sql = "Select * from pendatan WHERE nama like %?%";
        try {
            if (SQLConnection.getConnection()==null){
                return null;
            }else{
                PreparedStatement statement = conn.prepareStatement(sql);
                statement.setString(1, nama);
                
                ResultSet rs = statement.executeQuery();
                while (rs.next()){
                    pendataan p = new pendataan (
                            rs.getString (1),
                            rs.getString(2),
                            rs.getString (3),
                            rs.getString(4),
                            rs.getInt(5)
                    );
                    listpendataan.add(p);
                }
                statement.close();
            }
        }catch (SQLException ex) {
            Logger.getLogger(pendataan.class.getName()).log(Level.SEVERE, null, ex); 
    }
    return listpendataan;
    }
}
