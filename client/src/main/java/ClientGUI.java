import javax.security.auth.callback.Callback;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class ClientGUI extends JFrame {
    private JTextArea textArea = new JTextArea();
    private JPanel chatPanel = new JPanel();
    private JScrollPane js = new JScrollPane(textArea, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
    private JTextField textInput = new JTextField();
    private JTextArea clientInformation = new JTextArea();
    private JScrollPane jsClient = new JScrollPane(clientInformation, JScrollPane.VERTICAL_SCROLLBAR_NEVER, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
    private JLabel textInputLabel = new JLabel("Your message: ");
    private JPanel loginPanel = new JPanel();
    private final JButton sendButton = new JButton("Send");
    private final ActionListener listener = e -> {
        String message = textInput.getText();
        if (!message.isEmpty()) {
            this.clientNetwork.sendMessage(message);
            textInput.setText("");
        }
    };


    private ClientNetwork clientNetwork;

    public ClientGUI() {
        this.clientNetwork = new ClientNetwork();
//        this.clientNetwork.setCallOnMsgRecieved(new Callback<String>() {
//            @Override
//            public void callback(String message){
//                textArea.append(message);
//            }
//        });
        setCallBacks();
        setMainFrame();
        this.clientNetwork.connect();
        initilizeChatPanel();
        initilizeLoginJPanel();
        this.setVisible(true);
    }

    private void initilizeChatPanel() {
        textArea.setEditable(false);
        clientInformation.setEditable(false);
        chatPanel.setBackground(Color.WHITE);
        chatPanel.setPreferredSize(new Dimension(490, 490));
        js.setPreferredSize(new Dimension(450, 350));
        jsClient.setPreferredSize(new Dimension(450, 35));
        chatPanel.add(jsClient);
        chatPanel.add(js);
        textInput.setPreferredSize(new Dimension(150, 25));
        chatPanel.add(textInputLabel);
        chatPanel.add(textInput);

        textInput.addActionListener(listener);
        sendButton.addActionListener(listener);
        chatPanel.add(sendButton);
        chatPanel.setVisible(false);
        this.add(chatPanel);
    }

    private void setMainFrame() {
        this.setTitle("Chat");
        this.setSize(500, 500);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.getContentPane().setLayout(new FlowLayout());
        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent event) {
                clientNetwork.sendMessage("/end");
                super.windowClosing(event);
            }
        });
    }

    private void initilizeLoginJPanel() {
        JPanel loginPanel = new JPanel();
        loginPanel.setBackground(Color.white);
        loginPanel.setLayout(new FlowLayout(FlowLayout.RIGHT));
        loginPanel.setPreferredSize(new Dimension(300, 150));
        loginPanel.setBorder(BorderFactory.createTitledBorder("Authorization"));
        JTextField login = new JTextField();
        JLabel loginLabel = new JLabel("Your connection identifier: ");
        JLabel passwordLabel = new JLabel("Your password: ");
        JPasswordField password = new JPasswordField();
        login.setPreferredSize(new Dimension(100, 25));
        password.setPreferredSize(new Dimension(100, 25));
        loginPanel.add(loginLabel);
        loginPanel.add(login);
        loginPanel.add(passwordLabel);
        loginPanel.add(password);
        JPanel buttonPanel = new JPanel();
        buttonPanel.setPreferredSize(new Dimension(280, 35));
        buttonPanel.setBackground(Color.white);
        JButton submitButton = new JButton("Submit");
        buttonPanel.add(submitButton);
        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                clientNetwork.sendMessage("/auth " + login.getText() + " " + String.valueOf(password.getPassword()));
                login.setText("");
                password.setText("");
            }
        });
        loginPanel.add(buttonPanel);
        loginPanel.setVisible(true);
        this.add(loginPanel);
    }

    private void setCallBacks() {
        this.clientNetwork.setCallOnMsgRecieved(message -> textArea.append(message + "\n"));
        this.clientNetwork.setCallOnChangeClientList(clientsList -> clientInformation.setText(clientsList));
        this.clientNetwork.setCallOnAuth(s -> {
            loginPanel.setVisible(false);
            chatPanel.setVisible(true);
        });
        this.clientNetwork.setCallOnError(message -> JOptionPane.showMessageDialog(null, message, "We have a problem", JOptionPane.ERROR_MESSAGE));

    }
}
