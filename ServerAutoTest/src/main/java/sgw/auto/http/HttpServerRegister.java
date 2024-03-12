package sgw.auto.http;

import com.sun.net.httpserver.HttpServer;

import java.io.IOException;
import java.net.InetSocketAddress;

/**
 * @Description
 * @Author sgw
 * @Date 2024/3/12 14:55
 **/
public class HttpServerRegister {
    static int port = 38438; // 设置端口号

    public static void create(){
        HttpServer server = null;
        try {
            server = HttpServer.create(new InetSocketAddress(port), 0);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        server.createContext("/", new HttpServerHandler());
        server.setExecutor(null); // 使用默认的执行器
        server.start();
    }
}
