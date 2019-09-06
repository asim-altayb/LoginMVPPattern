package alpha.orange.asim.loginmvppattern.Presenter;
import alpha.orange.asim.loginmvppattern.Model.user;
import alpha.orange.asim.loginmvppattern.View.Iloginview;

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
            iloginview.loginmessage("login success");

        else
            iloginview.loginmessage("login failed");

    }

}
