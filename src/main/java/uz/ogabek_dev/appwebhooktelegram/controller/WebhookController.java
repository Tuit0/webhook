package uz.ogabek_dev.appwebhooktelegram.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.telegram.telegrambots.meta.api.objects.Update;
import uz.ogabek_dev.appwebhooktelegram.service.WebhookService;

@RestController
@RequestMapping("/api/telegram")
@RequiredArgsConstructor
public class WebhookController {
    private final WebhookService service;

    /**
     *
     * @param update
     * get updates and return result of schedule
     *
     */
    @PostMapping
    public void getUpdates(@RequestBody Update update) {
        service.waitUpdate(update);

//         Simple print to console
        System.out.println(update);
    }
}
