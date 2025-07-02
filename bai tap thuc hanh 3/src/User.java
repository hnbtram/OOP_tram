public class User { 
    private String username;
    private String password;
    private String email;
    private String fullName;
    private int age;

    public User(String username, String password, String email){
        this.username = username;
        this.password = password;
        this.email = email;
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
    public void setPassword(String password){
        this.password = password;
    }
    public String getEmail(){
        return email;
    }
    public void setEmail(String email){
        this.email = email;
    }
    public String getFullName(){ 
        return fullName;
    }
    public void setFullName(String fullName){ 
        this.fullName = fullName;
    }
    public int getAge() {
        return age;
    }
    public void setAge(int age) {
        if(age>=0) {
            this.age = age;
        }
    }
    public void displayUserInfo() {
        System.out.println("Username: " + username);
        System.out.println("Email: " + email);
        System.out.println("Full name: " + fullName);
        System.out.println("Age: " + age);
    }
}