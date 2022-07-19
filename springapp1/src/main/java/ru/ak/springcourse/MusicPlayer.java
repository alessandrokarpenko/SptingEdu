package ru.ak.springcourse;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.util.Random;

@Component
public class MusicPlayer {

    private Music musicC;
    private Music musicR;

    public MusicPlayer(@Qualifier("classicalMusic") Music musicC, @Qualifier("rockMusic") Music musicR) {
        this.musicC = musicC;
        this.musicR = musicR;
    }

    public void playMusic(Type type) {

        Music music;
        switch (type) {
            case ROCK:
                music = musicR;
                break;
            case CLASSICAL:
                music = musicC;
                break;
            default:
                throw new RuntimeException();
        };

        Random random = new Random();
        System.out.println(music.getSongs().get(random.nextInt(music.getSongs().size())));
    }

}
