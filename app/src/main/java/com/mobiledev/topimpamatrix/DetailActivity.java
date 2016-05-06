package com.mobiledev.topimpamatrix;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.Button;

import com.mobiledev.topimpamatrix.Keyboard.KeyboardActivity;

import org.ejml.data.CDenseMatrix64F;
import org.ejml.ops.RandomMatrices;

import java.util.Random;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by lars on 3/17/16.
 */
public class DetailActivity extends Activity {

    public static final String CALCULATOR_URL = "http://icons.iconarchive.com/icons/dtafalonso/android-lollipop/512/Calculator-icon.png";
    public static final String DEFAULT_MATRIX_URL = "http://ncalculators.com/images/formulas/2x2-matrix.png";
    public static final String KEYBOARD_URL = "https://material-design.storage.googleapis.com/publish/material_v_4/material_ext_publish/0Bx4BSt6jniD7c2M0WDlSakI4akE/usability_bidirectionality_guidelines_whennot3.png";

    public static final String TAG = DetailActivity.class.getSimpleName();

    public  final static String SERIALIZABLE_KEY = "key";

    private Detail[] mDetails;
    private DetailRecyclerViewAdapter mAdapter;

    public static final String ARG_MATRIX = "matrix";

    @Bind(R.id.detail_recycler)
    RecyclerView mRecyclerView;

    @Bind(R.id.detail_activity_webview)
    WebView mWebView;

//    @Bind(R.id.grid_view)
//    GridView mGridView;

    @Nullable
    @Bind(R.id.matrix_number)
    Button mMatrixGridItem;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.detail_activity);

        ButterKnife.bind(this);

        CDenseMatrix64F mMatrix = (CDenseMatrix64F) getIntent().getSerializableExtra(MainActivity.SERIALIZABLE_KEY);
        mMatrix.print();

//        GridViewCustomAdapter mAdapter = new GridViewCustomAdapter(this, mMatrix);
//        mGridView.setAdapter(mAdapter);
//        mGridView.setNumColumns(MainActivity.columns);

        WebSettings webSettings = mWebView.getSettings();
        webSettings.setJavaScriptEnabled(true);
        String js = FormatHelper.matrixToLatex(mMatrix);
        mWebView.loadDataWithBaseURL("file:///android_asset/", js, "text/html", "UTF-8", null);

        mDetails = DetailRecyclerViewHelper.getDetails(mMatrix);
        this.mAdapter = new DetailRecyclerViewAdapter(mDetails, new DetailRecyclerViewAdapter.DetailRowOnClickListener() {
            @Override
            public void onDetailRowClick(Detail detail) {
                // toast
            }
        });

        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mRecyclerView.setAdapter(this.mAdapter);

//        double[][] array = new double[][]{{1, 1, 3, 0}, {5, 0, 7, 0}};
//        CDenseMatrix64F matrix = new CDenseMatrix64F(array); // by columns then rows: real, im
//        mMatrix = matrix;
//
//        Log.d(TAG, "real at r = 0, c = 0 " + matrix.getReal(0, 0));
//        Log.d(TAG, "real at r = 0, c = 1 " + matrix.getReal(0, 1));
//        Log.d(TAG, "real at r = 1, c = 0 " + matrix.getReal(1, 0));
//        Log.d(TAG, "real at r = 1, c = 1 " + matrix.getReal(1, 1));
//        Log.d(TAG, "imaginary at r = 0, c = 0 " + matrix.getImaginary(0, 0));
//        Log.d(TAG, "imaginary at r = 0, c = 1 " + matrix.getImaginary(0, 1));
//        Log.d(TAG, "imaginary at r = 1, c = 0 " + matrix.getImaginary(1, 0));
//        Log.d(TAG, "imaginary at r = 1, c = 1 " + matrix.getImaginary(1, 1));

    }


    @OnClick(R.id.activity_camera_icon)
    public void cameraButtonClicked() {
        CDenseMatrix64F matrix = new CDenseMatrix64F(2, 1);
        matrix.set(0, 0, 1, 0);
        matrix.set(1, 0, 2, 0);

        Intent intent = new Intent(this, DetailActivity.class);
        Bundle mBundle = new Bundle();
        mBundle.putSerializable(SERIALIZABLE_KEY, matrix);
        intent.putExtras(mBundle);
        startActivity(intent);
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

    @Nullable
    @OnClick(R.id.matrix_number)
    public void gridViewClicked() {
//        mMatrixGridItem.setInputType(InputType.TYPE_CLASS_NUMBER);
//        InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
//        imm.showSoftInput((mMatrixGridItem), InputMethodManager.SHOW_IMPLICIT);
    }


}