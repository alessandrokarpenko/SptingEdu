package ru.ak.springcourse;

import org.springframework.beans.factory.annotation.Value;

import java.util.List;
import java.util.Random;

public class MusicPlayer {

    @Value("${musicPlayer.name}")
    private String name;

    @Value("${musicPlayer.volume}")
    private int volume;

    List<Music> musicGenres;

    public MusicPlayer(List<Music> musicGenres) {
        this.musicGenres = musicGenres;
    }

    public void playMusic() {

        Random randomGenre = new Random();

        Music music = musicGenres.get(randomGenre.nextInt(musicGenres.size()));

        Random randomSong = new Random();

        System.out.println(music.getSongs().get(randomSong.nextInt(music.getSongs().size())));

    }

}
