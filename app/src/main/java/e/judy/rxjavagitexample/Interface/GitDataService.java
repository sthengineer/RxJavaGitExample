package e.judy.rxjavagitexample.Interface;

import rx.Observable;
import java.util.List;

import e.judy.rxjavagitexample.Model.GitHubRepoModel;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface GitDataService {
    @GET("users/{user}/starred")
    Observable<List<GitHubRepoModel>> getStarredRepositories(@Path("user") String userName);
}
