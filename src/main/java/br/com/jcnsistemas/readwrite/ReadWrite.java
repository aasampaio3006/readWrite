package br.com.jcnsistemas.readwrite;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 *
 * @author Andrade
 */
public class ReadWrite {

    public static void run(String data, String hora) {

        File folder = new File("C:\\Users\\Andrade\\Documents\\Arquivo Ello\\Envia\\");
        File archiveCSV = new File("C:\\Users\\Andrade\\Documents\\Arquivo Ello\\Recebe\\data.csv");
         File newFile = new File(folder, "BASE_CADASTRAL_FACILITADOR_4058_" + data + ".txt");
        BufferedReader br = null;
        BufferedWriter bw = null;
        String line = "";
        String csvDivisor = ",";

        int numSequencial = 1;
        String codRegistro = "00";
        
        try {
            if (!folder.exists()) {
                folder.mkdir();
            }

            br = new BufferedReader(new FileReader(archiveCSV));
            bw = new BufferedWriter(new FileWriter(newFile));

            while ((line = br.readLine()) != null) {
                String[] columns = line.split(csvDivisor);                
                String newLine = codRegistro + ";" + numSequencial + ";";
                
                for (int i = 0; i < columns.length; i++) {
                    if (numSequencial == 1) {
                        newLine += "4058;" + data + ";" + hora;
                        break;
                    }
                    
                   // if (columns[1].equals("\"\"")) {
                   //if (columns[1].equals("")) {	
                	   if (columns[1].length() == 0) {	   
                        columns[1] = columns[2];
                    }
                    newLine += columns[i];
                    if (i < columns.length -1) {
                         newLine += ";";
                    }
                    

                }

              // System.out.println(columns[1].length());
                line = newLine;
                numSequencial++;
                if (numSequencial > 1) {
                    codRegistro = "01";
                }       
                bw.write(line);
                bw.newLine();
                bw.flush();

            }
            
            String fimLine = "";
            line = fimLine + "09;" + numSequencial;
            bw.write(line);
            bw.flush();

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (br != null || bw != null) {
                try {
                    br.close();
                    bw.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

}
