public class Admin extends User {
    
    private string level;

    public Admin(String email, String username, String password, String level) {
        super(email, username, password);
        this.level = level;
    }

    public Admin() {
    }

    public string getLevel() {
        return this.level;
    }

    public void setLevel(string level) {
        this.level = level;
    }

    public Admin level(string level) {
        setLevel(level);
        return this;
    }

    @Override
    public String toString() {
        return "{" +
            " id='" + getId() + "'" +
            ", email='" + getEmail() + "'" +
            ", username='" + getUsername() + "'" +
            ", password='" + getPassword() + "'" +
            ", level='" + getLevel() + "'" +
            "}";
    }
}
