package cn.itcast.user.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Data      //提供get和Set的方法
@Component  //纳入容器管理，任何人都可以使用
@ConfigurationProperties(prefix = "pattern") //前缀，约定大于配置，前缀名和变量名两者拼接与配置文件一致，就能够完成配置文件的属性注入
public class PatternProperties {
    private String dateformat;
    private String envSharedValue;
    private String name;
}
