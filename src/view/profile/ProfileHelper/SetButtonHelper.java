package view.profile.ProfileHelper;
import javax.swing.*;
import java.awt.*;
import java.util.Objects;

public class SetButtonHelper {
    private final Image resizedImage;
    private final JButton jButton;

    public SetButtonHelper(String pathName, JButton jButton){
        ImageIcon originalIcon = new ImageIcon(Objects.requireNonNull(SetButtonHelper.class.getResource(pathName)));
        resizedImage = originalIcon.getImage().getScaledInstance(50, 50, Image.SCALE_SMOOTH);
        this.jButton = jButton;
    }

    public void setButton(){
        jButton.setIcon(new ImageIcon(resizedImage));
        jButton.setVerticalTextPosition(JButton.BOTTOM);
        jButton.setHorizontalTextPosition(JButton.CENTER);
        jButton.setVerticalAlignment(JButton.CENTER);
        jButton.setHorizontalAlignment(JButton.CENTER);
    }
}
