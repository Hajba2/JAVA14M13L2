package org.example.telegram.command;

import org.example.telegram.ButtonCreationService;
import org.telegram.telegrambots.extensions.bots.commandbot.commands.BotCommand;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Chat;
import org.telegram.telegrambots.meta.api.objects.User;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.InlineKeyboardButton;
import org.telegram.telegrambots.meta.bots.AbsSender;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import java.util.Arrays;
import java.util.Collections;

public class StartCommand extends BotCommand {

    public StartCommand() {
        super("start", "start descr");
    }

    @Override
    public void execute(AbsSender absSender, User user, Chat chat, String[] strings) {
        String mainText = "Select currency you want to get rate";

        SendMessage sm = new SendMessage();
        sm.setText(mainText);
        sm.setChatId(chat.getId());

        sm.setReplyMarkup(ButtonCreationService.getButtons());

        try {
            absSender.execute(sm);
        } catch (TelegramApiException e) {
            System.out.println("Error during start command");
        }
    }
}
