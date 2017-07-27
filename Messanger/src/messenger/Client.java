/*
 Client Class
 */
package messenger;

import java.awt.event.*;
import java.io.*;
import java.net.*;
import java.awt.*;
import java.util.Date;
import javax.swing.*;

public class Client extends JFrame implements ActionListener {

    //create UI
    private JTextField jtfMessageToSend = new JTextField();
    private JTextArea jtaMessageReceived = new JTextArea();
    private JButton btnSend = new JButton("Send");
    private JButton btnReset = new JButton("reset");
    private JButton SaveConv;

    //Message Streams
    private ObjectOutputStream toServer;
    private ObjectInputStream fromServer;

    /**
     * Creates a Client
     */
    public Client() {
        /**
         * Buttons Panel 
         * +------------------------+ 
         * | Save JTFMessage   Send | 
         * |     R  E  S  E  T      | 
         * +------------------------+
         */

        JPanel pButtons = new JPanel(new BorderLayout());
//        p.setLayout(new BorderLayout());

        pButtons.add(new JLabel("Message to send:"), BorderLayout.WEST);
        btnSend.addActionListener(this);
        btnSend.setMnemonic('s');

        btnReset.addActionListener(this);

        SaveConv = new JButton("Save Conversation");
        SaveConv.addActionListener(this);

        pButtons.add(btnSend, BorderLayout.EAST);
        pButtons.add(SaveConv, BorderLayout.WEST);
        pButtons.add(btnReset, BorderLayout.SOUTH);
        pButtons.add(jtfMessageToSend, BorderLayout.CENTER);

        jtfMessageToSend.setHorizontalAlignment(JTextField.LEFT);
        jtfMessageToSend.addActionListener(this);
        jtaMessageReceived.setEditable(false);


        //JFrame Attributes
        setTitle("Client Window");
        setSize(500, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);

        /**
         * This Window (Content Pane) 
         * +------------------------+ 
         * |       FTA Messages     | 
         * |     BUTTONS  PANEL     | 
         * +------------------------+
         */
        getContentPane().setLayout(new BorderLayout());
        getContentPane().add(pButtons, BorderLayout.SOUTH);
        getContentPane().add(new JScrollPane(jtaMessageReceived), BorderLayout.CENTER);

        //create try and catch for connections
        try {
            Socket connection = new Socket("localhost", 4242);

            fromServer = new ObjectInputStream(connection.getInputStream());
            toServer = new ObjectOutputStream(connection.getOutputStream());

            RichMessage messageReceived = null;

            while (true) {
                messageReceived = (RichMessage) fromServer.readObject();

                if (messageReceived.equals("+kill_server")) {
                    System.exit(0);
                }
                jtaMessageReceived.append("Server: " + messageReceived.getMessage() + "on \n" + messageReceived.getDate() + "\n");
            }

        } catch (Exception ex) {
            ex.printStackTrace();
            jtaMessageReceived.append(ex.toString());
        }

    }

    public void actionPerformed(ActionEvent e) {
        
        if (e.getSource() instanceof JTextField || e.getSource() == btnSend) {
            try {
                String txt = jtfMessageToSend.getText();
                Date current = new Date();
                RichMessage richMess = new RichMessage(current.toString(), txt);

                toServer.writeObject(richMess);
                //toServer.writeUTF("\n");
                toServer.flush();
                // JOptionPane.showMessageDialog(this,"sent");
                jtfMessageToSend.setText("");

                //String messageToDisplay = fromServer.readUTF();
                jtaMessageReceived.append(txt + " on" + current.toString() + "\n\n");

            } catch (IOException ex) {
                System.err.println(ex);
            }
        } else if (e.getSource() == btnReset) {
            jtaMessageReceived.setText("");
        } else if (e.getSource() == SaveConv) {
            try {
                JFileChooser ch = new JFileChooser("c:\\");

                ch.showSaveDialog(this);

                PrintWriter pw = new PrintWriter(ch.getSelectedFile().getPath());

                pw.print(jtaMessageReceived.getText());
                pw.flush();
                pw.close();

            } catch (IOException ex) {
                System.err.println(ex);
            }
        }
    }

}
