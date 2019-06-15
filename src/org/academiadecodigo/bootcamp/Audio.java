package org.academiadecodigo.bootcamp;

import javax.sound.sampled.*;
import java.io.BufferedInputStream;
import java.io.InputStream;

public class Audio{

    private Clip clip;

    public void runAudio() {
        try {
            ClassLoader classLoader = Audio.class.getClassLoader();
            InputStream inputStream = classLoader.getResourceAsStream("song.wav");

            clip = AudioSystem.getClip();
            AudioInputStream ais = AudioSystem.getAudioInputStream(new BufferedInputStream(inputStream));
            clip.open(ais);
            clip.start();
        } catch (Exception ex) {
            System.out.println("NOT");
        }
    }

    public void explosionSound(){
        try {
            ClassLoader classLoader = Audio.class.getClassLoader();
            InputStream inputStream = classLoader.getResourceAsStream("explosionSound.wav");

            clip = AudioSystem.getClip();
            AudioInputStream exp = AudioSystem.getAudioInputStream(new BufferedInputStream(inputStream));
            clip.open(exp);
            clip.start();
        } catch (Exception ex) {
            System.out.println("NOT");
        }
    }
    public void stopAudio(){
        clip.close();
    }
}