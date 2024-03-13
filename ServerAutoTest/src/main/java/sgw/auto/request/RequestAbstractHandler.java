package sgw.auto.request;

import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Description
 * @Author sgw
 * @Date 2024/3/13 11:20
 **/
public abstract class RequestAbstractHandler implements RequestService{
    protected Map<String, Method> startMethodMap = new HashMap<>();
    protected Map<String, List<ParamDefinition>> paramDefinitionMap = new HashMap<>();

    protected void valid(Class clazz){
        if (clazz == null){
            throw new RuntimeException("Class not found with null");
        }
    }

    /**
     * 处理方法参数
     */
    protected void resolveMethodParams() {
        startMethodMap.forEach((k,v) -> {
            List<ParamDefinition> paramDefinitions = new ArrayList<>();
            for (Parameter p : v.getParameters()) {
                ParamDefinition paramDefinition = ParamDefinition.builder()
                        .name(p.getName())
                        .type(p.getType())
                        .build();
                paramDefinitions.add(paramDefinition);
            }
        });
    }

    /**
     * 构建方法
     * @param clazz
     * @param obj
     */
    protected void buildStartMethodMap(Class clazz, Object obj) {

    }
}
