@import hr.ja.weboo.Widget
@import hr.ja.weboo.ui.Layout
@param Layout root

<div class="${root.containerType()}">
    @for(Layout.Row row: root.rows())
        <div class="row">
            @for(Layout.Col col: row.columns())
                <div class="col">
                    @for(Widget w: col.widgets())
                        ${w.toHtml()}
                    @endfor
                </div>
            @endfor
        </div>
    @endfor
</div>