package gg.jte.generated;
import hr.ja.demo.testing.HomePage;
public final class JteHomePageGenerated {
	public static final String JTE_NAME = "HomePage.jte";
	public static final int[] JTE_LINE_INFO = {0,0,1,1,1,6,6,6,6,8,8,9,9,9,10,10,13};
	public static void render(gg.jte.html.HtmlTemplateOutput jteOutput, gg.jte.html.HtmlInterceptor jteHtmlInterceptor, HomePage page) {
		jteOutput.writeContent("<html>\n\n\n<body>\nTittle ");
		jteOutput.setContext("body", null);
		jteOutput.writeUserContent(page.title());
		jteOutput.writeContent("\n<br>\n");
		for (hr.ja.weboo.Widget w:  page.widgetList()) {
			jteOutput.writeContent("\n    ");
			jteOutput.setContext(null, null);
			jteOutput.writeUserContent(w.toHtml());
			jteOutput.writeContent("\n");
		}
		jteOutput.writeContent("\n\n</body>\n</html>");
	}
	public static void renderMap(gg.jte.html.HtmlTemplateOutput jteOutput, gg.jte.html.HtmlInterceptor jteHtmlInterceptor, java.util.Map<String, Object> params) {
		HomePage page = (HomePage)params.get("page");
		render(jteOutput, jteHtmlInterceptor, page);
	}
}
