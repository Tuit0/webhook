package uz.ogabek_dev.appwebhooktelegram.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import uz.ogabek_dev.appwebhooktelegram.payload.ResultTelegram;
import uz.ogabek_dev.appwebhooktelegram.utils.RestConstants;

@Service
@RequiredArgsConstructor
public class TgService {

    private final RestTemplate restTemplate;

    public void whenStart(Update update) {
        SendMessage sendMessage = new SendMessage(String.valueOf(update.getMessage().getChatId()),
                "Welcome, Do we define a lesson schedule \uD83D\uDE0E Lets goo...\uD83D\uDE80");
        ResultTelegram result = restTemplate.postForObject(
                RestConstants.TELEGRAM_BASE_URL + RestConstants.BOT_TOKEN + "/sendMessage",
                sendMessage, ResultTelegram.class);

        System.out.println(result);
    }

    public void sendImage(Update update) {

    }

    public void sendToday(Update update) {

    }

    public void sendNow(Update update) {

    }
}
