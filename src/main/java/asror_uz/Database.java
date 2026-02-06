package asror_uz;

import java.sql.*;

public class Database {

    String url = "jdbc:postgresql://localhost:5432/tgbotcrud";
    String username = "postgres";
    String password = "root";


//    Create Users

    public void createUser(Person person){
        try {
            Connection connection = DriverManager.getConnection(url , username  ,password);
            Statement statement = connection.createStatement();

            String query = "insert into person (chatid , firstname , lastname, username) values ("+
            person.getChatId() +
                    ",'" + person.getFirstname() +
                    "','" + person.getLastname() +
                    "','" + person.getUsername() + "');";

            statement.execute(query);
            System.out.println("User Saqlandi...");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

//    Read  Users

    public String readUserForDatabase(){
        StringBuilder result = new StringBuilder();

        try {
            Connection connection = DriverManager.getConnection(url , username , password);
            Statement statement = connection.createStatement();
            String query = "select * from person";
            ResultSet resultSet = statement.executeQuery(query);

            while (resultSet.next()){
                Long id = resultSet.getLong(1);
                String name = resultSet.getString(2);
                String surname = resultSet.getString(3);
                String username = resultSet.getString(4);

                result.append("ID :" ).append(id).append("\n")
                        .append("Firstname").append(name).append("\n")
                        .append("Lastname").append(surname).append("\n")
                        .append("USername").append(username).append("\n\n");

            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return result.toString();
    }
}
