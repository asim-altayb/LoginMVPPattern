package alpha.orange.asim.loginmvppattern.View.Activity;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.TextView;
import alpha.orange.asim.loginmvppattern.Model.GithubRepos.github;
import alpha.orange.asim.loginmvppattern.R;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.scalars.ScalarsConverterFactory;

public class repousers extends AppCompatActivity {

    TextView repo;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_repousers);

        //init views
        repo = (TextView) findViewById(R.id.repos);


        //init events
                getResponse();
    }


    public void getResponse(){


        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(github.JSONURL)
                .addConverterFactory(ScalarsConverterFactory.create())
                .build();

        github api = retrofit.create(github.class);

        Call<String> call = api.getString();

        call.enqueue(new Callback<String>() {
            @Override
            public void onResponse(Call<String> call, Response<String> response) {
                Log.i("Responsestring", response.toString());
                //Toast.makeText()
                if (response.isSuccessful()) {
                    if (response.body() != null) {
                        Log.i("onSuccess", response.body().toString());

                        repo.setText(response.body().toString());


                    } else {
                        Log.i("onEmptyResponse", "Returned empty response");//Toast.makeText(getContext(),"Nothing returned",Toast.LENGTH_LONG).show();
                    }
                }
            }

            @Override
            public void onFailure(Call<String> call, Throwable t) {

            }
        });

    }

}