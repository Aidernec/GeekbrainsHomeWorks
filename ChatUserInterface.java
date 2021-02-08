package level2Lesson04.homework;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ChatUserInterface extends JFrame {
    public ChatUserInterface(){
        this.setTitle("Chat");
        this.setSize(500, 500);
        this.getContentPane().setLayout(new FlowLayout());
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);

        JPanel messagesPanel = new JPanel();
        messagesPanel.setBackground(Color.white);
        messagesPanel.setLayout(new FlowLayout());
        messagesPanel.setPreferredSize(new Dimension(300, 400));
        JLabel messagesLabel = new JLabel("Все сообщения ");
        JTextPane messagesField = new JTextPane();
        messagesField.setLayout(new FlowLayout(FlowLayout.CENTER));
        messagesField.setPreferredSize(new Dimension(300, 400));
        messagesField.setEditable(false);
        messagesPanel.add(messagesLabel);
        messagesPanel.add(messagesField);
        messagesLabel.setSize(200, 200);
        messagesLabel.setVisible(true);
        messagesPanel.setVisible(true);
        this.add(messagesPanel);

        List<String> allMessages = new ArrayList<>();
        JPanel messageInput = new JPanel();
        messageInput.setBackground(Color.white);
        messageInput.setLayout(new FlowLayout());
        messageInput.setPreferredSize(new Dimension(500, 50));
        JLabel textLabel = new JLabel("Введите сообщение ");
        JTextField textInput = new JTextField();
        textInput.setPreferredSize(new Dimension(200, 25));
        messageInput.add(textLabel);
        messageInput.add(textInput);
        JButton sendMessageBtn = new JButton("Отправить");
        messageInput.add(sendMessageBtn);
        sendMessageBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    if(!textInput.getText().equals("")){
                        allMessages.add(textInput.getText());
                        messagesField.setText(allMessages.stream().collect(Collectors.joining("\n")));
                    }
                } catch (Exception exception){
                    textInput.setText("");
                }
            }
        });
        messageInput.setVisible(true);
        this.add(messageInput);

        this.setVisible(true);
    }

}
