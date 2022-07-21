package ru.ak.springcourse;

import java.util.List;

public class JazzMusic implements Music {

    List<String> songs = List.of("Jazz song 1", "Jazz song 2", "Jazz song 3");
    @Override
    public List<String> getSongs() {
        return songs;
    }
}
