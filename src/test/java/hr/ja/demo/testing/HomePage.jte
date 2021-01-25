@import hr.ja.demo.testing.HomePage
@param HomePage page
<html>


<body>
Tittle ${page.title()}
<br>
@for(hr.ja.weboo.Widget w:  page.widgetList())
    $unsafe{w.toHtml()}
@endfor

</body>
</html>