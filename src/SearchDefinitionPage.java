import javax.swing.*;
import javax.swing.plaf.basic.DefaultMenuLayout;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
        JFrame frame = new JFrame("Search definition");
        frame.setSize(500, 425);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(createAndShowGUI());
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
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
        searchLabel = new JLabel("Search definition: ");
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
        resultTable.setPreferredScrollableViewportSize(new Dimension(450, 95));
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
        panel.add(footer);

        return panel;
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == searchButton) {
            String searchWord = searchTextField.getText();
            if (searchWord.equals("")) {
                JOptionPane.showMessageDialog(null, "Please enter a word to search");
            } else {
                ArrayList<String> result = Main.slangWordList.searchDefinition(searchWord);
                if (result == null) {
                    JOptionPane.showMessageDialog(null, "No result found");
                } else {
                    DefaultTableModel model = (DefaultTableModel) resultTable.getModel();
                    model.setRowCount(0);
                    for (int i = 0; i < result.size(); i++) {
                        model.addRow(new Object[]{i + 1, result.get(i), Main.slangWordList.getDefinitionString(result.get(i))});
                    }
                }
            }
        } else if (e.getSource() == backButton) {
            this.dispose();
            new SearchPage();
        }
    }

    public static void main(String[] args) {
        new SearchDefinitionPage();
    }
}
