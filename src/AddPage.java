import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;
import java.util.List;

/**
 * PACKAGE_NAME
 * Create by Đặng Ngọc Tiến
 * Date 11/26/2022 - 7:46 AM
 * Description: Add Slang word
 */
public class AddPage extends JFrame implements ActionListener {
    private JPanel panel;
    private JLabel title, footer;
    private JLabel slangLabel, definitionLabel;
    private JTextField inputSlang, inputDefinition;
    private JButton addButton, backButton;

    public AddPage(){
        this.setTitle("Add a slang word");
        this.setSize(500,340);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.add(createAndShowGUI());
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }

    public JPanel createAndShowGUI(){
        panel = new JPanel();

        //title
        title = new JLabel("Add a slang word", JLabel.CENTER);
        title.setFont(new Font("Serif", Font.PLAIN, 28));
        title.setPreferredSize(new Dimension(2000, 100));
        title.setForeground(Color.BLUE);

        //body
        JPanel body = new JPanel();
        body.setLayout(new GridBagLayout());
        body.setBorder(BorderFactory.createEmptyBorder(0,20,20,20));
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(20,10,0,10);

        gbc.gridx = 0;
        gbc.gridy = 0;
        slangLabel = new JLabel("Please enter a slang word: ");
        body.add(slangLabel, gbc);

        gbc.gridx = 1;
        gbc.gridy = 0;
        inputSlang = new JTextField();
        inputSlang.setPreferredSize(new Dimension(200, 20));
        body.add(inputSlang, gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        definitionLabel = new JLabel("Please enter a definition: ");
        body.add(definitionLabel, gbc);

        gbc.gridx = 1;
        gbc.gridy = 1;
        inputDefinition = new JTextField();
        inputDefinition.setPreferredSize(new Dimension(200, 20));
        body.add(inputDefinition, gbc);

        gbc.gridx = 0;
        gbc.gridy = 2;
        addButton = new JButton("Add");
        addButton.addActionListener(this);
        body.add(addButton, gbc);

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

    @Override
    public void actionPerformed(ActionEvent e){
        if(e.getSource() == backButton){
            System.out.println("Back Manage Page");
            this.dispose();
            new ManagePage();
        }
        if(e.getSource() == addButton) {
            String slang = inputSlang.getText();
            String defi = inputDefinition.getText();
            String data[] = defi.split(", ");
            List<String> def = new ArrayList<>();
            for (String s : data) {
                def.add(s);
            }
            if (Main.slangWordList.searchSlangWord(slang) == null) {
                Main.slangWordList.addSlangWord(slang, def);
                JOptionPane.showMessageDialog(null, "Add successfully", "Notification", JOptionPane.INFORMATION_MESSAGE);
                inputSlang.setText("");
                inputDefinition.setText("");
            }
            else {
                String [] btn = {"Duplicate", "Overwrite", "Cancel"};
                int option = JOptionPane.showOptionDialog(null, "Slang word " + slang + " has been existed!", "Notification", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.INFORMATION_MESSAGE, null, btn, 0);
                if(option == 0){
                    System.out.println("Duplicate");
                    Main.slangWordList.duplicateSlangWord(slang, def);
                    JOptionPane.showMessageDialog(null, "Duplicate successfully", "Notification", JOptionPane.INFORMATION_MESSAGE);

                } else if (option == 1) {
                    System.out.println("Overwrite");
                    Main.slangWordList.overwriteSlangWord(slang, def);
                    JOptionPane.showMessageDialog(null, "Overwrite successfully", "Notification", JOptionPane.INFORMATION_MESSAGE);
                }
                else {
                    System.out.println("Cancel");
                }
                inputSlang.setText("");
                inputDefinition.setText("");
            }
        }
    }

    public static void main(String[] args) {
        new AddPage();
    }
}
