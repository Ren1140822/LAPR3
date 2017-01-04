/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.utils;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.List;
import java.util.Scanner;
import lapr.project.model.Pattern;

/**
 *
 * @author Pedro Fernandes
 */
public class importCSVFlightPattern {
    
    
    
    public importCSVFlightPattern(){

    }
    
    public boolean pattern(String ficheiro, List<Pattern> list){
        try {
            Scanner fInput = new Scanner(new File(ficheiro));  
            
            String[] altitude= fInput.nextLine().split(","); 
            String[] vclimb = fInput.nextLine().split(",");              
            String[] vdesc = fInput.nextLine().split(",");
            
            int count=2;
            while (altitude.length > count){
                double alt = Double.parseDouble(altitude[count].trim());
                double vc = Double.parseDouble(vclimb[count].trim());
                double vd = Double.parseDouble(vdesc[count].trim());
                
                Pattern p = new Pattern(alt, vc, vd);                
                list.add(p);            
                
                count++;
            }
            fInput.close();
            return true;
        } catch (FileNotFoundException ex) {
            System.err.println("Não foi encontrado ficheiro. Erro: " + ex);
            return false;
        }catch (ArrayIndexOutOfBoundsException e){
            System.err.println("Erro ao carregar ficheiro => ficheiro danificado. Erro: " + e);
            return false; 
         }
        
    }
    
}
