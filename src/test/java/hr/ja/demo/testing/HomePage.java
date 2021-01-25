package hr.ja.demo.testing;

import hr.ja.weboo.ui.Label;
import hr.ja.weboo.ui.Page;
import hr.ja.weboo.ui.Route;
import lombok.Data;

import java.net.URL;

@Data
@Route("/home")
public class HomePage extends Page {

    public HomePage() {
        add(new Label("Ovo je home page <b>"));
    }

    public static void main(String[] args) {
        URL res = HomePage.class.getResource("HomePage.jte");
        System.out.println("Nasao res " + res);
    }
}
