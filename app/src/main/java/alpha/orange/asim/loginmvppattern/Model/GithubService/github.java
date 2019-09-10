package alpha.orange.asim.loginmvppattern.Model.GithubService;


import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface github {
    String JSONURL = "https://api.github.com/";

    @GET("users/{username}/repos")
    Call<String> getString(@Path("username") String user);


}
