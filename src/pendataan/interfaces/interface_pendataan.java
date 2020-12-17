/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pendataan.interfaces;

import java.util.List;
import pendataan.model.pendataan;



/**
 *
 * @author Aldy
 */
public interface interface_pendataan {

    public boolean insert (pendataan data);
    public boolean update (pendataan data);
    public boolean delete (int sudah_daftar);
    public int generateID();
    
    public List<pendataan> getAllpendataan();
    
    public pendataan getOnependataanByID(int sudah_daftar);
    
    public List<pendataan> getAllpendataanbyName(String nama);

}

