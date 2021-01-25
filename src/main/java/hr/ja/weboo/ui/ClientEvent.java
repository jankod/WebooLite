package hr.ja.weboo.ui;

public class ClientEvent {
    public ClientEvent(String event) {

    }

    public JsGotoAction goTo(Class<? extends Page> page) {
        return new JsGotoAction(page);
    }
}
