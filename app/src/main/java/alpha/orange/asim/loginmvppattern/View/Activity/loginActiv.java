package alpha.orange.asim.loginmvppattern.View.Activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import alpha.orange.asim.loginmvppattern.Presenter.loginpresenter;
import alpha.orange.asim.loginmvppattern.R;
import alpha.orange.asim.loginmvppattern.View.Iloginview;

public class loginActiv extends AppCompatActivity implements Iloginview, View.OnClickListener {
    EditText user,pass;
    Button login;

    loginpresenter loginpresenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        //init views
        user=(EditText) findViewById(R.id.et_user);
        pass=(EditText) findViewById(R.id.et_pass);

        login=(Button) findViewById(R.id.btn_login);


        //init clicks

        login.setOnClickListener((View.OnClickListener) this);

    }

    @Override
    public void loginmessage(String msg) {
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onClick(View view) {

        loginpresenter = new loginpresenter(user.getText().toString() , pass.getText().toString()) ;
    }
}
