import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

/**
 * PACKAGE_NAME
 * Create by Đặng Ngọc Tiến
 * Date 11/24/2022 - 8:53 PM
 * Description: Search by slang word page
 */
public class SearchSlangPage extends JFrame implements ActionListener {
    private JPanel panel;
    private JLabel searchLabel, resultLabel;
    private JTextField searchTextField;
    private JTextArea resultTextArea;
    private JButton searchButton, backButton;
    private JLabel footer;

    public SearchSlangPage() {
        JFrame frame = new JFrame("Search slang word");
        frame.setSize(500, 350);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(createAndShowGUI());
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    public JPanel createAndShowGUI(){
        panel = new JPanel();
        // title
        JLabel title = new JLabel("Search slang word", JLabel.CENTER);
        title.setFont(new Font("Serif", Font.PLAIN, 28));
        title.setPreferredSize(new Dimension(2000, 100));
        title.setForeground(Color.BLUE);

        // body
        JPanel body = new JPanel();
        body.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(20, 10, 0, 10);

        gbc.gridx = 0;
        gbc.gridy = 0;
        searchLabel = new JLabel("Input a slang word: ");
        body.add(searchLabel, gbc);

        gbc.gridx = 1;
        gbc.gridy = 0;
        searchTextField = new JTextField();
        searchTextField.setPreferredSize(new Dimension(200, 20));
        body.add(searchTextField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        resultLabel = new JLabel("Definition: ");
        body.add(resultLabel, gbc);

        gbc.gridx = 1;
        gbc.gridy = 1;
        resultTextArea = new JTextArea(2, 20);
        resultTextArea.setEditable(false);
        resultTextArea.setLineWrap(true);
        resultTextArea.setWrapStyleWord(true);
        resultTextArea.setOpaque(false);
        body.add(resultTextArea, gbc);

        gbc.gridx = 0;
        gbc.gridy = 2;
        searchButton = new JButton("Search");
        searchButton.addActionListener(this);
        body.add(searchButton, gbc);

        gbc.gridx = 1;
        gbc.gridy = 2;
        backButton = new JButton("Back");
        backButton.addActionListener(this);
        body.add(backButton, gbc);


        // footer
        footer = new JLabel("Copyright by Đặng Ngọc Tiến - 20127641", JLabel.CENTER);
        footer.setFont(new Font("Serif", Font.PLAIN, 14));
        footer.setPreferredSize(new Dimension(2000, 40));
        footer.setForeground(Color.WHITE);
        footer.setBackground(Color.LIGHT_GRAY);
        footer.setOpaque(true);

        panel.add(title, BorderLayout.NORTH);
        panel.add(body, BorderLayout.CENTER);
        panel.add(footer, BorderLayout.SOUTH);

        return panel;
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == backButton) {
            System.out.println("Back Search Page");
            dispose();
            new SearchPage();
        }
        if(e.getSource() == searchButton){
            System.out.println("Search");
            String slang = searchTextField.getText();
            List<String> definition = new ArrayList<>();
            definition = Main.slangWordList.searchSlangWord(slang);
            if(definition.size() == 0){
                resultTextArea.setText("Not found");
            }else{
                String result = "";
                for (String s : definition) {
                    result += s + ", ";
                }
                resultTextArea.setText(result);
            }
            System.out.println(definition);
        }
    }
}
