package hr.ja.demo;


import hr.ja.weboo.Request;
import hr.ja.weboo.ui.*;
import hr.ja.weboo.ui.table.Table;
import io.javalin.http.Context;
import lombok.extern.slf4j.Slf4j;

import static hr.ja.weboo.ui.Css.ThemeColor.primary;

@Slf4j
@Route("/users")
public class PageTable extends Page {

    Table<User> userTable = new Table<>();

    public PageTable() {
        title("Users");
        userTable.column("ID").renderer(User::getId);
        userTable.column("Name").renderer(User::getName);
        userTable.column("Action").renderer(user ->
        {
            Button btn = new Button("Edit");
            btn.on("click").goTo(PageTable.class);
            btn.style().theme(primary);
            return btn;
        });

    }

    @Override
    public void doGet() {
        for (int i = 0; i < 11; i++) {
            userTable.addData(new User(i, "user " + i));
        }

        Layout layout = new Layout();
        Layout.Row row = layout.newRow();
        row.addCol(userTable);
        row.addCol(new Label("desno od tablice"));

        add(layout);
    }

    @Route("/users/edit")
    public static void editRow() {
        Context context = Request.get().context();
        String userId = context.pathParam("userId");
        log.debug("click userId {}", userId);

    }


}
