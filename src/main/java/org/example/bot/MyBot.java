package org.example.bot;

import org.example.handler.UpdateHandler;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.objects.Update;

public class MyBot extends TelegramLongPollingBot {

    private final UpdateHandler updateHandler = new UpdateHandler(this);

    @Override
    public void onUpdateReceived(Update update) {

        updateHandler.handle(update);

    }

    @Override
    public String getBotUsername() {
        return "my_bot_namoz_vaqtllari_bot";
    }

    @Override
    public String getBotToken() {
        return "6653955652:AAECY-Q6g7LOxSMdjlY-GDlsDx521Vy_V5c";
    }
}
