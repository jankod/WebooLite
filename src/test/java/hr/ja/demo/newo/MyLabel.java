package hr.ja.demo.newo;

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;


@Slf4j
@Getter
public class MyLabel implements Widget {

    private String text;

    public MyLabel(String text) {
        this.text = text;
    }

}
