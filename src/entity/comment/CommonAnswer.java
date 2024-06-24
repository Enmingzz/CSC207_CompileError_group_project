package entity.comment;

/**
 * The subclass of CommonComment, no override, no new attribute and no new method. Use the super constructor to have new CommonAnswer.
 * @author CompileError group
 */

public class CommonAnswer extends CommonComment implements Answer{

    public CommonAnswer(String description, String studentNumber){
        super(description, studentNumber);
    }

}
