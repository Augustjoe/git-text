package domain;

public class User {
    private String id;
    private String username;
    private String password;
    private boolean state;

    public User() {
        id = createID();
        state = true;
    }
    public User( String username, String password, boolean state) {
        this.username = username;
        this.password = password;
        this.state = state;
    }

    public String createID(){
        return "ID" + System.currentTimeMillis()+Math.random()*1000;
    }

    public String getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isState() {
        return state;
    }

    public void setState(boolean state) {
        this.state = state;
    }
}
