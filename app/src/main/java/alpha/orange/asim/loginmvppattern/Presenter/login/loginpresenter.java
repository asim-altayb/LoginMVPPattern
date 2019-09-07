package alpha.orange.asim.loginmvppattern.Presenter.login;

import alpha.orange.asim.loginmvppattern.Model.Users.user;
import alpha.orange.asim.loginmvppattern.View.views.Iloginview;

public class loginpresenter implements Iloginpresenter {

    Iloginview iloginview;


    public loginpresenter(Iloginview iloginview) {
       this.iloginview=iloginview;
    }

    @Override
    public void onlogin(String email, String pass) {

        user users=new user(email,pass);

        boolean isvalidate=users.isvalid();

        if(isvalidate)
            iloginview.loginmessage(true);

        else
            iloginview.loginmessage(false);

    }

}
