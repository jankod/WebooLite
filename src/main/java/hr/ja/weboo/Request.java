package hr.ja.weboo;

import io.javalin.http.Context;
import lombok.Data;

@Data
public class Request {

    private static ThreadLocal<Request> requestThreadLocal = new InheritableThreadLocal<>();

    private Context context;

    private Request() {
    }

    protected static void addContext(Context c) {
        Request request = new Request();
        request.setContext(c);
        requestThreadLocal.set(request);
    }

    public static Request get() {
        return requestThreadLocal.get();
    }
}
