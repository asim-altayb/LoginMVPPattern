package alpha.orange.asim.loginmvppattern.Presenter;
import alpha.orange.asim.loginmvppattern.Model.user;
import alpha.orange.asim.loginmvppattern.View.Iloginview;

public class loginpresenter implements Iloginpresenter {

    Iloginview iloginview;
    String user,pass;

    public loginpresenter(String user, String pass) {
        this.user = user;
        this.pass = pass;
    }

    @Override
    public void onlogin(String user, String pass) {

        user users=new user(user,pass);

        boolean isval=users.isvalid();

        if(isval)
        {
            iloginview.loginmessage("login success");
        }

        else

        {
            iloginview.loginmessage("login failed");
        }

    }

}
