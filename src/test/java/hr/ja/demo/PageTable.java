package hr.ja.demo;


import hr.ja.weboo.Request;
import hr.ja.weboo.ui.*;
import hr.ja.weboo.ui.table.CollectionDataProvider;
import hr.ja.weboo.ui.table.Table;
import io.javalin.http.Context;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import org.intellij.lang.annotations.Language;

import java.util.ArrayList;
import java.util.List;

import static hr.ja.weboo.ui.Css.ThemeColor.primary;

@Slf4j
@Route("/")
@Getter
public class PageTable extends Page {


    @Language("InjectedFreeMarker")
    final static String t = """
            <div>
            ${userTable}
            </div>
            """;

    private Table<User> userTable = new Table<>();
    public PageTable() {
        title("Users");


        userTable.caption("Ovo je tabela");
        userTable.column("ID").renderer(User::getId);
        userTable.column("Name").renderer(User::getName);
        userTable.column("Action").renderer(user -> {
            Button btn = new Button("Edit");
            btn.on("click").goTo(PageTable.class).params("userId", user.getId());
            btn.style().theme(primary);
            return btn;
        });


        List<User> data = new ArrayList<>();
        for (int i = 0; i < 11; i++) {
            data.add(new User(i, "user " + i));
        }

        userTable.dataProvider(new CollectionDataProvider<>(data));


        @Language("InjectedFreeMarker")
        String html = """
                <div class='row'>
                    <div class='col'>${userTable}</div>
                    <div class='col'></div>
                </div>
                """;
        template(html);

        add(userTable);

    }

    private void template(String s) {
    }

    @Route("/users/edit")
    public static void editRow() {
        Context context = Request.get().context();
        String userId = context.pathParam("userId");
        log.debug("click userId {}", userId);

    }


}
