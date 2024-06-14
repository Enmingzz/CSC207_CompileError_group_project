package entity;

public class CommonAnswerFactory {
    Answer createCommonAnswer(String description, CommonUser commonUser){
        return new CommonAnswer(description, commonUser);
    }
}
