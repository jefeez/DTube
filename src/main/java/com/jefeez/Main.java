package com.jefeez;

import com.jefeez.domain.Tube;
import com.jefeez.domain.enums.Format;

import java.io.IOException;

public class Main {
    private static final String url = "https://www.youtube.com/watch?v=dQw4w9WgXcQ";
    private static final String output = "./dir/";

    public static void main(String[] args) throws IOException {
        new Tube(url, output).download(Format.MP3, System.out::println);
    }
}