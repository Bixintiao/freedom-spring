package com.hzy.modules.oxm.entity;

import java.util.Hashtable;

/**
 * project freedom-spring
 * @Author hzy
 * @Date 2019/3/29 15:43
 * @Description version 1.0
 *
 * No Constructor, No Problem!
 * Castor XML automatically supports these types of classes if they have a specific method
 */
public class Color implements java.io.Serializable {

    public static final int RED_TYPE = 0;

    public static final Color RED = new Color(RED_TYPE, "red");

    public static final int GREEN_TYPE = 1;

    public static final Color GREEN = new Color(GREEN_TYPE, "green");

    public static final int BLUE_TYPE = 2;

    public static final Color BLUE = new Color(BLUE_TYPE, "blue");

    private static java.util.Hashtable _memberTable = init();

    private int type = -1;

    private java.lang.String stringValue = null;


    private Color(int type, java.lang.String value) {
        super();
        this.type = type;
        this.stringValue = value;
    } //-- test.types.Color(int, java.lang.String)


    public static java.util.Enumeration enumerate()
    {
        return _memberTable.elements();
    } //-- java.util.Enumeration enumerate()

    public int getType()
    {
        return this.type;
    } //-- int getType()

    private static java.util.Hashtable init()
    {
        Hashtable members = new Hashtable();
        members.put("red", RED);
        members.put("green", GREEN);
        members.put("blue", BLUE);
        return members;
    } //-- java.util.Hashtable init()

    public java.lang.String toString()
    {
        return this.stringValue;
    } //-- java.lang.String toString()

    public static Color valueOf(java.lang.String string)
    {
        Object obj = null;
        if (string != null) obj = _memberTable.get(string);
        if (obj == null) {
            String err = "'" + string + "' is not a valid Color";
            throw new IllegalArgumentException(err);
        }
        return (Color) obj;
    } //-- test.types.Color valueOf(java.lang.String)


}
