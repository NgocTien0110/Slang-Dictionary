import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * PACKAGE_NAME
 * Create by Đặng Ngọc Tiến
 * Date 11/24/2022 - 2:37 PM
 * Description: Game page
 */
public class GamePage extends JFrame implements ActionListener {
    private JPanel panel1;
    private JLabel title;
    private JButton findSlangButton;
    private JButton findDefinitionButton;
    private JButton backButton;
    private JLabel footer;

    public GamePage() {
        setTitle("Game");
        setSize(500, 470);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        add(createAndShowGUI());
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public JPanel createAndShowGUI() {
        panel1 = new JPanel();

        // title
        title = new JLabel("GamePage", JLabel.CENTER);
        title.setFont(new Font("Serif", Font.PLAIN, 28));
        title.setPreferredSize(new Dimension(2000, 100));
        title.setForeground(Color.BLUE);

        // body
        JPanel body = new JPanel();
        body.setLayout(new GridLayout(3, 1, 0, 10));

        findSlangButton = new JButton("Find slang");
        findSlangButton.setPreferredSize(new Dimension(200, 60));
        body.add(findSlangButton);

        findDefinitionButton = new JButton("Find definition");
        findDefinitionButton.setPreferredSize(new Dimension(200, 60));
        body.add(findDefinitionButton);

        backButton = new JButton("Back");
        backButton.setPreferredSize(new Dimension(200, 60));
        backButton.addActionListener(this);
        body.add(backButton);

        // footer
        footer = new JLabel("© 2021 - Đặng Ngọc Tiến", JLabel.CENTER);
        footer.setPreferredSize(new Dimension(2000, 100));

        panel1.add(title, BorderLayout.NORTH);
        panel1.add(body, BorderLayout.CENTER);
        panel1.add(footer, BorderLayout.SOUTH);

        return panel1;
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == backButton) {
            System.out.println("Back Home");
            dispose();
            new Home();
        }
    }

    public static void main(String[] args) {
        new GamePage();
    }
}
