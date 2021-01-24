package hr.ja.weboo.ui;

import hr.ja.weboo.Widget;
import lombok.Data;
import org.intellij.lang.annotations.Language;

@Data
public class Button extends Widget {

    private String label;
    private String routeAjax;
    private ButtonStyle style = ButtonStyle.DEFAULT;

    public Button(String label, String routeAjax) {
        this.label = label;
        this.routeAjax = routeAjax;
    }


    @Data
    public static class ButtonStyle {

        public static final ButtonStyle DEFAULT = new ButtonStyle();
        private Css.ThemeColor theme = Css.ThemeColor.primary;


    }

    public Button(String label) {
        this.label = label;
    }

    public ClientEvent on(String event) {
        return new ClientEvent(event);
    }


    @Override
    public String toHtml() {

        String ajaxClick = "";
        if (routeAjax != null) {
            ajaxClick = """
                    onclick='weboo.fetch("%s")'
                    """.formatted(routeAjax);
        }

        @Language("HTML")
        String html = """
                <button %s class='btn btn-outline-info '>%s</button>
                """.formatted(ajaxClick, label);
        return html;
    }

//    public Button(String label, AjaxEvent buttonClick) {
//    }
}
