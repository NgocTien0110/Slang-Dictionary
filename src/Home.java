import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * PACKAGE_NAME
 * Create by Đặng Ngọc Tiến
 * Date 11/19/2022 - 3:29 PM
 * Description: Home page
 */
public class Home extends JFrame implements ActionListener {
    private JPanel panel;
    private JLabel title;
    private JLabel randomSlang;
    private JButton randomButton;
    private JButton searchButton;
    private JButton gameButton;
    private JButton manageButton;
    private JButton exitButton;
    private JLabel footer;

    public Home() {
        setTitle("Home");
        setSize(500, 470);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        add(createAndShowGUI());
        setLocationRelativeTo(null);
//        pack();
        setVisible(true);
    }

    public JPanel createAndShowGUI() {
        panel = new JPanel();
        panel.setLayout(new BorderLayout());

        // header
        JPanel header = new JPanel();
        header.setLayout(new BorderLayout());

        // title
        title = new JLabel("Slang Word Dictionary", JLabel.CENTER);
        title.setFont(new Font("Serif", Font.PLAIN, 28));
        title.setPreferredSize(new Dimension(2000, 100));

        // random button
        System.out.println(Main.slangWordList.randomSlangWord());
        randomSlang = new JLabel(Main.slangWordList.randomSlangWord(), JLabel.CENTER);
        randomSlang.setFont(new Font("Serif", Font.PLAIN, 14));


        header.add(title, BorderLayout.NORTH);
        header.add(randomSlang, BorderLayout.CENTER);


        // body
        JPanel body = new JPanel();
        body.setLayout(new GridLayout(4, 1, 0, 10));
        body.setBorder(BorderFactory.createEmptyBorder(20, 100, 20, 100));

        searchButton = new JButton("Search");
        searchButton.setPreferredSize(new Dimension(100, 50));
        searchButton.addActionListener(this);
        body.add(searchButton);

        gameButton = new JButton("Game");
        gameButton.setPreferredSize(new Dimension(100, 50));
        gameButton.addActionListener(this);
        body.add(gameButton);

        manageButton = new JButton("Manage");
        manageButton.setPreferredSize(new Dimension(100, 50));
        manageButton.addActionListener(this);
        body.add(manageButton);

        exitButton = new JButton("Exit");
        exitButton.setPreferredSize(new Dimension(100, 50));
        exitButton.setBackground(Color.RED);
        exitButton.setForeground(Color.WHITE);
        exitButton.addActionListener(this);
        body.add(exitButton);

        footer = new JLabel("Copyright by Đặng Ngọc Tiến - 20127641", JLabel.CENTER);
        footer.setFont(new Font("Serif", Font.PLAIN, 14));
        footer.setPreferredSize(new Dimension(2000, 40));
        footer.setForeground(Color.WHITE);
        footer.setBackground(Color.LIGHT_GRAY);
        footer.setOpaque(true);


        panel.add(header, BorderLayout.NORTH);
        panel.add(body, BorderLayout.CENTER);
        panel.add(footer, BorderLayout.SOUTH);
        return panel;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource().equals(searchButton)) {
            System.out.println("SearchPage");
            SearchPage search = new SearchPage();
            search.setVisible(true);
            this.setVisible(false);
        }
        if (e.getSource() == gameButton) {
            System.out.println("Game");
            GamePage game = new GamePage();
            game.setVisible(true);
            this.setVisible(false);
        }
        if (e.getSource() == manageButton) {
            ManagePage manage = new ManagePage();
            manage.setVisible(true);
            this.setVisible(false);
        }
        if (e.getSource() == exitButton) {
            System.exit(0);
        }
    }


}
