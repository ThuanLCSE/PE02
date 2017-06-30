package se61425.a0970.se0968.pe02;

import android.app.Fragment;
import android.net.Uri;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

import se61425.a0970.se0968.pe02.database.SqLiteHelper;

public class MainActivity extends AppCompatActivity  implements BonsaiAdapter.ItemClickListener, DetailFragment.OnFragmentInteractionListener{
    private List<Bonsai> listItem;
    boolean menuIsOn = false;
    private View fragmentCView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        SqLiteHelper dbHelper = new SqLiteHelper();
        listItem = dbHelper.getAll();
        RecyclerView lstBonsai = (RecyclerView) findViewById(R.id.lst_bonsai);
        lstBonsai.setHasFixedSize(true);
        LinearLayoutManager horizonLayout = new LinearLayoutManager(this);
        horizonLayout.setOrientation(LinearLayoutManager.VERTICAL);
        lstBonsai.setLayoutManager(horizonLayout);
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        final DetailFragment detFrag= new DetailFragment();
        fragmentTransaction.add(R.id.fragment_C, detFrag);
        fragmentTransaction.commit();
        fragmentCView = findViewById(R.id.fragment_C);

        BonsaiAdapter adapt = new BonsaiAdapter(listItem,this);
        lstBonsai.setAdapter(adapt);
    }

    @Override
    public void onClick(Bonsai area) {
        if (!menuIsOn) {
            fragmentCView.setVisibility(View.VISIBLE);
        } else {
            fragmentCView.setVisibility(View.INVISIBLE);
        }
        menuIsOn = !menuIsOn;
    }

    @Override
    public void onFragmentInteraction(Uri uri) {

    }
}
