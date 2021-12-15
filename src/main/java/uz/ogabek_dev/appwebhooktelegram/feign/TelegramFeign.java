package uz.ogabek_dev.appwebhooktelegram.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import uz.ogabek_dev.appwebhooktelegram.payload.ResultTelegram;
import uz.ogabek_dev.appwebhooktelegram.utils.RestConstants;

@FeignClient(url = RestConstants.TELEGRAM_BASE_URL_WITHOUT_BOT, name = "TelegramFeign")
public interface TelegramFeign {
    @PostMapping("{path}/sendMessage")
    ResultTelegram sendMessageToUser(@PathVariable String path,
                                     @RequestBody SendMessage message);
}
