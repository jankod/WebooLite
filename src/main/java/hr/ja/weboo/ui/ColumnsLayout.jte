@import hr.ja.weboo.HtmlWidget
@import hr.ja.weboo.ui.GridLayout
@param GridLayout root

<div class="${root.containerType()}">
    @for(GridLayout.Row row: root.rows())
        <div class="row">
            @for(GridLayout.Col col: row.columns())
                <div class="${col.classes()}">
                    @for(HtmlWidget w: col.widgets())
                        ${w.toHtml()}
                    @endfor
                </div>
            @endfor
        </div>
    @endfor

</div>