import java.awt.*;
import java.awt.event.*;

import javax.swing.JTextArea;


public class HelloWorldGUI extends Frame {

    class MyFocusListener implements FocusListener {
        private String id;

        public MyFocusListener(String id) {
            this.id = id;
        }

        public void focusGained(FocusEvent e) {
            System.out.println(id + ": Focus Gained");
        }

        public void focusLost(FocusEvent e) {
            System.out.println(id + ": Focus Lost");
        }
    }

    class MyMouseListener extends MouseAdapter {
        private String id;
        private JTextArea ta;

        public MyMouseListener(String id, JTextArea ta) {
            this.id = id;
            this.ta = ta;
        }

        @Override
        public void mouseClicked(MouseEvent e) {
            System.out.println(id + ": Mouse Clicked");
            ta.setText(id + ": Mouse Clicked");
        }
    }

    public HelloWorldGUI() {
        JTextArea ta = new JTextArea("This is a text area");
        ta.setSize(150, 150);
        ta.setColumns(20);
        ta.setEditable(false);

        Button btn1 = new Button("Button1");
        btn1.setBounds(50, 50, 50, 50);
        btn1.addMouseListener(new MyMouseListener("button1", ta));
        btn1.addFocusListener(new MyFocusListener("button1"));
        add(btn1);
        Button btn2 = new Button("Button2");
        btn2.setBounds(50, 50, 50, 50);
        btn2.addMouseListener(new MyMouseListener("button2", ta));
        btn2.addFocusListener(new MyFocusListener("button2"));
        add(btn2);

        add(ta);

        setSize(350, 350);
        setTitle("This is my First AWT/Swing example");
        setLayout(new FlowLayout());
        setVisible(true);

        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent we) {
                dispose();
            }
        });
    }

    public static void main(String args[]) {
        new HelloWorldGUI();
    }
}
