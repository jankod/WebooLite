package hr.ja.weboo.ui;

import hr.ja.weboo.Widget;
import lombok.Getter;

public class Label extends Widget {

    @Getter
    private String text;

    public Label(String text) {
        this.text = text;
    }

    @Override
    public String toHtml() {
        return "<div>%s</div>".formatted(text);
    }
}
