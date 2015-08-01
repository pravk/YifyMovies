package mobile.pk.com.yifymovies.ui.fragments;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.HashMap;
import java.util.Map;

import mobile.pk.com.yifymovies.Application;
import mobile.pk.com.yifymovies.R;
import mobile.pk.com.yifymovies.adapter.MovieListAdapter;
import mobile.pk.com.yifymovies.adapter.RVItemClickListener;
import mobile.pk.com.yifymovies.service.MovieListService;
import mobile.pk.com.yifymovies.ui.activity.BaseActivity;
import mobile.pk.com.yifymovies.ui.activity.MovieDetailActivity;
import mobile.pk.com.yifymovies.ui.activity.MovieSearchActivity;
import mobile.pk.com.yifymovies.ui.utils.EndlessRecyclerOnScrollListener;
import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;

/**
 * A fragment representing a list of Items.
 * <p>
 * Large screen devices (such as tablets) are supported by replacing the ListView
 * with a GridView.
 * <p>
 * Activities containing this fragment MUST implement the {@link OnFragmentInteractionListener}
 * interface.
 */
public class GenresFragment extends Fragment {


    public static GenresFragment newInstance() {
        GenresFragment fragment = new GenresFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    /**
     * Mandatory empty constructor for the fragment manager to instantiate the
     * fragment (e.g. upon screen orientation changes).
     */
    public GenresFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_genre_list, container, false);

        final ListView listView =   (ListView) view.findViewById(R.id.genres);
        final ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_list_item_1, getResources().getStringArray(R.array.genres_list));
        listView.setAdapter(arrayAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String genre = arrayAdapter.getItem(position);

                Intent intent = new Intent(getActivity(), MovieSearchActivity.class);
                HashMap<String,String> options = new HashMap<String, String>();
                options.put("genre", genre);
                intent.putExtra(MovieSearchActivity.OPTIONS, options);
                startActivityForResult(intent, BaseActivity.MOVIE_SEARCH_REQUEST);

            }
        });

        return view;
    }


    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        public void onFragmentInteraction(String id);
    }

}
