package alpha.orange.asim.loginmvppattern.Model.GithubRepos;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface github {
    String JSONURL = "https://api.github.com/";

    @GET("users/asim-altayb/repos")
    Call<String> getString();


}
