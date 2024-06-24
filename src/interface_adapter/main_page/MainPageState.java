package interface_adapter.main_page;

import entity.user.User;

public class MainPageState {

    private String studentNumber = "";

    public MainPageState() {}

    public String getStudentNumber() {
        return studentNumber;
    }

    public void setStudentNumber(String studentNumber) {
        this.studentNumber = studentNumber;
    }
}
