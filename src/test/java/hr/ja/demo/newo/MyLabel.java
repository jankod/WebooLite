package hr.ja.demo.newo;

import hr.ja.weboo.ui.JteWidget;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;


@Slf4j
@Getter
public class MyLabel implements JteWidget {

    private String text;

    public MyLabel(String text) {
        this.text = text;
    }

}
