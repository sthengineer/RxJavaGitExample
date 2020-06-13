package e.judy.rxjavagitexample.Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

import e.judy.rxjavagitexample.Model.GitHubRepoModel;
import e.judy.rxjavagitexample.R;

public class GitHubRepoListAdapter extends BaseAdapter {
    private List<GitHubRepoModel> gitHubRepos = new ArrayList<>();

    @Override
    public int getCount() {
        return gitHubRepos.size();
    }

    @Override
    public GitHubRepoModel getItem(int position) {
        if (position < 0 || position >= gitHubRepos.size()) {
            return null;
        } else {
            return gitHubRepos.get(position);
        }
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        final View view = (convertView != null ? convertView : createView(parent));
        final GitHubRepoViewHolder viewHolder = (GitHubRepoViewHolder) view.getTag();
        viewHolder.setGitHubRepo(getItem(position));
        return view;
    }

    public void setGitHubRepos(@Nullable List<GitHubRepoModel> repos) {
        if (repos == null) {
            return;
        }
        gitHubRepos.clear();
        gitHubRepos.addAll(repos);
        notifyDataSetChanged();
    }

    private View createView(ViewGroup parent) {
        final LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        final View view = inflater.inflate(R.layout.item_github_repo, parent, false);
        final GitHubRepoViewHolder viewHolder = new GitHubRepoViewHolder(view);
        view.setTag(viewHolder);
        return view;
    }

    public void add(GitHubRepoModel gitHubRepo) {
        gitHubRepos.add(gitHubRepo);
        notifyDataSetChanged();
    }

    private static class GitHubRepoViewHolder {

        private TextView textRepoName;
        private TextView textRepoDescription;
        private TextView textLanguage;
        private TextView textStars;

        public GitHubRepoViewHolder(View view) {
            textRepoName = (TextView) view.findViewById(R.id.text_repo_name);
            textRepoDescription = (TextView) view.findViewById(R.id.text_repo_description);
            textLanguage = (TextView) view.findViewById(R.id.text_language);
            textStars = (TextView) view.findViewById(R.id.text_stars);
        }

        public void setGitHubRepo(GitHubRepoModel gitHubRepo) {
            textRepoName.setText(gitHubRepo.name);
            textRepoDescription.setText(gitHubRepo.description);
            textLanguage.setText("Language: " + gitHubRepo.language);
            textStars.setText("Stars: " + gitHubRepo.stargazersCount);
        }
    }
}
