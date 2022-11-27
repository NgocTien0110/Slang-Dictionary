import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/**
 * PACKAGE_NAME
 * Create by Đặng Ngọc Tiến
 * Date 11/25/2022 - 10:35 PM
 * Description: Manage page
 */
public class ManagePage extends JFrame implements ActionListener {
    private JPanel ManagePage;
    private JLabel title, footer;
    private JTable listSlang;
    private JButton addButton, editButton, deleteButton, resetButton, backButton;
    private JScrollPane scrollPane;
    private String[] columnNames = {"No", "Slang", "Definition"};

    public ManagePage() {
        setTitle("Manage");
        setSize(800, 470);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        add(createAndShowGUI());
        setLocationRelativeTo(null);
        setVisible(true);
    }

    private JPanel createAndShowGUI() {
        ManagePage = new JPanel();
        ManagePage.setLayout(new BorderLayout());

        // title
        title = new JLabel("Manage list of slang words", JLabel.CENTER);
        title.setFont(new Font("Serif", Font.PLAIN, 28));
        title.setPreferredSize(new Dimension(2000, 100));
        title.setForeground(Color.BLUE);

        // body
        JPanel body = new JPanel();
        body.setLayout(new BorderLayout());

        // list slang
        int row = 20;
        DefaultTableModel model = new DefaultTableModel(columnNames, row);
        model.setColumnIdentifiers(columnNames);
        listSlang = new JTable(model);
        loadListSlang();
        listSlang.setFillsViewportHeight(true);
        listSlang.getColumnModel().getColumn(0).setPreferredWidth(40);
        listSlang.getColumnModel().getColumn(1).setPreferredWidth(260);
        listSlang.getColumnModel().getColumn(2).setPreferredWidth(500);

        JScrollPane scrollPane = new JScrollPane(listSlang);
        body.add(scrollPane, BorderLayout.CENTER);

        // button
        JPanel button = new JPanel();
        button.setBorder(BorderFactory.createEmptyBorder(20, 10, 20, 10));
        button.setLayout(new GridLayout(1, 5, 10, 0));

        addButton = new JButton("Add");
        addButton.addActionListener(this);
        button.add(addButton);

        editButton = new JButton("Edit");
        editButton.addActionListener(this);
        button.add(editButton);

        deleteButton = new JButton("Delete");
        deleteButton.addActionListener(this);
        button.add(deleteButton);

        resetButton = new JButton("Reset");
        resetButton.addActionListener(this);
        button.add(resetButton);

        backButton = new JButton("Back");
        backButton.addActionListener(this);
        button.add(backButton);

        body.add(button, BorderLayout.SOUTH);

        // footer
        footer = new JLabel("Copyright by Đặng Ngọc Tiến - 20127641", JLabel.CENTER);
        footer.setFont(new Font("Serif", Font.PLAIN, 14));
        footer.setPreferredSize(new Dimension(2000, 40));
        footer.setForeground(Color.WHITE);
        footer.setBackground(Color.LIGHT_GRAY);
        footer.setOpaque(true);

        ManagePage.add(title, BorderLayout.NORTH);
        ManagePage.add(body, BorderLayout.CENTER);
        ManagePage.add(footer, BorderLayout.SOUTH);

        return ManagePage;
    }

    public void loadListSlang() {
        int n = Main.slangWordList.getLength();
        String[] columnNames = {"No", "Slang", "Definition"};
        String[][] data = new String[n][3];
        Iterator iterator = Main.slangWordList.getListHashMap().entrySet().iterator();
        int i = 0;
        while (iterator.hasNext()) {
            i++;
            String[] row = new String[3];
            Map.Entry pair = (Map.Entry) iterator.next();
            row[0] = String.valueOf(i);
            row[1] = pair.getKey().toString();
            String definition = "";
            List<String> listDefinition = (List<String>) pair.getValue();
            for (String s : listDefinition) {
                definition += s + ", ";
            }
            row[2] = definition;
            data[i - 1] = row;
        }
        listSlang = new JTable(data, columnNames);
        listSlang.setModel(new DefaultTableModel(data, columnNames));
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == addButton) {
            AddPage addPage = new AddPage();
            this.dispose();
        }
        if(e.getSource() == editButton) {
            EditPage editPage = new EditPage();
            editPage.setVisible(true);
            this.dispose();
        }
        if(e.getSource() == deleteButton) {
            DeletePage deletePage = new DeletePage();
            deletePage.setVisible(true);
            this.dispose();
        }
        if(e.getSource() == resetButton) {
            int option = JOptionPane.showConfirmDialog(null, "Are you sure you want to reset?", "Reset", JOptionPane.YES_NO_OPTION);
            if(option == JOptionPane.YES_OPTION) {
                Main.slangWordList = FileManager.loadFile(2);
                FileManager.saveFile();
                JOptionPane.showMessageDialog(null, "Reset successfully!");
                this.dispose();
                new ManagePage();
            }
        }
        if(e.getSource() == backButton) {
            System.out.println("HOME PAGE");
            this.dispose();
            new Home();
        }

    }

    public static void main(String[] args) {
        new ManagePage();
    }
}