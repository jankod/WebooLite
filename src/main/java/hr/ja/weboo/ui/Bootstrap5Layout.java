package hr.ja.weboo.ui;

import lombok.Data;

@Data
public class Bootstrap5Layout implements Layout, JteWidget {

    Page page;

    public Bootstrap5Layout(Page page) {
        this.page = page;
    }
}
