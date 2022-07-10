/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Auxiliar;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;
  
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.FloatControl;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
  
//Classe achado na internet reutilizada e modificada para tocar os efeitos sonoros
public class SoundEffect 
{
  
    // to store current position
    private final Clip clip;
      
    // current status of clip
    private final AudioInputStream audioInputStream;
   
  
    // constructor to initialize streams and clip
    public SoundEffect(String fileName)
        throws UnsupportedAudioFileException,
        IOException, LineUnavailableException 
    {
        String currentPath = new java.io.File(".").getCanonicalPath();
        String filePath = currentPath + Consts.PATH_SOUND + fileName;

        // create AudioInputStream object
        audioInputStream = 
                AudioSystem.getAudioInputStream(new File(filePath).getAbsoluteFile());
          
        // create clip reference
        clip = AudioSystem.getClip();
          
        // open audioInputStream to the clip
        clip.open(audioInputStream);
    }
    
    public void play() 
    {
        //start the clip
        FloatControl gainControl = (FloatControl) clip.getControl(FloatControl.Type.MASTER_GAIN);
        gainControl.setValue(Consts.VOLUME_ABAIXADO + 5);
        clip.start();
    }
    
}