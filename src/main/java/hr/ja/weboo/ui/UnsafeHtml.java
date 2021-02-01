package hr.ja.weboo.ui;

import hr.ja.weboo.HtmlWidget;

public class UnsafeHtml implements HtmlWidget {

    private String html;

    public UnsafeHtml(String html) {
        this.html = html;
    }

    @Override
    public String toHtml() {
        return html;
    }
}
