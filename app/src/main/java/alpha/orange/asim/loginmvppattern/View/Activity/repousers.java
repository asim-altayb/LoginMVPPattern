package alpha.orange.asim.loginmvppattern.View.Activity;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.text.method.ScrollingMovementMethod;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import alpha.orange.asim.loginmvppattern.Model.GithubRepos.github;
import alpha.orange.asim.loginmvppattern.R;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.scalars.ScalarsConverterFactory;

public class repousers extends AppCompatActivity {

    TextView repo,userrepo;
    EditText etuser;
    Button fetch;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_repousers);

        //init views
        repo = (TextView) findViewById(R.id.repos);
        etuser=(EditText) findViewById(R.id.et_user_git);
        fetch =(Button) findViewById(R.id.fetch);
        userrepo= (TextView) findViewById(R.id.user_repo);



        //init events
        fetch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getResponse(etuser.getText().toString());
            }
        });

    }


    public void getResponse(String user){


        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(github.JSONURL)
                .addConverterFactory(ScalarsConverterFactory.create())
                .build();

        github api = retrofit.create(github.class);

        Call<String> call = api.getString(user);

        call.enqueue(new Callback<String>() {
            @Override
            public void onResponse(Call<String> call, Response<String> response) {
                Log.i("Responsestring", response.toString());
                //Toast.makeText()
                if (response.isSuccessful()) {
                    if (response.body() != null) {
                        Log.i("onSuccess", response.body().toString());

                        repo.setText(response.body().toString());
                        repo.setMovementMethod(new ScrollingMovementMethod());


                        userrepo.setText(etuser.getText()+"'s Repos");



                    } else {
                        Log.i("onEmptyResponse", "Returned empty response");
                        userrepo.setText(etuser.getText()+"'s Repos");
                        repo.setText("empty repo");
                        Toast.makeText(getApplicationContext(),"NoRepo found on "+etuser.getText(),Toast.LENGTH_LONG).show();
                    }
                }
                else{
                    userrepo.setText(etuser.getText()+"'s Repos");
                    repo.setText("empty repo");
                    Toast.makeText(getApplicationContext(),"NoRepo found on "+etuser.getText(),Toast.LENGTH_LONG).show();

                }
            }

            @Override
            public void onFailure(Call<String> call, Throwable t) {

            }
        });

    }

}