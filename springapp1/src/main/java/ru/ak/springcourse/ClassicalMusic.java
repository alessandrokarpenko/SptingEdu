package ru.ak.springcourse;

public class ClassicalMusic implements Music {
    private ClassicalMusic() {

    }

    @Override
    public String getSong() {
        return "Hungarian Rhapsody";
    }

    private void initMethod() {
        System.out.println("Init method for Classical music");
    }

    private void destroyMethod() {
        System.out.println("Destroy method for Classical music");
    }

    public static ClassicalMusic getInstance() {
        return new ClassicalMusic();
    }
}
