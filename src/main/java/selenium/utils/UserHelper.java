package selenium.utils;

import com.github.javafaker.Faker;
import selenium.models.User;

import java.util.Locale;

public class UserHelper {

    public static User buildUser() {
        Faker bgFaker = new Faker(new Locale("en-GB"));
        Faker faker = new Faker();
        return User.builder()
                .email(faker.internet().emailAddress())
                .firstName(bgFaker.name().firstName())
                .lastName(bgFaker.name().lastName())
                .password("Georgi123@")
                .build();
    }
}
