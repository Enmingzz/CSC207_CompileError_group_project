package entity.comment;

/**
 * The interface of CommonQuestion which is used by the out layer
 *@author CompileError group
 */

public interface Question{

    String getDescription();

    String getStudentNumber();

    Answer getAnswer();

}
