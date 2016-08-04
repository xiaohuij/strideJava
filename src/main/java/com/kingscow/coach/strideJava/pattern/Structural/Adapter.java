package com.kingscow.coach.strideJava.pattern.Structural;

//Adapter is a converter between two incompatible entities.
//In Java design pattern, Adapter pattern works as a bridge between two incompatible interfaces.

interface AdapterPlayer {
    void play(String type, String fileName);
}

interface AudioPlayer {
    void playAudio(String fileName);
}

interface VideoPlayer {
    void playVideo(String fileName);
}

class MyAudioPlayer implements AudioPlayer {
    @Override
    public void playAudio(String fileName) {
        System.out.println("Playing. Name: " + fileName);
    }
}

class MyVideoPlayer implements VideoPlayer {
    @Override
    public void playVideo(String fileName) {
        System.out.println("Playing. Name: " + fileName);
    }
}

class MyPlayer implements AdapterPlayer {

    AudioPlayer audioPlayer = new MyAudioPlayer();
    VideoPlayer videoPlayer = new MyVideoPlayer();

    public MyPlayer() {
    }

    @Override
    public void play(String audioType, String fileName) {
        if (audioType.equalsIgnoreCase("avi")) {
            videoPlayer.playVideo(fileName);
        } else if (audioType.equalsIgnoreCase("mp3")) {
            audioPlayer.playAudio(fileName);
        }
    }
}

public class Adapter {
    public static void main(String[] args) {
        MyPlayer myPlayer = new MyPlayer();

        myPlayer.play("mp3", "h.mp3");
        myPlayer.play("avi", "me.avi");
    }
}
