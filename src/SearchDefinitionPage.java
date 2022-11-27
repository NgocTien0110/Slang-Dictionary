import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

/**
 * PACKAGE_NAME
 * Create by Đặng Ngọc Tiến
 * Date 11/24/2022 - 10:30 PM
 * Description: ...
 */
public class SearchDefinitionPage extends JFrame implements ActionListener {
    private JPanel panel;
    private JLabel searchLabel;
    private JTextField searchTextField;
    private JTable resultTable;
    private String[] columnNames = {"No", "Slang word", "Definition"};
    private JButton searchButton, backButton;
    private JLabel footer;

    public SearchDefinitionPage() {
        this.setTitle("Search definition");
        this.setSize(500, 410);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.add(createAndShowGUI());
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }

    public JPanel createAndShowGUI() {
        panel = new JPanel();
        // title
        JLabel title = new JLabel("Search definition", JLabel.CENTER);
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
        searchLabel = new JLabel("Search by definition: ");
        body.add(searchLabel, gbc);

        gbc.gridx = 1;
        gbc.gridy = 0;
        searchTextField = new JTextField();
        searchTextField.setPreferredSize(new Dimension(200, 20));
        body.add(searchTextField, gbc);

        int row = 20;
        DefaultTableModel model = new DefaultTableModel(columnNames, row);
        model.setColumnIdentifiers(columnNames);
        resultTable = new JTable(model);
        resultTable.setPreferredScrollableViewportSize(new Dimension(450, 90));
        resultTable.setFillsViewportHeight(true);
        JScrollPane scrollPane = new JScrollPane(resultTable);
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridwidth = 2;
        body.add(scrollPane, gbc);

        gbc.gridwidth = 1;
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

        // add to panel
        panel.add(title);
        panel.add(body);
        panel.add(footer, BorderLayout.SOUTH);

        return panel;
    }

    public String getSlangWordList(ArrayList<String> slangWordList) {
        String result = "";
        for (String slangWord : slangWordList) {
            result += slangWord + ", ";
        }
        return result;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == searchButton) {
            String searchWord = searchTextField.getText();

            DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
            LocalDateTime now = LocalDateTime.now();
            String time = dtf.format(now);
            System.out.println(time);

            if (searchWord.equals("")) {
                JOptionPane.showMessageDialog(null, "Please enter a word to search");
            } else {
                ArrayList<String> result = Main.slangWordList.searchDefinition(searchWord);
                if (result == null) {
                    HistorySearch historySearch = new HistorySearch(time, searchWord, "NOT FOUND", " " );
                    FileManager.saveHistory(historySearch);
                    JOptionPane.showMessageDialog(null, "No result found");
                } else {
                    DefaultTableModel model = (DefaultTableModel) resultTable.getModel();
                    model.setRowCount(0);
                    for (int i = 0; i < result.size(); i++) {
                        model.addRow(new Object[]{i + 1, result.get(i), Main.slangWordList.getDefinitionString(result.get(i))});
                    }
                    HistorySearch historySearch = new HistorySearch(time, searchWord, getSlangWordList(result), " " );
                    FileManager.saveHistory(historySearch);
                }
            }
        } else if (e.getSource() == backButton) {
            this.dispose();
            new SearchPage();

        }
    }


}
