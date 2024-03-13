package sgw.auto.request;

import java.lang.annotation.Annotation;

/**
 * @Description 请求处理服务
 * @Author sgw
 * @Date 2024/3/13 10:45
 **/
public interface RequestService {

    void start(Class clazz, Object obj);
}
