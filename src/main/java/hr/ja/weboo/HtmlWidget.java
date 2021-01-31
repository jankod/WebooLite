package hr.ja.weboo;

import hr.ja.weboo.ui.Widget;

public interface HtmlWidget extends Widget {

//    @Override
//    default void writeTo(TemplateOutput output) {
//        Weboo.writeWidget(this, output);
//    }

    String toHtml();
//    public String toString() {
//        return "";
//    }


}
