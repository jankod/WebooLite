package hr.ja.demo.newo;

import lombok.Getter;

@Getter
public class MyPage {

    public MyLabel myLabel;

    MyPage() {
        myLabel = new MyLabel("labela < >");
    }
}