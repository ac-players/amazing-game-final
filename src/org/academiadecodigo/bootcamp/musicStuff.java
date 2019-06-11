package org.academiadecodigo.bootcamp;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import java.io.File;

public class musicStuff {
    Clip clip;

    public Clip getClip() {
        return clip;
    }

    void playMusic (String musicLocation){
        try{
        File musicPath = new File(musicLocation);

        if(musicPath.exists()){
            AudioInputStream audioInput = AudioSystem.getAudioInputStream(musicPath);
            Clip clip = AudioSystem.getClip();
            this.clip = clip;
            clip.open(audioInput);
            clip.start();
            clip.loop(Clip.LOOP_CONTINUOUSLY);


        }else{
            System.out.println("no file");
        }

        }
        catch (Exception ex){
        ex.printStackTrace();
        }
    }

     void stopMusic(musicStuff stuff){
        stuff.getClip().close();
        stuff.getClip().stop();
        clip.stop();

    }


}
