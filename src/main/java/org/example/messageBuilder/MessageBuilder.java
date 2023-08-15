package org.example.messageBuilder;

import org.example.user.User;
import org.example.user.UserRepository;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardButton;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardRow;

import javax.swing.plaf.TableHeaderUI;
import java.util.List;
import java.util.Optional;


public class MessageBuilder {

    private static UserRepository userRepository = UserRepository.getInstance();

    public static SendMessage helloMessage(String chatId) {
        SendMessage sendMessage = new SendMessage(chatId,
                "Assalomu aleykum botga xush kelibsiz " +
                        "\n\n" +
                        " \uD83D\uDD04 Botimiz orqali siz har namoz vaqti kirganida sizga xabar kelib turadi!" +
                        "\n" +
                        " ✅ Marhamat uzingizga moslab sozlab oling! " +
                        "\n" +
                        "\uD83D\uDD1B Yoniq: Bomdod ✅\n" +
                        "\uD83D\uDCF4O'chiq: Bomdod ❌");
        sendMessage.setReplyMarkup(getMainButton(chatId));
        return sendMessage;
    }

    public static SendMessage changesTrueFalse(String chatId) {
        SendMessage sendMessage = new SendMessage(chatId, "✅ O'zgartirildi!");
        sendMessage.setReplyMarkup(getMainButton(chatId));
        return sendMessage;
    }

    public static ReplyKeyboardMarkup getMainButton(String chatId) {

        Optional<User> optionalUser = userRepository.findById(chatId);

        User user = optionalUser.get();


        KeyboardButton bomdod = new KeyboardButton(user.isBomdod() ? "✅ Bomdod" : "❌ Bomdod");
        KeyboardButton peshin = new KeyboardButton(user.isPeshin() ? "✅ Peshin" : "❌ Peshin");
        KeyboardButton asr = new KeyboardButton(user.isAsr() ? "✅ Asr" : "❌ Asr");
        KeyboardButton shom = new KeyboardButton(user.isShom() ? "✅ Shom" : "❌ Shom");
        KeyboardButton xufton = new KeyboardButton(user.isXufton() ? "✅ Xufton" : "❌ Xufton");

        KeyboardRow row = new KeyboardRow(List.of(bomdod, peshin));
        KeyboardRow row1 = new KeyboardRow(List.of(asr, shom));
        KeyboardRow row2 = new KeyboardRow(List.of(xufton));

        ReplyKeyboardMarkup replyKeyboardMarkup = new ReplyKeyboardMarkup(List.of(row, row1, row2));
        replyKeyboardMarkup.setResizeKeyboard(true);
        return replyKeyboardMarkup;



    }

}
