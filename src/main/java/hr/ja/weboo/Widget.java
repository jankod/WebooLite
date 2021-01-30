package hr.ja.weboo;

import lombok.Data;

@Data
public abstract class Widget {

//    protected List<Widget> children = new ArrayList<>();
//
//    public Widget() {
//    }
//
//    public Widget(Widget[] widgets) {
//        addAll(widgets);
//    }
//
//    public Widget addAll(Widget... widgets) {
//        for (Widget widget : widgets) {
//            children.add(widget);
//        }
//        return this;
//    }
//
//    public String toHtml(Widget... widgets) {
//        if (widgets == null) {
//            return "";
//        }
//        StringBuilder b = new StringBuilder();
//        for (Widget widget : widgets) {
//            b.append(widget.toHtml());
//        }
//        return b.toString();
//    }

    public abstract String toHtml();

    public String toString() {

        return "";
    }


}
