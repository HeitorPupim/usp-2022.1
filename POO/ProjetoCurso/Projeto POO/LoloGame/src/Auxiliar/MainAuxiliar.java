/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Auxiliar;

import Modelo.*;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

/**
 *
 * @author Augusto
 */
public class MainAuxiliar {
    public static void main(String[] args){
        File elemento = new File("Fantasma");
        if (elemento.exists()) {
            try {
                elemento.createNewFile();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
        try {
            FileOutputStream fileStream = new FileOutputStream(elemento);
            ObjectOutputStream objectStream = new ObjectOutputStream(fileStream);
            Fantasma fant = new Fantasma("fantasma.png");
            
            objectStream.writeObject(fant);

            objectStream.close();
            fileStream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
