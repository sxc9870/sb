package sb.sb;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "hello")
public class HelloProperties {
    private static final String MS = "word";

    private String ms = MS;
    public HelloProperties() {
        System.out.println("HelloProperties");
    }
    public String getMs() {
        return ms;
    }

    public void setMs(String ms) {
        this.ms = ms;
    }

     

}
