package Utlis;

import org.apache.commons.lang3.RandomStringUtils;

import java.util.Stack;

public class GenerateTestMailsForRegistration {
    public static String generateRandomMail(){
        String loweCaseLetters = "abcdefghijklmnopqrstuvwxyz";
        String UpperCaseLeeters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String numbers = "0123456789";
        String mail = RandomStringUtils.random(3,loweCaseLetters)
                + RandomStringUtils.random(3,UpperCaseLeeters)
                + RandomStringUtils.random(3,numbers)
                + System.currentTimeMillis()
                + "@testmail.com";

        System.out.println(mail);
        return mail;
    }
}
