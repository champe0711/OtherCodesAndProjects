/*
The Server Class

@author Chris
 */

package messenger;

import java.awt.event.*;
import java.io.*;
import java.net.*;
import java.util.*;
import java.awt.*;
import javax.swing.*;

public class Server extends JFrame implements ActionListener {

    private JTextField jtfMessageToSend = new JTextField();
    private JTextArea jtaMessageReceived = new JTextArea();

    private JButton btnSend = new JButton("Send");
    private JButton btnreset = new JButton("reset");
    private ObjectInputStream fromClient;
    private ObjectOutputStream toClient;

    /**
     * creates a new instance of ServerAndClient.
     */
    public Server() {

        JPanel p = new JPanel();
        p.setLayout(new BorderLayout());
        p.add(new JLabel("Message to send: "), BorderLayout.WEST);
        btnSend.addActionListener(this);
        btnreset.addActionListener(this);
        btnSend.setMnemonic('s');
        p.add(btnSend, BorderLayout.EAST);
        p.add(btnreset, BorderLayout.SOUTH);
        p.add(jtfMessageToSend, BorderLayout.CENTER);
        jtfMessageToSend.setHorizontalAlignment(JTextField.LEFT);
        jtaMessageReceived.setEditable(false);

        getContentPane().setLayout(new BorderLayout());
        getContentPane().add(p, BorderLayout.SOUTH);
        getContentPane().add(new JScrollPane(jtaMessageReceived), BorderLayout.CENTER);

        jtfMessageToSend.addActionListener(this);

        setTitle("SERVER");
        setSize(500, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);

        try {
            ServerSocket serverSocket = new ServerSocket(4242);
            System.out.println("Server is online");
            jtaMessageReceived.append(">> Server started at " + new Date() + "\n");

            Socket socket = serverSocket.accept(); // accept connections

            InetAddress inetAddress = socket.getInetAddress(); // used to get host information

            /* Get host IP and hostname and display on the window */
            jtaMessageReceived.append("** Client connected to the server! **\n"
                    + "<< Client's host name is: " + inetAddress.getHostName() + "\n"
                    + "<< Client's IP Address is: " + inetAddress.getHostAddress() + "\n");
            
            toClient = new ObjectOutputStream(socket.getOutputStream());

            fromClient = new ObjectInputStream(socket.getInputStream());

            RichMessage messageReceived = null;

            while (true) {
                messageReceived = (RichMessage) fromClient.readObject();

                processMessage(messageReceived);
                // toClient.writeUTF(messageReceived);

            }
        } catch (java.net.SocketException e) {
            jtaMessageReceived.append("\n\n\n*** Client Disconnected ***");
        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }

    /**
     * Process message.
     *
     * @param messageReceived the message received
     */
    public void processMessage(RichMessage messageReceived) {
        try {
            if (messageReceived.getMessage().equals("+kill_server")) {
                System.exit(0);
            }
            jtaMessageReceived.append("Client : " + messageReceived.getMessage() + " on" + messageReceived.getDate() + "\n");

        } catch (Exception e) {
        }
    }

    /* (non-Javadoc)
     * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
     */
    public void actionPerformed(ActionEvent e) {
//        String actionCommand = e.getActionCommand();

        if (e.getSource() == btnreset) {
            jtaMessageReceived.setText("");
        } else if (e.getSource() instanceof JTextField || e.getSource() == btnSend) {
            try {
                String txt = jtfMessageToSend.getText();
                Date current = new Date();
                RichMessage richMess = new RichMessage(current.toString(), txt);

                toClient.writeObject(richMess);
                toClient.flush();

                jtfMessageToSend.setText("");

                //  String messageToDisplay = fromClient.readUTF();
                jtaMessageReceived.append(txt + "\n");

            } catch (IOException ex) {
                System.err.println(ex);
            }
        }

    }
}
