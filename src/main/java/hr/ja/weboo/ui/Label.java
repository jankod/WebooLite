package hr.ja.weboo.ui;

import lombok.Getter;

public class Label implements JteWidget {

    @Getter
    private String text;

    public Label(String text) {
        this.text = text;
    }

}
