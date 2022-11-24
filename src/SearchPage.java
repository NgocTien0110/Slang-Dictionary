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
    private JPanel panel1;
    private JLabel title;
    private JButton searchSlangButton;
    private JButton searchDefinitionButton;
    private JButton historyButton;
    private JButton backButton;
    private JLabel footer;

    public SearchPage() {
        setTitle("SearchPage");
        setSize(500, 470);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        add(createAndShowGUI());
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public JPanel createAndShowGUI() {
        panel1 = new JPanel();

        // title
        title = new JLabel("SearchPage", JLabel.CENTER);
        title.setFont(new Font("Serif", Font.PLAIN, 28));
        title.setPreferredSize(new Dimension(2000, 100));
        title.setForeground(Color.BLUE);

        // body
        JPanel body = new JPanel();
        body.setLayout(new GridLayout(4, 1, 0, 10));

        searchSlangButton = new JButton("Search slang");
        searchSlangButton.setPreferredSize(new Dimension(200, 60));
        body.add(searchSlangButton);

        searchDefinitionButton = new JButton("Search definition");
        searchDefinitionButton.setPreferredSize(new Dimension(200, 60));
        body.add(searchDefinitionButton);

//        historyButton = new JButton("History");
//        historyButton.setPreferredSize(new Dimension(200, 60));
//        body.add(historyButton);

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

        panel1.add(title, BorderLayout.LINE_START);
        panel1.add(body, BorderLayout.CENTER);
        panel1.add(footer, BorderLayout.PAGE_END);
        return panel1;
    }


    public void actionPerformed(ActionEvent e) {
//        if(e.getSource() == searchSlangButton) {
//            new SearchSlangPage();
//        }
//        if(e.getSource() == searchDefinitionButton) {
//            new SearchDefinitionPage();
//        }
//        if(e.getSource() == historyButton) {
//            new HistoryPage();
//        }
        if(e.getSource() == backButton) {
            System.out.println("Back Home");
            Home home =  new Home();
            home.setVisible(true);
            this.setVisible(false);

        }
    }

    public static void main(String[] args) {
        new SearchPage();
    }
}
