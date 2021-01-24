package hr.ja.weboo.ui;

import hr.ja.weboo.Widget;

import static j2html.TagCreator.*;

public class InfoBox extends Widget {

    private String text;

    public InfoBox(String text) {
        this.text = text;
    }


    @Override
    public String toString() {

        div(attrs(".info-box"),
                span(attrs(".info-box-icon")));

        String html = """
                <div class="info-box">
                              <span class="info-box-icon bg-info elevation-1"><i class="fas fa-cog"></i></span>
                              <div class="info-box-content">
                                <span class="info-box-text">CPU Traffic</span>
                                <span class="info-box-number">
                                  10
                                  <small>%</small>
                                </span>
                              </div>
                              <!-- /.info-box-content -->
                            </div>
                """;
        return html;
    }

    @Override
    public String toHtml() {
        return null;
    }
}
