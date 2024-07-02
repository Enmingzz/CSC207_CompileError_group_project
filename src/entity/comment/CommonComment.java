package entity.comment;

/**
 * The superclass of CommonAnswer and CommonQuestion. Two getter method override the methods in two interfaces Answer and question.
 * Two attributes private String description and private CommonUser postUser
 * @author CompileError group
 */

public class CommonComment implements Comment{
    private String description;
    private String studentNumber;

    public CommonComment(String description, String studentNumber) {
        this.description = description;
        this.studentNumber = studentNumber;
    }
    public String getDescription() {
        return description;
    }

    public String getStudentNumber() {
        return studentNumber;
    }
}
