import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * PACKAGE_NAME
 * Create by Đặng Ngọc Tiến
 * Date 11/19/2022 - 11:44 PM
 * Description: SearchPage page
 */
public class SearchPage extends JFrame implements ActionListener {
    private JLabel title;
    private JButton searchSlangButton;
    private JButton searchDefinitionButton;
    private JButton historyButton;
    private JButton backButton;
    private JLabel footer;

    public SearchPage() {
        setTitle("Search Page");
        setSize(500, 470);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        add(createAndShowGUI());
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public JPanel createAndShowGUI() {
        JPanel panel1 = new JPanel();
        panel1.setLayout(new BorderLayout());

        // title
        title = new JLabel("Search", JLabel.CENTER);
        title.setFont(new Font("Serif", Font.PLAIN, 28));
        title.setPreferredSize(new Dimension(2000, 100));
        title.setForeground(Color.BLUE);

        // body
        JPanel body = new JPanel();
        body.setLayout(new GridLayout(4, 1, 0, 10));
        body.setBorder(BorderFactory.createEmptyBorder(20, 100, 20, 100));

        searchSlangButton = new JButton("Search by slang");
        searchSlangButton.setPreferredSize(new Dimension(200, 60));
        searchSlangButton.addActionListener(this);
        body.add(searchSlangButton);

        searchDefinitionButton = new JButton("Search by definition");
        searchDefinitionButton.setPreferredSize(new Dimension(200, 60));
        searchDefinitionButton.addActionListener(this);
        body.add(searchDefinitionButton);

        historyButton = new JButton("History");
        historyButton.setPreferredSize(new Dimension(200, 60));
        historyButton.addActionListener(this);
        body.add(historyButton);

        backButton = new JButton("Back");
        backButton.setPreferredSize(new Dimension(200, 60));
        backButton.addActionListener(this);
        body.add(backButton);


        // footer
        footer = new JLabel("Copyright by Đặng Ngọc Tiến - 20127641", JLabel.CENTER);
        footer.setFont(new Font("Serif", Font.PLAIN, 14));
        footer.setPreferredSize(new Dimension(2000, 40));
        footer.setForeground(Color.WHITE);
        footer.setBackground(Color.LIGHT_GRAY);
        footer.setOpaque(true);

        panel1.add(title, BorderLayout.NORTH);
        panel1.add(body, BorderLayout.CENTER);
        panel1.add(footer, BorderLayout.SOUTH);
        return panel1;
    }


    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == searchSlangButton) {
            System.out.println("Search slang");
            dispose();
            new SearchSlangPage();
        }
        if(e.getSource() == searchDefinitionButton) {
            System.out.println("Search definition");
            dispose();
            new SearchDefinitionPage();
        }
        if(e.getSource() == historyButton) {
            System.out.println("History");
            dispose();
            new HistorySearchPage();
        }
        if(e.getSource() == backButton) {
            System.out.println("Back Home");
            dispose();
            new Home();

        }
    }


}
