package sgw.auto.start;

import sgw.auto.http.HttpServerRegister;

/**
 * @Description
 * @Author sgw
 * @Date 2024/3/12 10:17
 **/
public class StartApplication {

    public static void run(Class clazz,String[] args){
        //加载规则
        loadRules();
        //启动服务
        startServer();
    }

    private static void loadRules() {
        
    }

    private static void startServer() {
        HttpServerRegister.create();
    }
}
