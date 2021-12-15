package uz.ogabek_dev.appwebhooktelegram.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import uz.ogabek_dev.appwebhooktelegram.feign.TelegramFeign;
import uz.ogabek_dev.appwebhooktelegram.payload.ResultTelegram;
import uz.ogabek_dev.appwebhooktelegram.utils.RestConstants;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

@RestController
@RequestMapping("/api/admin")
@RequiredArgsConstructor
public class AdminController {
    private final TelegramFeign feign;

    private final Set<String> userChatIdList = new HashSet<>(Arrays.asList("592298680"));

    @GetMapping("/send")
    public String sendMessage(@RequestParam String text) {
        for (String chatId : userChatIdList) {
            SendMessage sendMessage = new SendMessage(chatId, text);
            ResultTelegram resultTelegram = feign.sendMessageToUser("bot" + RestConstants.BOT_TOKEN, sendMessage);

            System.out.println(resultTelegram);
        }
        return "Message sent !!";
    }
}
