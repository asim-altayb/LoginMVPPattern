package alpha.orange.asim.loginmvppattern.Model.NewUser;

import android.text.TextUtils;

public class user implements Iuser {
    private String email,pass;

    public user(String email, String pass) {
        this.email = email;
        this.pass = pass;
    }

    @Override
    public String getUser() {
        return email;
    }

    @Override
    public String getPass() {
        return pass;
    }

    @Override
    public boolean isvalid() {
        return  !TextUtils.isEmpty(email)&&pass.length()>4;
    }
}
