package dr.scs.user.cloud;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.ApplicationContext;

@Slf4j
@SpringBootApplication(scanBasePackages = {"dr.scs"})
@EnableDiscoveryClient
@EnableFeignClients
public class App {

  public static void main(String[] args) {
    ApplicationContext context = SpringApplication.run(App.class, args);
    String serverPort = context.getEnvironment().getProperty("server.port");
    log.info("App started at http://127.0.0.1:" + serverPort);
  }
}
