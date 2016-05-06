package com.mobiledev.topimpamatrix;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebSettings;
import android.webkit.WebView;

import java.util.ArrayList;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by larspmayrand on 5/5/16.
 */
public class DictionaryRecyclerViewAdapter extends RecyclerView.Adapter<DictionaryRecyclerViewAdapter.DefinitionViewHolder> {

    private ArrayList<Definition> mDefinitions;
    private DictionaryRowOnClickListener mListener;

    public interface DictionaryRowOnClickListener {
        void onDictionaryRowClick(Definition definition);
    }

    public DictionaryRecyclerViewAdapter(ArrayList<Definition> definitions, DictionaryRowOnClickListener listener) {
        mDefinitions = definitions;
        mListener = listener;
    }

    @Override
    public DefinitionViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View row = inflater.inflate(R.layout.definition_row, parent, false);
        return new DefinitionViewHolder(row);
    }

    @Override
    public void onBindViewHolder(DefinitionViewHolder holder, int position) {
        final Definition definition = mDefinitions.get(position);

        WebSettings webSettings = holder.mWebView.getSettings(); // please work
        webSettings.setJavaScriptEnabled(true);

        String js = FormatHelper.latex(definition.getTerm().trim() + ": " + definition.getDefinition().trim());

        holder.mWebView.loadDataWithBaseURL("file:///android_asset/", js, "text/html", "UTF-8", null);
        holder.mItemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mListener.onDictionaryRowClick(definition);
//                MyViewHolder holder = (MyViewHolder) v.getTag();
//                boolean result = holder.expandableLayout.toggleExpansion();
//                Item item = mItems.get(holder.getAdapterPosition());
//                item.isExpand = result ? !item.isExpand : item.isExpand;
            }
        });
    }

    @Override
    public int getItemCount() {
        return mDefinitions.size();
    }

    static class DefinitionViewHolder extends RecyclerView.ViewHolder {

        @Bind(R.id.definition_row_webview)
        WebView mWebView;

        public View mItemView;

        public DefinitionViewHolder(View itemView) {
            super(itemView);
            try {
                ButterKnife.bind(this, itemView);
            } catch (Exception e) {
                e.printStackTrace();
            }
            mItemView = itemView;
        }
    }

}


