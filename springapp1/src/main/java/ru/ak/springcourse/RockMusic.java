package ru.ak.springcourse;

import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class RockMusic implements Music {
    List<String> songs = List.of("Rock song 1", "Rock song 2", "Rock song 3");

    @Override
    public List<String> getSongs() {
        return songs;
    }
}
