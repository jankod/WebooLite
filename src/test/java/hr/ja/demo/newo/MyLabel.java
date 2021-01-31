package hr.ja.demo.newo;

import gg.jte.Content;
import gg.jte.TemplateOutput;
import gg.jte.html.OwaspHtmlTemplateOutput;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;


@Slf4j
@Getter
public class MyLabel implements Content, Widget {

    private String text;

    public MyLabel(String text) {
        this.text = text;
    }

    @Override
    public void writeTo(TemplateOutput output) {
        log.debug("class {}", output.getClass());
        OwaspHtmlTemplateOutput o = (OwaspHtmlTemplateOutput) output;


        TestNew.writeContent(this, output);
    }
}
