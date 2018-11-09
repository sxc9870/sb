package sb.sb;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.sxc.service.WindowsService;

@Configuration
@EnableConfigurationProperties(HelloProperties.class)
@ConditionalOnClass(WindowsService.class)
@ConditionalOnProperty(prefix="hello",value="enabled",matchIfMissing=true)
public class HelloAutoconfig {
    @Autowired
    private HelloProperties properties;

    public HelloAutoconfig() {
        System.out.println("HelloAutoconfig");
    }
    @Bean
    @ConditionalOnMissingBean(WindowsService.class)
    public WindowsService hService(){
        WindowsService WindowsService= new WindowsService();
        WindowsService.setMs(properties.getMs());
        System.out.println(properties.getMs());
       return WindowsService;
       
    }
    
}
