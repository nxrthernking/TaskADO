package entities;


import com.opencsv.bean.CsvBindByName;

public class User {

    @CsvBindByName
    private Long id;
    @CsvBindByName
    private String username;
    @CsvBindByName
    private String password;

    public User() {

    }

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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


    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if(obj == null)
            return false;
        if(!(obj instanceof User))
            return false;
        User user = (User) obj;
        return this.id.equals(user.id) &&
                this.username.equals(user.username) &&
                this.password.equals(user.password);
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
