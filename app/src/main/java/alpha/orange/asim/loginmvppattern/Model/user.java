package alpha.orange.asim.loginmvppattern.Model;

import android.text.TextUtils;

public class user implements Iuser {
    String user,pass;

    public user(String user, String pass) {
        this.user = user;
        this.pass = pass;
    }

    @Override
    public String getUser() {
        return user;
    }

    @Override
    public String getPass() {
        return pass;
    }

    @Override
    public boolean isvalid() {
        if(!TextUtils.isEmpty(user)&&pass.length()>4)

            return true;

        else

            return false;
    }
}
