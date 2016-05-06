package com.mobiledev.topimpamatrix;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import org.ejml.data.CDenseMatrix64F;
import org.ejml.ops.RandomMatrices;

import java.util.Random;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by larspmayrand on 5/4/16.
 */
public class DictionaryActivity extends Activity {

    public static final int ID_DEFINITION = 0;
    private static final String TAG = "Definition";
    private DictionaryRecyclerViewAdapter mAdapter;
    public final static String SERIALIZABLE_KEY = "key";

    @Bind(R.id.definition_recycler)
    RecyclerView RecyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dictionary_activity);

        ButterKnife.bind(this);

        LinearDictionary dictionary = new LinearDictionary();

        this.mAdapter = new DictionaryRecyclerViewAdapter(dictionary.getDefinitions(), new DictionaryRecyclerViewAdapter.DictionaryRowOnClickListener() {
            @Override
            public void onDictionaryRowClick(Definition definition) {

            }
        });

        RecyclerView.setLayoutManager(new LinearLayoutManager(this)); // NULL
        RecyclerView.setAdapter(this.mAdapter);

//        GridViewCustomAdapter mAdapter = new GridViewCustomAdapter(this, mMatrix);
//        mGridView.setAdapter(mAdapter);
//        mGridView.setNumColumns(MainActivity.columns);

    }

    @OnClick(R.id.activity_keyboard_icon)
    public void keyboardClicked() {
        Intent intent = new Intent(this, InputActivity.class);
        startActivity(intent);
    }

    @OnClick(R.id.activity_calculator_icon)
    public void calculatorButtonClicked() {
        CDenseMatrix64F matrix = new CDenseMatrix64F(MatrixHelper.makeComplex(RandomMatrices.createOrthogonal(2, 2, new Random())));

        Intent intent = new Intent(this, CalculatorActivity.class);
        Bundle mBundle = new Bundle();
        mBundle.putSerializable(SERIALIZABLE_KEY, matrix);
        intent.putExtras(mBundle);
        startActivity(intent);
    }

    @OnClick(R.id.dictionary_icon)
    public void dictionaryClicked() {
        Intent intent = new Intent(this, DictionaryActivity.class);
        startActivity(intent);
    }

//    @Override
//    public void onDefinitionRowClick(Definition term) {
//        Intent intent = new Intent(DefinitionRecyclerView.this, PokemonDetailView.class);
//        intent.putExtra(DefinitionDetailView.ARG_DEFINITION, term);
//        this.startActivity(intent);
//    }

}
