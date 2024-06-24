package view.signup;

import java.awt.*;

public class SignupPanel {
    public static void main(String[] args) {
        Frame frame = new Frame();
        Panel panel = new Panel();
        panel.add(new TextField("hello world!"));
        frame.add(panel);
        frame.setVisible(true);
        frame.setBounds(100,100,1000,1000);
    }
}
