// Session.java
package config;

public class Session {
    
    private static Session instance;
    private int id;
    private String fname;
    private String lname;
    private String email;
    
        private Session() {
        // Private constructor to prevent instantiation
    }



   public static synchronized Session getInstance() {
        if (instance == null) {
            instance = new Session();
        }
        return instance;
    }
   
   public static boolean isInstanceEmpty() {
        return instance == null;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public String getLname() {
        return lname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }


   
}