package Hjelpeklasser;

public class Exceptions extends IllegalArgumentException{

    public Exceptions(String message) {
        super(message);
    }

    public String NoSuchFileException(String message){
        System.out.println(message);
        return message;
    }

    public String wrongInputException(String message){
        System.out.println(message);
        return message;
    }
}
