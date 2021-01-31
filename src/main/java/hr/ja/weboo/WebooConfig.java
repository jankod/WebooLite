package hr.ja.weboo;

import hr.ja.weboo.ui.Bootstrap5Layout;
import hr.ja.weboo.ui.Layout;
import hr.ja.weboo.ui.Page;
import lombok.Builder;
import lombok.Getter;
import lombok.Singular;

import java.util.ArrayList;
import java.util.List;

@Builder
@Getter
public class WebooConfig {

    @Singular
    private List<Class<? extends Page>> pages = new ArrayList<>();

    private Class<? extends Layout> layout = Bootstrap5Layout.class;

    private int port = 9000;

    private boolean debug = true;

}
