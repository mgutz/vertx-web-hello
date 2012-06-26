package hello;

import org.vertx.java.core.Handler;
import org.vertx.java.core.http.HttpServerRequest;
import org.vertx.java.deploy.Verticle;

/**
 * Created with IntelliJ IDEA.
 * User: coder
 * Date: 6/25/12
 * Time: 10:58 PM
 * To change this template use File | Settings | File Templates.
 */
public class Server extends Verticle {
    public void start() {
        vertx.createHttpServer().requestHandler(new Handler<HttpServerRequest>() {
            @Override
            public void handle(HttpServerRequest req) {
                System.out.println("Got request: " + req.uri);
                System.out.println("Headers are: ");
                for (String key : req.headers().keySet()) {
                    System.out.println(key + ":" + req.headers().get(key));
                }
                req.response.headers().put("Content-Type", "text/html; charset-UTF-8");
                req.response.end("<html><body><h1>Hello from vert.x!</h1></body></html>");
            }
        }).listen(8080);
    }
}
