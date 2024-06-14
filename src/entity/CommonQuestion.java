package entity;

public class CommonQuestion extends CommonComment implements Question{
    private Answer answer;

    public CommonQuestion(String description, CommonUser commonUser, Answer answer){
        super(description, commonUser);
        this.answer = answer;
    }
}
