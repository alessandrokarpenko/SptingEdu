package ru.ak.springcourse;

import java.util.List;

public class ClassicalMusic implements Music {

    List<String> songs = List.of("Classical song 1", "Classical song 2", "Classical song 3");

    @Override
    public List<String> getSongs() {
        return songs;
    }

}
