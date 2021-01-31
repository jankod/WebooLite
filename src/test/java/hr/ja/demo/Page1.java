package hr.ja.demo;

import hr.ja.weboo.ui.Label;
import hr.ja.weboo.ui.Page;
import hr.ja.weboo.ui.Route;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Route("/p1")
@Getter
public class Page1  extends Page {

    public Page1() {
        add(new Label("Ovo je pero"));
    }

}
