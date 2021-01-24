package hr.ja.weboo.ui;

import hr.ja.weboo.Widget;
import lombok.Data;


@Data
public class Card extends Widget {

    private CardColor color = CardColor.none_;
    private String title;
    private String icon;

    public enum CardColor {
        primary, warrning, info, success, none_
    }


    public Card() {
    }

    public Card(String title) {
        this();
        this.title = title;

    }


    @Override
    public String toHtml() {
        return null;
    }


    public static void main(String[] args) {

        Card card = new Card("Ovo je moj card");

        System.out.println(
                card
        );

    }
}
