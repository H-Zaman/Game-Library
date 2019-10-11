package javamysql.ui;

public class User {
    
    private String fn;
    private String ln;
    private String un;
    private String pw;
    
    public User(String fnn, String lnn, String unn, String psw)
    {
        this.fn = fnn;
        this.ln = lnn;
        this.un = unn;
        this.pw = psw;
    }
    
    public String getfnn()
    {
        return fn;
    }
    
    public String getlnn()
    {
        return ln;
    }
    
    public String getunn()
    {
        return un;
    }
    
    public String getpsw()
    {
        return pw;
    }
}