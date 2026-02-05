package asror_uz;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class Person {

    private Long chatId;
    private String firstname;
    private String lastname;
    private String username;


}
