package sgw.auto.request;

import lombok.Builder;
import lombok.Data;

/**
 * @Description
 * @Author sgw
 * @Date 2024/3/13 11:48
 **/
@Data
@Builder(toBuilder = true)
public class ParamDefinition {
    private Class type;

    private String name;
}
