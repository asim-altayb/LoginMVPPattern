package alpha.orange.asim.loginmvppattern.View.Activity;


import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.text.method.ScrollingMovementMethod;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import alpha.orange.asim.loginmvppattern.Model.GithubService.github;
import alpha.orange.asim.loginmvppattern.R;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.scalars.ScalarsConverterFactory;

public class repousers extends AppCompatActivity implements View.OnClickListener {

    TextView repo,userrepo;
    EditText etuser;
    Button fetch;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_repousers);

        //init views


        initviews();

        //init events
        fetch.setOnClickListener(this);

    }

    //button onclick linstner "fetch"
    public void onClick (View view){
        getResponse(etuser.getText().toString());
    }

    //initialize variables
    public void initviews(){
        repo = findViewById(R.id.repos);
        etuser= findViewById(R.id.et_user_git);
        fetch = findViewById(R.id.fetch);
        userrepo= findViewById(R.id.user_repo);
    }


    //here to fetch repository of "user"
    public void getResponse(String user){

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(github.JSONURL)
                .addConverterFactory(ScalarsConverterFactory.create())
                .build();

        //github interface created to be retrofit

        github api = retrofit.create(github.class);

        Call<String> call = api.getString(user);

        call.enqueue(new Callback<String>() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onResponse(@NonNull Call<String> call, @NonNull Response<String> response)
            {

                Log.i("Responsestring", response.toString());
                //Toast.makeText()
         if (response.isSuccessful()) {

                    if (response.body() != null) {

                        Log.i("onSuccess", response.body());

                        repo.setText(response.body());
                        repo.setMovementMethod(new ScrollingMovementMethod());

                        userrepo.setText(etuser.getText()+"'s Repos");

                    }
                    else
                        {

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

            }//on response

//this if happened something problem
            @Override
            public void onFailure(@NonNull Call<String> call, Throwable t) {

                Toast.makeText(repousers.this, t.getLocalizedMessage(), Toast.LENGTH_SHORT).show();
            }
        });

    }

}