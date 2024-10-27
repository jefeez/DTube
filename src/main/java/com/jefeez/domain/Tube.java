package com.jefeez.domain;

import com.jefeez.domain.enums.Format;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.function.Consumer;

public class Tube {

    private String url;
    private String output;
    private Process process;

    public Tube(String url, String output) {
        this.url = url;
        this.output = output + "/%(title)s.%(ext)s";
    }

    public void download(Format format, Consumer<String> consumer) throws IOException {
        String command = "./lib/yt-dlp -f " + format.getCode() + " -o " + this.output + " " + this.url;
        process = Runtime.getRuntime().exec(command);
        display(consumer);
    }

    private void display(Consumer<String> consumer) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
        String line;
        while ((line = reader.readLine()) != null) {
            if (line.contains("[download]") && line.contains("ETA")) {
                consumer.accept(line);
            }
        }
    }

}
