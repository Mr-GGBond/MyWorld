package sgw.auto.rule;

import sgw.auto.rule.strategy.RuleStrategyRegistry;

/**
 * @Description 规则服务
 * @Author sgw
 * @Date 2024/3/18 16:26
 **/
public class RuleService {

    public static void load(){
        //注册所有的策略
        RuleStrategyRegistry registry = new RuleStrategyRegistry();
        registry.register();

        //根据需要用到的数据类型选择策略进行加载

    }
}
