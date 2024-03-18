package sgw.auto.rule.strategy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Description 策略注册器
 * @Author sgw
 * @Date 2024/3/18 17:14
 **/
public class RuleStrategyRegistry {
    private Map<String,RuleStrategy> strategyMap;

    public void register(){
        strategyMap = new HashMap<>();
        //获取所有实现了策略接口的类
        List<Class<?>> implementingClasses = new ArrayList<>();
        for (Package p : Package.getPackages()) {
            try {
                Class<?>[] classes = Class.forName(p.getName()).getDeclaredClasses();
                for (Class<?> clazz : classes) {
                    if (RuleStrategy.class.isAssignableFrom(clazz) && !clazz.isInterface() && !clazz.isEnum()) {
                        implementingClasses.add(clazz);
                    }
                }
            } catch (ClassNotFoundException e) {
                throw new RuntimeException(e);
            }
        }

        //将这些类加载到StrategyMap中
        for (Class<?> clazz : implementingClasses) {
            String name = clazz.getSimpleName();
            try {
                Object o = clazz.newInstance();
                strategyMap.put(name, (RuleStrategy) o);
            } catch (InstantiationException e) {
                throw new RuntimeException(e);
            } catch (IllegalAccessException e) {
                throw new RuntimeException(e);
            }

        }
    }

    public RuleStrategy getStrategy(String strategyName) {
        return strategyMap.get(strategyName);
    }
}