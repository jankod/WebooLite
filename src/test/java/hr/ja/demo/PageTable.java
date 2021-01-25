package hr.ja.demo;


import hr.ja.weboo.Request;
import hr.ja.weboo.ui.*;
import hr.ja.weboo.ui.table.Table;
import io.javalin.http.Context;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;

import static hr.ja.weboo.ui.Css.ThemeColor.primary;

@Slf4j
@Route("/users")
public class PageTable extends Page {


    public PageTable() {
        Table<User> userTable = new Table<>();
        title("Users");
        userTable.column("ID").renderer(User::getId);
        userTable.column("Name").renderer(User::getName);
        userTable.column("Action").renderer(user ->
        {
            Button btn = new Button("Edit");
            btn.on("click").goTo(PageTable.class).params("userId", user.getId());
            btn.style().theme(primary);
            return btn;
        });

        userTable.dataProvider((num, size) -> {
            List<User> data = new ArrayList<>();
            for (int i = 0; i < 11; i++) {
                data.add(new User(i, "user " + i));
            }
            return data;
        });


        GridLayout gridLayout = new GridLayout();
        GridLayout.Row row1 = gridLayout.row();
        row1.cols("pero", "pšerica", "object");
        row1.getCol(0).style(Css.Size.lg_4);


        GridLayout.Row row = gridLayout.addRow();
        row.addCol(userTable);
        row.addCol(new Label("desno od tablice"));

        String userId = Request.get().context().pathParam("userId");
        if (userId != null) {


        }
        add(gridLayout);

    }

    @Route("/users/edit")
    public static void editRow() {
        Context context = Request.get().context();
        String userId = context.pathParam("userId");
        log.debug("click userId {}", userId);

    }


}
