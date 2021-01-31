package gg.jte.generated;
public final class JtehrjademonewoGenerated {
	public static final String JTE_NAME = "hr.ja.demo.newo.MyLabel";
	public static final int[] JTE_LINE_INFO = {0,0,0,0,1,1,1,1,1};
	public static void render(gg.jte.html.HtmlTemplateOutput jteOutput, gg.jte.html.HtmlInterceptor jteHtmlInterceptor, hr.ja.demo.newo.MyLabel label) {
		jteOutput.writeContent("<label>");
		jteOutput.setContext("label", null);
		jteOutput.writeUserContent(label.getText());
		jteOutput.writeContent("</label>");
	}
	public static void renderMap(gg.jte.html.HtmlTemplateOutput jteOutput, gg.jte.html.HtmlInterceptor jteHtmlInterceptor, java.util.Map<String, Object> params) {
		hr.ja.demo.newo.MyLabel label = (hr.ja.demo.newo.MyLabel)params.get("label");
		render(jteOutput, jteHtmlInterceptor, label);
	}
}
