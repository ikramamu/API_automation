package pojos;

public class NewUser {

    private String name;
    private String company;
    private String email;
    private String password;
    private long phone;
    private int consent;


    public NewUser(String name, String company, String email, String password, long phone, int consent){
        setName(name);
        setCompany(company);
        setEmail(email);
        setPassword(password);
        setPhone(phone);
        setConsent(consent);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public long getPhone() {
        return phone;
    }

    public void setPhone(long phone) {
        this.phone = phone;
    }

    public int getConsent() {
        return consent;
    }

    public void setConsent(int consent) {
        this.consent = consent;
    }

    public String toString(){
        return "name: "+getName()+"\n"+
                "company: "+getCompany()+"\n"+
                "email: "+getEmail()+"\n"+
                "password: "+getPassword()+"\n"+
                "phone: "+getPhone()+"\n"+
                "consent: "+getConsent();
    }
}
