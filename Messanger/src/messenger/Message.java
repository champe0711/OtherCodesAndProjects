/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package messenger;

import java.io.Serializable;

// TODO: Auto-generated Javadoc
/**
 * The Class Message.
 *
 * @author Chris
 */
public class Message implements Serializable {

    /**
     * The Message.
     */
    private String Message;

    /**
     * Instantiates a new message.
     *
     * @param Message the message
     */
    public Message(String Message) {
        this.Message = Message;
    }

    /**
     * Gets the message.
     *
     * @return the Message
     */
    public String getMessage() {
        return Message;
    }

    /**
     * Sets the message.
     *
     * @param Message the Message to set
     */
    public void setMessage(String Message) {
        this.Message = Message;
    }

}
