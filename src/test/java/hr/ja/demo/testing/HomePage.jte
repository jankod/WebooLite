@import hr.ja.demo.testing.HomePage
@param HomePage page

<div>
    Tittle ${page.title()}

    <br>
    @for(hr.ja.weboo.Widget w:  page.widgets())
        $unsafe{w.toHtml()}
    @endfor
</div>