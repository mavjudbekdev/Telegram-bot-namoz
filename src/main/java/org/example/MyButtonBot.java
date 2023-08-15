package org.example;

import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.meta.generics.LongPollingBot;

public class MyButtonBot extends TelegramLongPollingBot {

    @Override
    public void onUpdateReceived(Update update) {
        if (update.hasMessage() && update.getMessage().hasText()) {
            Message message = update.getMessage();
            String text = message.getText();

            // Botning bir oy davomida habar jo'natishini tekshirish
            if (text.equals("/start")) {
                sendMessageWithDelay(message.getChatId(), "Assalomu alaykum! Botga xush kelibsiz.", 5000);
                sendMessageWithDelay(message.getChatId(), "Men sizning xabarlar keltirish vaqtingizni eslatib beruvchi button botman. Uni siz hohlagan vaqtingizda o'zgartirishingiz mumkin.", 7000);
                sendMessageWithDelay(message.getChatId(), "Agar hozirgi vaqtingizni o'zgartirmoqchi bo'lsangiz, iltimos, pastdagi buttonlardan birini tanlang:", 9000);
            } else if (text.equals("7 da")) {
                sendMessageWithDelay(message.getChatId(), "Vaqt 7 da", 2000);
            } else if (text.equals("8 da")) {
                sendMessageWithDelay(message.getChatId(), "Vaqt 8 da", 2000);
            } else if (text.equals("9 da")) {
                sendMessageWithDelay(message.getChatId(), "Vaqt 9 da", 2000);
            } else if (text.equals("10 da")) {
                sendMessageWithDelay(message.getChatId(), "Vaqt 10 da", 2000);
            } else if (text.equals("11 da")) {
                sendMessageWithDelay(message.getChatId(), "Vaqt 11 da", 2000);
            } else {
                sendMessageWithDelay(message.getChatId(), "Kechirasiz, tushunmadim. Iltimos, pastdagi buttonlardan birini tanlang:", 2000);
            }
        }
    }

    // Habarni belgilangan vaqt o'tgandan keyin jo'natish uchun
    private void sendMessageWithDelay(Long chatId, String message, int delay) {
        Thread thread = new Thread(() -> {
            try {
                Thread.sleep(delay);
                SendMessage sendMessage = new SendMessage();
                sendMessage.setChatId(chatId.toString());
                sendMessage.setText(message);
                execute(sendMessage);
            } catch (TelegramApiException | InterruptedException e) {
                e.printStackTrace();
            }
        });
        thread.start();
    }

    @Override
    public String getBotUsername() {
        return "gtgrgrfdssffde_bot";
    }

    @Override
    public String getBotToken() {
        return "6535157877:AAGYuHftZ7LF-LoOCAUcZE6_1tH4V-xfv84";
    }
}
