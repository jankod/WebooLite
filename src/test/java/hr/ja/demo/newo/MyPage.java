package hr.ja.demo.newo;

import lombok.Getter;

@Getter
public class MyPage {

    MyLabel myLabel;

    MyPage() {
        myLabel = new MyLabel("labela <br>");
    }
}