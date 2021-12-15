package uz.ogabek_dev.appwebhooktelegram.service;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;
import org.telegram.telegrambots.meta.api.objects.Update;

@Service
@RequiredArgsConstructor
public class WebhookService {
    @Autowired
    public WebhookService(@Lazy TgService tgService) {
        this.tgService = tgService;
    }

    private TgService tgService;

    public void waitUpdate(Update update) {
        if (update.hasMessage()) {
            String message = update.getMessage().getText();
            switch (message) {
                case "/start":
                    tgService.whenStart(update);
                    break;
                case "/photo":
                    tgService.sendImage(update);
                    break;
                case "/today":
                    tgService.sendToday(update);
                    break;
                case "/now":
                    tgService.sendNow(update);
                    break;
                default:
            }
        }
    }
}
