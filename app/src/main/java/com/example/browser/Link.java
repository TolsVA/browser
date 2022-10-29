package com.example.browser;

import androidx.annotation.StringRes;

public enum Link {
    CALC(R.string.calculator, R.string.name_calculator),          // Калькулятор
    INTERPRETER(R.string.interpreter, R.string.name_interpreter), // Переводчик
    MOVIES(R.string.movies, R.string.name_movies),                // Фильмы
    GOOGLE(R.string.google, R.string.name_google);                // Google

    @StringRes
    private final int link;

    @StringRes
    private final int name;

    Link(int link, int name) {
        this.link = link;
        this.name = name;
    }

    public int getLink() {
        return link;
    }

    public int getName() {
        return name;
    }

}
