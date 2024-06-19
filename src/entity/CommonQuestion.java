package entity;

public class

CommonQuestion extends CommonComment implements Question{
    private Answer answer;

    public CommonQuestion(String description, User commonUser, Answer answer){
        super(description, commonUser);
        this.answer = answer;
    }

    @Override
    public Answer getAnswer() {
        return answer;
    }
}
