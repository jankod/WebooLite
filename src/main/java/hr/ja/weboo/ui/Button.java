package hr.ja.weboo.ui;

import hr.ja.weboo.HtmlWidget;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class Button implements HtmlWidget {

    private String label;
    private ButtonStyle style = ButtonStyle.DEFAULT;
    private List<ClientEvent> clientEvents = new ArrayList<>();

    @Data
    public static class ButtonStyle {
        public static final ButtonStyle DEFAULT = new ButtonStyle();
        private Css.ThemeColor theme = Css.ThemeColor.primary;
    }

    public Button(String label) {
        this.label = label;
    }

    public ClientEvent on(String event) {
        ClientEvent clientEvent = new ClientEvent(event);
        clientEvents.add(clientEvent);
        return clientEvent;
    }

    @Override
    public String toHtml() {
        return "<button>" + label + "</button>";
    }

//    @SneakyThrows
//    @Override
//    public void writeTo(TemplateOutput output) {
//        output.writeUserContent("<button>" + label + "</button>");
//
//    }
}
