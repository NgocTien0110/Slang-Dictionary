import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

/**
 * PACKAGE_NAME
 * Create by Đặng Ngọc Tiến
 * Date 11/25/2022 - 5:04 PM
 * Description: History search page
 */
public class HistorySearchPage extends JFrame implements ActionListener {
    JPanel historySearchPanel;
    JTable historySearchTable;
    JScrollPane historySearchScrollPane;
    JButton deleteButton, backButton;
    String [] columnNames = {"No", "Time", "Keyword", "Slang", "Definition"};
    JLabel footer;

    public HistorySearchPage() {
        this.setTitle("History search");
        this.setSize(800, 425);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.add(createAndShowGUI());
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }

    private JPanel createAndShowGUI() {
        historySearchPanel = new JPanel();
        historySearchPanel.setLayout(new BorderLayout());

        // title
        JLabel title = new JLabel("History search", JLabel.CENTER);
        title.setFont(new Font("Serif", Font.PLAIN, 28));
        title.setPreferredSize(new Dimension(2000, 100));
        title.setForeground(Color.BLUE);
        historySearchPanel.add(title, BorderLayout.NORTH);

        // body
        JPanel body = new JPanel();
        body.setLayout(new BorderLayout());

        // table
        int row = 30;
        DefaultTableModel model = new DefaultTableModel(columnNames, row);
        model.setColumnIdentifiers(columnNames);
        historySearchTable = new JTable(model);
        historySearchTable.getColumnModel().getColumn(0).setPreferredWidth(40);
        historySearchTable.getColumnModel().getColumn(1).setPreferredWidth(110);
        historySearchTable.getColumnModel().getColumn(2).setPreferredWidth(90);
        historySearchTable.getColumnModel().getColumn(3).setPreferredWidth(120);
        historySearchTable.getColumnModel().getColumn(4).setPreferredWidth(310);

        loadTable();
        historySearchScrollPane = new JScrollPane(historySearchTable);
        body.add(historySearchScrollPane, BorderLayout.CENTER);

        // button
        JPanel buttonPanel = new JPanel();
        buttonPanel.setBorder(BorderFactory.createEmptyBorder(10, 30, 10, 30));
        buttonPanel.setLayout(new GridLayout(1, 2, 60, 0));

        deleteButton = new JButton("Delete");
        deleteButton.setPreferredSize(new Dimension(50, 30));
        deleteButton.addActionListener(this);
        buttonPanel.add(deleteButton);

        backButton = new JButton("Back");
        backButton.setPreferredSize(new Dimension(50, 30));
        backButton.addActionListener(this);
        buttonPanel.add(backButton);

        body.add(buttonPanel, BorderLayout.SOUTH);
        historySearchPanel.add(body, BorderLayout.CENTER);

        // footer
        footer = new JLabel("Copyright by Đặng Ngọc Tiến - 20127641", JLabel.CENTER);
        footer.setFont(new Font("Serif", Font.PLAIN, 14));
        footer.setPreferredSize(new Dimension(2000, 40));
        footer.setForeground(Color.WHITE);
        footer.setBackground(Color.LIGHT_GRAY);
        footer.setOpaque(true);
        historySearchPanel.add(footer, BorderLayout.SOUTH);

        return historySearchPanel;
    }

    public void loadTable() {
        FileManager.loadHistory();
        int n = Main.historySearchList.size();
        for (int i = 0; i < n; i++) {
            historySearchTable.setValueAt(i + 1, i, 0);
            historySearchTable.setValueAt(Main.historySearchList.get(i).getTime(), i, 1);
            historySearchTable.setValueAt(Main.historySearchList.get(i).getKeyword(), i, 2);
            historySearchTable.setValueAt(Main.historySearchList.get(i).getSlang(), i, 3);
            historySearchTable.setValueAt(Main.historySearchList.get(i).getDefinition(), i, 4);
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == backButton) {
            System.out.println("Back");
            dispose();
            new SearchPage();
        }
        if (e.getSource() == deleteButton) {
            int option = JOptionPane.showConfirmDialog(null, "Do you want to clear history?", "Confirm", JOptionPane.YES_NO_OPTION);
            if (option == 0) {
                DefaultTableModel mode = (DefaultTableModel) historySearchTable.getModel();
                mode.setRowCount(0);
                FileManager.resetHistory();
                JOptionPane.showMessageDialog(null, "Delete successfully!", "Notification", JOptionPane.INFORMATION_MESSAGE);
            }
        }
    }

    public static void main(String[] args) {
        new HistorySearchPage();
    }
}
