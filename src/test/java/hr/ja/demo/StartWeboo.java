package hr.ja.demo;

import hr.ja.weboo.Weboo;

public class StartWeboo {


    public static void main(String[] args) {


        Weboo weboo = new Weboo();
        weboo.addPage(PageTable.class);
        weboo.start(8090);


    }
}
