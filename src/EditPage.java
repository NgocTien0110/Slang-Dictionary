import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

/**
 * PACKAGE_NAME
 * Create by Đặng Ngọc Tiến
 * Date 11/26/2022 - 10:26 AM
 * Description: Edit Slang Word
 */
public class EditPage extends JFrame implements ActionListener {
    private JPanel panel;
    private JLabel title, footer;
    private JTextField inputSlang, inputDefinition;
    private JButton findButton, saveButton, backButton;

    public EditPage(){
        this.setTitle("Edit a slang word");
        this.setSize(600,350);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.add(createAndShowGUI());
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }

    public JPanel createAndShowGUI(){
        panel = new JPanel();

        //title
        title = new JLabel("Edit a slang word", JLabel.CENTER);
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
        JLabel slangLabel = new JLabel("Please enter a slang word: ");
        body.add(slangLabel, gbc);

        gbc.gridx = 1;
        gbc.gridy = 0;
        inputSlang = new JTextField();
        inputSlang.setPreferredSize(new Dimension(200, 20));
        body.add(inputSlang, gbc);

        gbc.gridx = 2;
        gbc.gridy = 0;
        findButton = new JButton("Find");
        findButton.setPreferredSize(new Dimension(80, 20));
        findButton.addActionListener(this);
        body.add(findButton, gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        JLabel definitionLabel = new JLabel("Please enter a definition: ");
        body.add(definitionLabel, gbc);

        gbc.gridx = 1;
        gbc.gridy = 1;
        inputDefinition = new JTextField();
        inputDefinition.setPreferredSize(new Dimension(200, 20));
        body.add(inputDefinition, gbc);

        gbc.gridx = 0;
        gbc.gridy = 2;
        saveButton = new JButton("Save");
        saveButton.setPreferredSize(new Dimension(100, 30));
        saveButton.addActionListener(this);
        body.add(saveButton, gbc);

        gbc.gridx = 1;
        gbc.gridy = 2;
        backButton = new JButton("Back");
        backButton.setPreferredSize(new Dimension(200, 30));
        backButton.addActionListener(this);
        body.add(backButton, gbc);

        //footer
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
        String slang = inputSlang.getText();
        List<String> definition = Main.slangWordList.searchSlangWord(slang);
        if(e.getSource() == findButton){
            if(slang.equals("")){
                JOptionPane.showMessageDialog(null, "Please enter a slang word!");
            }else{
                if(definition == null){
                    JOptionPane.showMessageDialog(null, "Slang word not found!");
                }else{
                    String def = "";
                    for(String s : definition){
                        def += s + ", ";
                    }
                    def = def.substring(0, def.length() - 2);
                    inputDefinition.setText(def);
                }
            }
        }else if(e.getSource() == saveButton){
            String newDefinition = inputDefinition.getText();

            if(slang.equals("") || newDefinition.equals("")){
                JOptionPane.showMessageDialog(null, "Please enter a slang word and definition!");
            }else{
                String data[] = newDefinition.split(",");
                List<String> newDefinitionList = new ArrayList<>();
                for(String s : data){
                    newDefinitionList.add(s);
                }
                Main.slangWordList.editSlangWord(slang, newDefinitionList);
                FileManager.saveFile();
                JOptionPane.showMessageDialog(null, "Edit successfully!");
                inputSlang.setText("");
                inputDefinition.setText("");
            }
        }else if(e.getSource() == backButton){
            this.dispose();
            new ManagePage();
        }
    }

    public static void main(String[] args) {
        new EditPage();
    }
}
