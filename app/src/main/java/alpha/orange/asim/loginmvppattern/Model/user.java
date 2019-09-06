package alpha.orange.asim.loginmvppattern.Model;

import android.text.TextUtils;

public class user implements Iuser {
    String user1,pass;

    public user(String user11, String pass) {
        this.user1 = user11;
        this.pass = pass;
    }

    @Override
    public String getUser() {
        return user1;
    }

    @Override
    public String getPass() {
        return pass;
    }

    @Override
    public boolean isvalid() {
        if(!TextUtils.isEmpty(user1)&&pass.length()>4)

            return true;

        else

            return false;
    }
}
