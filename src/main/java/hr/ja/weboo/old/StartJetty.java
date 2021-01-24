package hr.ja.weboo.old;

import lombok.extern.slf4j.Slf4j;
import org.eclipse.jetty.server.Connector;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.server.ServerConnector;
import org.eclipse.jetty.server.handler.ResourceHandler;

@Slf4j
public class StartJetty {

    public static void main(String[] args) throws Exception {
        String d = "";

        Server server = new Server();
        ServerConnector connector = new ServerConnector(server);
        int port = 8090;
        connector.setPort(port);
//        server.setHandler(new MyHandler());
        ResourceHandler resourceHandler = new ResourceHandler();

        server.setConnectors(new Connector[]{connector});


        server.start();

        log.debug("dela port: http://localhost:" + port);
        server.join();

    }


//    static class MyHandler extends AbstractHandler {
//
//
//        @Override
//        public void handle(String target, Request baseRequest, HttpServletRequest request, HttpServletResponse response) throws IOException {
//            log.debug("target {}", target);
//            response.setContentType("text/html;charset=utf-8");
//            response.setStatus(HttpServletResponse.SC_OK);
//            baseRequest.setHandled(true);
//            String res = FreemarkerUtil.parse(new Page1());
//            response.getWriter().println(res);
//        }
//    }
}
