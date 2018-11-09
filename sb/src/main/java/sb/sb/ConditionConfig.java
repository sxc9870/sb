package sb.sb;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;

import com.sxc.condition.LiunxCondition;
import com.sxc.condition.WindowsCondition;
import com.sxc.interface1.OSLister;
import com.sxc.service.LinuxService;
import com.sxc.service.WindowsService;

@Configuration
public class ConditionConfig {

    
    @Bean
    @Conditional(WindowsCondition.class)
    public OSLister windowsCondition(){
        return new WindowsService();
    }
    
    
    @Bean
    @Conditional(LiunxCondition.class)
    public OSLister liunxCondition(){
        return new LinuxService();
    }
}
