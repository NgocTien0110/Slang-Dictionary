import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

/**
 * PACKAGE_NAME
 * Create by Đặng Ngọc Tiến
 * Date 11/26/2022 - 12:24 PM
 * Description: Detele page
 */
public class DeletePage extends JFrame implements ActionListener {
    private JPanel panel;
    private JLabel title, footer;
    private JTextField input;
    private JButton deleteButton, backButton;

    DeletePage() {
        setTitle("Delete");
        setSize(500, 280);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        add(createAndShowGUI());
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public JPanel createAndShowGUI() {
        panel = new JPanel();

        // title
        title = new JLabel("Delete", JLabel.CENTER);
        title.setFont(new Font("Serif", Font.PLAIN, 28));
        title.setPreferredSize(new Dimension(2000, 100));
        title.setForeground(Color.BLUE);

        // body
        JPanel body = new JPanel();
        body.setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        c.fill = GridBagConstraints.HORIZONTAL;
        c.insets = new Insets(0, 10, 10, 10);

        c.gridx = 0;
        c.gridy = 0;
        JLabel inputLabel = new JLabel("Input slang: ");
        body.add(inputLabel, c);

        c.gridx = 1;
        c.gridy = 0;
        input = new JTextField();
        input.setPreferredSize(new Dimension(200, 20));
        body.add(input, c);

        c.gridx = 0;
        c.gridy = 1;
        deleteButton = new JButton("Delete");
        deleteButton.addActionListener(this);
        body.add(deleteButton, c);

        c.gridx = 1;
        c.gridy = 1;
        backButton = new JButton("Back");
        backButton.addActionListener(this);
        body.add(backButton, c);


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

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == deleteButton) {
            String slang = input.getText();
            if (slang.equals("")) {
                JOptionPane.showMessageDialog(null, "Please input a slang word");
            } else {
                if (Main.slangWordList.searchSlangWord(slang) != null) {
                    int confirm = JOptionPane.showConfirmDialog(null, "Are you sure to delete this slang word?", "Confirm", JOptionPane.YES_NO_OPTION);
                    if (confirm == JOptionPane.YES_OPTION) {
                        Main.slangWordList.deleteSlangWord(slang);
                        JOptionPane.showMessageDialog(null, "Delete successfully");
                        FileManager.saveFile();
                        input.setText("");
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Slang word not found");
                }
            }
        } else if (e.getSource() == backButton) {
            this.dispose();
            new ManagePage();
        }
    }

    public static void main(String[] args) {
        new DeletePage();
    }

}
