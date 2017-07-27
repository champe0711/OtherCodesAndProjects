/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package messenger;

import java.io.Serializable;

// TODO: Auto-generated Javadoc
/**
 * The Class RichMessage.
 *
 * @author Chris
 */
public class RichMessage extends Message implements Serializable {

    //Current Dat
    private String date;

    /**
     * Instantiates a new rich message.
     *
     * @param date the date
     * @param Message the message
     */
    public RichMessage(String date, String Message) {
        super(Message);
        this.date = date + "\n";
    }

    /**
     * Gets the date.
     *
     * @return the date
     */
    public String getDate() {
        return date;
    }

    /**
     * Sets the date.
     *
     * @param date the date to set
     */
    public void setDate(String date) {
        this.date = date;
    }

}
