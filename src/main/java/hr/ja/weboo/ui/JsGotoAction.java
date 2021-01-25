package hr.ja.weboo.ui;

public class JsGotoAction {
    private Class<? extends Page> page;

    public JsGotoAction(Class<? extends Page> page) {
        this.page = page;
    }

    public void params(String name, Object value) {
    }
}
