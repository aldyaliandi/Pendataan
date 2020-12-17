/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pendataan.controller;

import java.util.List;
import pendataan.model.pendataan;
import pendataan.query.query_pendataan;

/**
 *
 * @author Aldy
 */
public class controller_pendataan {
 private query_pendataan querypendataan = new  query_pendataan();
    
        public List<pendataan> getAllData() {
        return querypendataan.getAllpendataan();
    }
    
    public boolean insertpendataan(pendataan data){
        return querypendataan.insert(data);
    }
    
    public boolean updatependataan(pendataan data){
        return querypendataan.update(data);
    }
    
    public int generateID(){
        return querypendataan.generateID();
    }
    
    public boolean deletependataan(int sudah_daftar) {
        return querypendataan.delete(sudah_daftar);  
    }
}


