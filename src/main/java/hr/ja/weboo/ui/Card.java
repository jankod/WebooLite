package hr.ja.weboo.ui;

import hr.ja.weboo.HtmlWidget;
import lombok.Data;
import org.intellij.lang.annotations.Language;


@Data
public class Card implements HtmlWidget {

    private CardColor color = CardColor.none_;
    private String title;
    private String icon;

    @Override
    public String toHtml() {
        @Language("HTML")
        String html = """
                <div class='card'>
                <div class='card-title'>%s</div>
                <div class='card-body'>
                Ovo je card                
                </div>
                </div>
                """.formatted(title);
        return html;
    }

    public enum CardColor {
        primary, warrning, info, success, none_
    }


    public Card() {
    }

    public Card(String title) {
        this();
        this.title = title;

    }
}
