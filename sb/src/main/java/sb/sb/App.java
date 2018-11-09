package sb.sb;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.sxc.service.WindowsService;

/**
 * Hello world!
 *
 */
@SpringBootApplication
public class App {
    public static void main(String[] args) {
        ConfigurableApplicationContext c=    SpringApplication.run(  App.class, args);
//        WindowsService cc=  c.getBean(WindowsService.class);
//        
//        cc.showCMD();
        
        
        
    }

    private static String change(String a) {
        if (a == null)
            return a;
        a = a.replaceAll("年", "-").replaceAll("月", "-").replaceAll("日", "-");

        String[] b = a.split("-");
        if (b.length == 0)
            return a;
        StringBuilder sb = new StringBuilder();

        switch (b.length) {
        case 1:
            sb.append(b[0]);
            sb.append("0000000000");
            break;
        case 2:
            sb.append(b[0]);
            sb.append(b[1].length() == 2 ? b[1] : "0" + b[1]);
            sb.append("00000000");
            break;
        case 3:
            sb.append(b[0]);
            sb.append(b[1].length() == 2 ? b[1] : "0" + b[1]);
            sb.append(b[2].length() == 2 ? b[2] : "0" + b[2]);
            sb.append("000000");
            break;
        default:
            break;
        }

        return sb.toString();
    }
}
