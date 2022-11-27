import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

/**
 * PACKAGE_NAME
 * Create by Đặng Ngọc Tiến
 * Date 11/27/2022 - 2:38 PM
 * Description: Game find slang page
 */
public class GameFindSlangPage extends JFrame implements ActionListener {
    private JButton answer1, answer2, answer3, answer4;
    private JButton nextButton, backButton;
    private JLabel question;
    private JLabel title, footer;
    public static  int ansOfQuestion;

    public GameFindSlangPage() {
        setTitle("Game find slang");
        setSize(900, 380);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        add(createAndShowGUI());
        setLocationRelativeTo(null);
        setVisible(true);
    }

    private JPanel createAndShowGUI() {
        Set<Object> slangSet = createQuestion();
        JPanel panel1 = new JPanel();

        // title
        title = new JLabel("Funny Question with slang word?", JLabel.CENTER);
        title.setFont(new Font("Serif", Font.PLAIN, 28));
        title.setPreferredSize(new Dimension(2000, 100));
        title.setForeground(Color.BLUE);

        // body
        JPanel body = new JPanel();
        body.setLayout(new BorderLayout());

        // question
        question = new JLabel();
        String x = createSlang(slangSet);
        question.setText("What is the meaning of " + x + "?");
        question.setBackground(Color.WHITE);

        // answer
        ArrayList<String> answerList = convertArrayString(slangSet);
        JPanel answer = new JPanel();
        answer.setLayout(new GridLayout(2, 2, 10, 10));
        answer.setBorder(BorderFactory.createEmptyBorder(20, 0, 30, 0));

        answer1 = new JButton(answerList.get(0));
        answer1.setPreferredSize(new Dimension(400, 40));
        answer1.setBackground(Color.WHITE);
        answer1.addActionListener(this);

        answer.add(answer1);

        answer2 = new JButton(answerList.get(1));
        answer2.setPreferredSize(new Dimension(400, 40));
        answer2.setBackground(Color.WHITE);
        answer2.addActionListener(this);

        answer.add(answer2);

        answer3 = new JButton(answerList.get(2));
        answer3.setPreferredSize(new Dimension(400, 40));
        answer3.setBackground(Color.WHITE);
        answer3.addActionListener(this);

        answer.add(answer3);

        answer4 = new JButton(answerList.get(3));
        answer4.setPreferredSize(new Dimension(400, 40));
        answer4.setBackground(Color.WHITE);
        answer4.addActionListener(this);

        answer.add(answer4);

        body.add(question, BorderLayout.NORTH);
        body.add(answer, BorderLayout.CENTER);

        // btn
        JPanel btn = new JPanel();
        btn.setLayout(new GridLayout(1, 2, 10, 10));

        nextButton = new JButton("Next");
        nextButton.addActionListener(this);

        backButton = new JButton("Exit");
        backButton.addActionListener(this);

        btn.add(backButton);
        btn.add(nextButton);
        body.add(btn, BorderLayout.SOUTH);

        // footer
        footer = new JLabel("Copyright by Đặng Ngọc Tiến - 20127641", JLabel.CENTER);
        footer.setFont(new Font("Serif", Font.PLAIN, 14));
        footer.setPreferredSize(new Dimension(2000, 40));
        footer.setForeground(Color.WHITE);
        footer.setBackground(Color.LIGHT_GRAY);
        footer.setOpaque(true);


        panel1.add(title);
        panel1.add(body);
        panel1.add(footer);

        return panel1;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == backButton) {
            dispose();
            new GamePage();
        }
        if(e.getSource() == answer1) {
            if(ansOfQuestion == 0) {
                answer1.setBackground(Color.GREEN);
            } else {
                answer1.setBackground(Color.RED);

                if(ansOfQuestion == 1) {
                    answer2.setBackground(Color.GREEN);

                } else if(ansOfQuestion == 2) {
                    answer3.setBackground(Color.GREEN);
                } else {
                    answer4.setBackground(Color.GREEN);
                }
            }
            answer2.setEnabled(false);
            answer3.setEnabled(false);
            answer4.setEnabled(false);
        } else if(e.getSource() == answer2) {
            if(ansOfQuestion == 1) {
                answer2.setBackground(Color.GREEN);
            } else {
                answer2.setBackground(Color.RED);

                if(ansOfQuestion == 0) {
                    answer1.setBackground(Color.GREEN);

                } else if(ansOfQuestion == 2) {
                    answer3.setBackground(Color.GREEN);
                } else {
                    answer4.setBackground(Color.GREEN);
                }
            }
            answer1.setEnabled(false);
            answer3.setEnabled(false);
            answer4.setEnabled(false);
        } else if(e.getSource() == answer3) {
            if(ansOfQuestion == 2) {
                answer3.setBackground(Color.GREEN);
            } else {
                answer3.setBackground(Color.RED);

                if(ansOfQuestion == 0) {
                    answer1.setBackground(Color.GREEN);

                } else if(ansOfQuestion == 1) {
                    answer2.setBackground(Color.GREEN);
                } else {
                    answer4.setBackground(Color.GREEN);
                }
            }
            answer1.setEnabled(false);
            answer2.setEnabled(false);
            answer4.setEnabled(false);
        } else if(e.getSource() == answer4) {
            if (ansOfQuestion == 3) {
                answer4.setBackground(Color.GREEN);
            } else {
                answer4.setBackground(Color.RED);

                if(ansOfQuestion == 0) {
                    answer1.setBackground(Color.GREEN);

                } else if(ansOfQuestion == 1) {
                    answer2.setBackground(Color.GREEN);
                } else {
                    answer3.setBackground(Color.GREEN);
                }
            }
            answer1.setEnabled(false);
            answer2.setEnabled(false);
            answer3.setEnabled(false);
        } else if (e.getSource() == nextButton) {
            setDefaultButton();
            setLabel();
        }
    }

    public void setDefaultButton(){
        answer1.setEnabled(true);
        answer2.setEnabled(true);
        answer3.setEnabled(true);
        answer4.setEnabled(true);
        answer1.setBackground(Color.white);
        answer2.setBackground(Color.white);
        answer3.setBackground(Color.white);
        answer4.setBackground(Color.white);
    }
    public void setLabel(){
        Set<Object> obj = createQuestion();
        ArrayList<String> listAns = convertArrayString(obj);

        String x = createSlang(obj);
        question.setText("What is the definition of slang " + x + "? ");
        answer1.setText(listAns.get(0));
        answer2.setText(listAns.get(1));
        answer3.setText(listAns.get(2));
        answer4.setText(listAns.get(3));
    }

    private Set<Object> createQuestion() {
        Set<Object> ansObject = new HashSet<>();
        while(ansObject.size() != 4){
            String randomAns = Main.slangWordList.randomSlangWordString();
            ArrayList<String> A = Main.slangWordList.getDefinition2(randomAns);
            ansObject.add(A);
        }
        return ansObject;
    }

    public String createSlang(Set<Object> ansObject) {
        Iterator<Object> k = ansObject.iterator();
        Random rand = new Random();
        ansOfQuestion = rand.nextInt(4);
        System.out.println(ansOfQuestion);
        int count = 0;
        String slang = null;
        while (count != 4 && k.hasNext()) {
            if (ansOfQuestion == count) {
                ArrayList<String> aaa = (ArrayList<String>) k.next();
                slang = Main.slangWordList.getSlangWord(aaa);
                break;
            }
            k.next();
            ++count;
        }
        System.out.println("slang: " + slang);
        return slang;
    }

    public ArrayList<String> convertArrayString(Set<Object> ansObject){
        Iterator<Object> i = ansObject.iterator();
        ArrayList<String> ansQuestion = new ArrayList<>();
        while(i.hasNext()){
            ArrayList<String> b = (ArrayList<String>) i.next();
            ansQuestion.add(String.join(" , ", b));
        }
        return ansQuestion;
    }

    public static void main(String[] args) {
        new GameFindSlangPage();
    }
}
