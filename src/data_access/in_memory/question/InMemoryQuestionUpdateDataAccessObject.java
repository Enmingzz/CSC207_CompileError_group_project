package data_access.in_memory.question;

import data_access.interfaces.question.QuestionUpdateDataAccessInterface;
import entity.comment.*;
import entity.product.CommonProductFactory;
import entity.product.Product;
import entity.product.ProductFactory;
import entity.schedule.CommonScheduleFactory;
import entity.schedule.Schedule;
import entity.schedule.ScheduleFactory;

import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Objects;

public class InMemoryQuestionUpdateDataAccessObject implements QuestionUpdateDataAccessInterface {

    private ArrayList<Question> questions;
    private ArrayList<Product> products;

    public InMemoryQuestionUpdateDataAccessObject() {
        this.questions = new ArrayList<>();
        this.products = new ArrayList<>();
    }

    public InMemoryQuestionUpdateDataAccessObject(ArrayList<Question> questions, ArrayList<Product> products) {
        this.questions = questions;
        this.products = products;
    }

    @Override
    public void updateQuestion(Question question) throws SQLException {


        Answer copyAnswer = new CommonAnswer(question.getAnswer().getDescription(),
                question.getAnswer().getStudentNumber());

        Question newQuestion = new CommonQuestion(question.getDescription(),
                question.getStudentNumber(), copyAnswer, question.getQuestionID());

        for (int i = 0; i < this.questions.size(); i++){
            if(Objects.equals(questions.get(i).getQuestionID(), question.getQuestionID())){
                questions.set(i, newQuestion);
            }
        }
    }
}
