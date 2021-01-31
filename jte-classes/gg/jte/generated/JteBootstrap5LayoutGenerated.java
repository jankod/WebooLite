package gg.jte.generated;
public final class JteBootstrap5LayoutGenerated {
	public static final String JTE_NAME = "Bootstrap5Layout.jte";
	public static final int[] JTE_LINE_INFO = {0,0,0,0,7,7,7,7,29,29,29,34};
	public static void render(gg.jte.html.HtmlTemplateOutput jteOutput, gg.jte.html.HtmlInterceptor jteHtmlInterceptor, hr.ja.weboo.ui.Bootstrap5Layout layout) {
		jteOutput.writeContent("\n\n<!doctype html>\n<html lang=\"en\">\n<body>\n<div class=\"container\">\n    ");
		jteOutput.setContext("div", null);
		jteOutput.writeUserContent(layout.getPage().getTitle());
		jteOutput.writeContent("\n</div>\n<script src=\"https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta1/dist/js/bootstrap.bundle.min.js\"\n        integrity=\"sha384-ygbV9kiqUc6oa4msXn9868pTtWMgiQaeYH7/t7LECLbyPA2x65Kgf80OJFdroafW\"\n        crossorigin=\"anonymous\"></script>\n<script src=\"weboo.js\"></script>\n</body>\n<head>\n    <meta charset=\"utf-8\">\n    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">\n\n    <link href=\"bootstrap.min.css\" rel=\"stylesheet\"\n          integrity=\"sha384-giJF6kkoqNQ00vy+HMDP7azOuL0xtbfIcaT9wjKHr8RbDVddVHyTfAAsrekwKmP1\" crossorigin=\"anonymous\">\n\n</head>\n<body>\n\n\n<div class=\"container\">\n    <h2>Ovo je bootstrap 5 layout</h2>\n\n    <p>Page</p>\n    <div>");
		jteOutput.setContext("div", null);
		jteOutput.writeUserContent(layout.getPage());
		jteOutput.writeContent("</div>\n</div>\n</body>\n\n\n</html>");
	}
	public static void renderMap(gg.jte.html.HtmlTemplateOutput jteOutput, gg.jte.html.HtmlInterceptor jteHtmlInterceptor, java.util.Map<String, Object> params) {
		hr.ja.weboo.ui.Bootstrap5Layout layout = (hr.ja.weboo.ui.Bootstrap5Layout)params.get("layout");
		render(jteOutput, jteHtmlInterceptor, layout);
	}
}
