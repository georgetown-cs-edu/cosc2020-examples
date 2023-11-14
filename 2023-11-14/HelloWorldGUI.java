import java.awt.FlowLayout;
import java.awt.event.*;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextArea;


public class HelloWorldGUI  {

    private JTextArea ta;

    class MyFocusListener implements FocusListener {
        private String id;

        public MyFocusListener(String id) {
            this.id = id;
        }

        public void focusGained(FocusEvent e) {
            ta.setText(id + ": Focus Gained");
            System.out.println(id + ": Focus Gained");
        }

        public void focusLost(FocusEvent e) {
            ta.setText(id + ": Focus Lost");
            System.out.println(id + ": Focus Lost");
        }
    }

    class MyMouseListener extends MouseAdapter {
        private String id;

        public MyMouseListener(String id) {
            this.id = id;
        }

        @Override
        public void mouseClicked(MouseEvent e) {
            System.out.println(id + ": Mouse Clicked");
            ta.setText(id + ": Mouse Clicked");
        }
    }

    public HelloWorldGUI() {
        JFrame frame = new JFrame("Fun with Buttons");

        ta = new JTextArea("This is a text area");
        ta.setSize(150, 150);
        ta.setColumns(20);
        ta.setEditable(false);

        JButton btn1 = new JButton("Button1");
        btn1.setBounds(50, 50, 50, 50);
        btn1.addMouseListener(new MyMouseListener("button1"));
        btn1.addFocusListener(new MyFocusListener("button1"));
        frame.add(btn1);
        JButton btn2 = new JButton("Button2");
        btn2.setBounds(50, 50, 50, 50);
        btn2.addMouseListener(new MyMouseListener("button2"));
        btn2.addFocusListener(new MyFocusListener("button2"));
        frame.add(btn2);

        frame.add(ta);

        frame.setSize(350, 350);
        frame.setTitle("This is my first Swing example");
        frame.setLayout(new FlowLayout());
        frame.setVisible(true);

        frame.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent we) {
                frame.dispose();
            }
        });
    }

    public static void main(String args[]) {
        new HelloWorldGUI();
    }
}
