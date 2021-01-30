package hr.ja.demo.testing;

import hr.ja.demo.User;
import hr.ja.weboo.ui.GridLayout;
import hr.ja.weboo.ui.Label;
import hr.ja.weboo.ui.Page;
import hr.ja.weboo.ui.Route;
import hr.ja.weboo.ui.table.Table;
import lombok.Data;

import java.net.URL;

@Data
@Route("/home")
public class HomePage extends Page {

    Label label;
    Table<User> table;

     HomePage() {
         GridLayout grid = new GridLayout();
         grid.row()
                 .addCol();
        add(new Label("Ovo je home page <b>"));
        add(new Table<>());
    }

    public static void main(String[] args) {
        URL res = HomePage.class.getResource("HomePage.jte");
        System.out.println("Nasao res " + res);
    }
}
