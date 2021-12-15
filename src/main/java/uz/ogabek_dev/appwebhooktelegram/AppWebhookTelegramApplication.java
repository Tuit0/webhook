package uz.ogabek_dev.appwebhooktelegram;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class AppWebhookTelegramApplication {

    public static void main(String[] args) {
        SpringApplication.run(AppWebhookTelegramApplication.class, args);
    }

}
