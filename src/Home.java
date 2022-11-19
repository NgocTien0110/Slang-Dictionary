import javax.swing.*;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import java.awt.*;

/**
 * PACKAGE_NAME
 * Create by Đặng Ngọc Tiến
 * Date 11/19/2022 - 3:29 PM
 * Description: Home page
 */
public class Home extends JFrame {
    private JPanel panel;
    private JLabel title;
    private JButton searchButton;
    private JButton gameButton;
    private JButton manageButton;
    private JButton exitButton;
    private JLabel footer;

    public Home() {
        setTitle("Home");
        setSize(500, 320);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        add(createAndShowGUI());
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public JPanel createAndShowGUI() {
        panel = new JPanel();
        title = new JLabel("Slang Word", JLabel.CENTER);
        title.setFont(new Font("Serif", Font.PLAIN, 28));
        title.setPreferredSize(new Dimension(2000, 100));
//        title.setForeground(Color.BLUE);


        searchButton = new JButton("Search");
        searchButton.setPreferredSize(new Dimension(200, 60));

        gameButton = new JButton("Game");
        gameButton.setPreferredSize(new Dimension(200, 60));

        manageButton = new JButton("Manage");
        manageButton.setPreferredSize(new Dimension(200, 60));

        exitButton = new JButton("Exit");
        exitButton.setPreferredSize(new Dimension(200, 60));
        exitButton.setBackground(Color.RED);


        footer = new JLabel("Copyright by Đặng Ngọc Tiến - 20127641", JLabel.CENTER);
        footer.setFont(new Font("Serif", Font.PLAIN, 14));
        footer.setPreferredSize(new Dimension(2000, 40));
        footer.setForeground(Color.WHITE);
        footer.setBackground(Color.LIGHT_GRAY);
        footer.setOpaque(true);


        panel.add(title, BorderLayout.LINE_START);
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


