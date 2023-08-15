package org.example.handler;

import lombok.SneakyThrows;
import org.example.messageBuilder.MessageBuilder;
import org.example.user.User;
import org.example.user.UserRepository;
import org.telegram.telegrambots.bots.DefaultAbsSender;
import org.telegram.telegrambots.meta.api.objects.Update;

import java.util.Optional;

public class UpdateHandler {

    public UpdateHandler(DefaultAbsSender sender) {
        this.sender = sender;
    }

    private final DefaultAbsSender sender;

    private final UserRepository userRepository = UserRepository.getInstance();

    @SneakyThrows
    public void handle(Update update) {
        String chatId = update.getMessage().getChatId().toString();
        Optional<User> optionalUser = userRepository.findById(chatId);
        User user;
        if (optionalUser.isEmpty()) {
            userRepository.save(chatId);
            user = userRepository.findById(chatId).get();
            sender.execute(MessageBuilder.helloMessage(user.getId()));

        } else {
            user = optionalUser.get();
            switch (user.getUserState()) {
                case MAIN -> {
                    String text = update.getMessage().getText();
                    switch (text) {

                        case "✅ Bomdod" -> {
                            user.setBomdod(false);
                            sender.execute(MessageBuilder.changesTrueFalse(user.getId()));
                        }
                        case "❌ Bomdod" -> {
                            user.setBomdod(true);
                            sender.execute(MessageBuilder.changesTrueFalse(user.getId()));
                        }
                        case "✅ Peshin" -> {
                            user.setPeshin(false);
                            sender.execute(MessageBuilder.changesTrueFalse(user.getId()));
                        }
                        case "❌ Peshin" -> {
                            user.setPeshin(true);
                            sender.execute(MessageBuilder.changesTrueFalse(user.getId()));
                        }
                        case "✅ Asr" -> {
                            user.setAsr(false);
                            sender.execute(MessageBuilder.changesTrueFalse(user.getId()));
                        }
                        case "❌ Asr" -> {
                            user.setAsr(true);
                            sender.execute(MessageBuilder.changesTrueFalse(user.getId()));
                        }

                        case "✅ Shom" -> {
                            user.setShom(false);
                            sender.execute(MessageBuilder.changesTrueFalse(user.getId()));
                        }
                        case "❌ Shom" -> {
                            user.setShom(true);
                            sender.execute(MessageBuilder.changesTrueFalse(user.getId()));
                        }

                        case "✅ Xufton" -> {
                            user.setXufton(false);
                            sender.execute(MessageBuilder.changesTrueFalse(user.getId()));
                        }
                        case "❌ Xufton" -> {
                            user.setXufton(true);
                            sender.execute(MessageBuilder.changesTrueFalse(user.getId()));
                        }
                    }
                }
            }
        }
    }
}

