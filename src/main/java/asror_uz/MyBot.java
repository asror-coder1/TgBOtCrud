package asror_uz;

import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

public class MyBot extends TelegramLongPollingBot {

    Database database = new Database();

    @Override
    public void onUpdateReceived(Update update) {

        if (update.hasMessage() && update.getMessage().hasText()) {

            Long chatId = update.getMessage().getChatId();
            String text = update.getMessage().getText();

            if (text.equals("/start")) {

                String firstName = update.getMessage().getFrom().getFirstName();
                String lastName = update.getMessage().getFrom().getLastName();
                String userName = update.getMessage().getFrom().getUserName();

                Person users = new Person(chatId, firstName, lastName, userName);

                try {
                    database.createUser(users);
                } catch (Exception e) {
                    e.printStackTrace();
                }

                SendMessage sendMessage = new SendMessage();
                sendMessage.setChatId(chatId.toString());
                sendMessage.setText("Hello " + firstName + " 👋");

                try {
                    execute(sendMessage);
                } catch (TelegramApiException e) {
                    e.printStackTrace();
                }
            }
        }
    }


    @Override
    public String getBotUsername() {
        return "nurziyosheyxBot";
    }

    @Override
    public String getBotToken() {
        return "8342620478:AAETYZZrMGFyh9_OMZlNqPGozG3G3xQUK8s";
    }
}
