package entity;

public class CommonQuestion extends CommonComment implements Question{
    Answer answer;

    public CommonQuestion(String description, CommonUser commonUser, Answer answer){
        super(description, commonUser);
        this.answer = answer;
    }
}
