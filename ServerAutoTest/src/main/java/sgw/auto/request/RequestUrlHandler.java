package sgw.auto.request;

import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

/**
 * @Description
 * @Author sgw
 * @Date 2024/3/13 10:53
 **/
public class RequestUrlHandler extends RequestAbstractHandler{

    @Override
    public void start(Class clazz, Object obj) {
        //参数校验
        valid(clazz);
        //根据url获取到方法
        buildStartMethodMap(clazz,obj);
        //处理每个方法的参数
        resolveMethodParams();
        //加载规则
        loadRules();
    }

    @Override
    protected void resolveMethodParams() {
        super.resolveMethodParams();
    }

    /**
     * 构建需要启动的方法
     * @param clazz
     * @param obj
     */
    @Override
    protected void buildStartMethodMap(Class clazz, Object obj) {
        //解析url
        String url = (String) obj;
        for (Method method : clazz.getDeclaredMethods()) {
            //兼容SpringMVC 需要引入servlet+springmvc
            if (method.isAnnotationPresent(RequestMapping.class)) {
                //当传入url为null或者空值的时候，默认启动该类的所有方法
                if (StringUtils.hasText(url)){
                    RequestMapping mappingAnnotation = method.getAnnotation(RequestMapping.class);
                    String[] mappingUrl = mappingAnnotation.value();
                    if (url.equals(mappingUrl)){
                        startMethodMap.put(method.getName(),method);
                        break;
                    }
                }else {
                    startMethodMap.put(method.getName(),method);
                }
            }
        }
    }
}
