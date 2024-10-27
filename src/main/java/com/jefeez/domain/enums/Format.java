package com.jefeez.domain.enums;

public enum Format {
    F360P("bestvideo[height<=360][ext=mp4]+bestaudio[ext=m4a]/best[height<=360][ext=mp4]"),
    F480P("bestvideo[height<=480][ext=mp4]+bestaudio[ext=m4a]/best[height<=480][ext=mp4]"),
    F720P("bestvideo[height<=720][ext=mp4]+bestaudio[ext=m4a]/best[height<=720][ext=mp4]"),
    F1080P("bestvideo[height<=1080][ext=mp4]+bestaudio[ext=m4a]/best[height<=1080][ext=mp4]"),
    MP3("bestaudio --extract-audio --audio-format mp3");
    private final String code;

    Format(String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }

}
