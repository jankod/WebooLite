package hr.ja.demo.test1;

import hr.ja.weboo.Weboo;
import hr.ja.weboo.WebooConfig;
import hr.ja.weboo.ui.Bootstrap5Layout;

public class StartWeboo {


    public static void main(String[] args) {

        WebooConfig config = WebooConfig
                .builder()
                //.page(PageTable.class)
                .page(Page1.class)
                .layout(Bootstrap5Layout.class)
                .port(9000)
                .debug(true)
                .build();

        Weboo.start(config);

    }
}
