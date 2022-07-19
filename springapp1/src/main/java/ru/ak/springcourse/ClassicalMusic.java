package ru.ak.springcourse;

import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ClassicalMusic implements Music {

    List<String> songs = List.of("Classical song 1", "Classical song 2", "Classical song 3");

    @Override
    public List<String> getSongs() {
        return songs;
    }

}
