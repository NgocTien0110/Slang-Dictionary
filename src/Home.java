import javax.swing.*;
import java.awt.*;

/**
 * PACKAGE_NAME
 * Create by Đặng Ngọc Tiến
 * Date 11/19/2022 - 3:29 PM
 * Description: ...
 */
public class Home extends JFrame {
    private JLabel title;
    private JButton searchButton;
    private JButton gameButton;
    private JButton manageButton;
    private JButton exitButton;
    private JLabel footer;

    public Home() {
        setTitle("Home");
        setSize(500, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        add(createAndShowGUI());
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public JPanel createAndShowGUI() {
        JPanel panel = new JPanel();
        title = new JLabel("Slang Word", JLabel.CENTER);
        title.setFont(new Font("Serif", Font.PLAIN, 24));
        title.setPreferredSize(new Dimension(500, 100));

        searchButton = new JButton("Search");
        searchButton.setPreferredSize(new Dimension(200, 50));
        gameButton = new JButton("Game");
        gameButton.setPreferredSize(new Dimension(200, 50));
        manageButton = new JButton("Manage");
        manageButton.setPreferredSize(new Dimension(200, 50));
        exitButton = new JButton("Exit");
        exitButton.setPreferredSize(new Dimension(200, 50));
        exitButton.setBackground(Color.RED);

        footer = new JLabel("Copyright by Đặng Ngọc Tiến - 20127641", JLabel.CENTER);
        footer.setFont(new Font("Serif", Font.PLAIN, 12));
        footer.setPreferredSize(new Dimension(500, 50));
        

        panel.add(title, BorderLayout.PAGE_START);
        panel.add(searchButton, BorderLayout.CENTER);
        panel.add(gameButton, BorderLayout.CENTER);
        panel.add(manageButton, BorderLayout.CENTER);
        panel.add(exitButton, BorderLayout.CENTER);
        panel.add(footer, BorderLayout.PAGE_END);
        return panel;
    }


    public static void main(String[] args) {
        new Home();
    }
}


