package hr.ja.demo.test1;


import hr.ja.weboo.Request;
import hr.ja.weboo.ui.Button;
import hr.ja.weboo.ui.Page;
import hr.ja.weboo.ui.Route;
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

    private Table<User> userTable = new Table<>();

    public PageTable() {
        setTitle("Users");

        userTable.caption("Ovo je tabela")
                .column("ID").setRenderer(User::getId);
        userTable.column("Name").setRenderer(User::getName);
        userTable.column("Action").setRenderer(user -> {
            Button btn = new Button("Edit");
            btn.on("click").goTo(PageTable.class).params("userId", user.getId());
            btn.getStyle().setTheme(primary);
            return btn;
        });


        List<User> data = new ArrayList<>();
        for (int i = 0; i < 11; i++) {
            data.add(new User(i, "user " + i));
        }

        userTable.setData(data);

        @Language("InjectedFreeMarker")
        String html = """
                <div class='row'>
                    <div class='col'>${userTable}</div>
                    <div class='col'></div>
                </div>
                """;
        add(userTable);
    }


    @Route("/users/edit")
    public static void editRow() {
        Context context = Request.get().getContext();
        String userId = context.pathParam("userId");
        log.debug("click userId {}", userId);

    }


}
