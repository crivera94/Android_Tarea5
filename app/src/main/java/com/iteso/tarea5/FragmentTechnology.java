package com.iteso.tarea5;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.iteso.tarea5.beans.ItemProduct;
import com.iteso.tarea5.tools.Constants;
import com.iteso.tarea5.tools.ControlItemProduct;
import com.iteso.tarea5.tools.DataBaseHandler;

import java.util.ArrayList;
import java.util.Iterator;


public class FragmentTechnology extends Fragment {

    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    private ArrayList<ItemProduct> myDataSet;
    private DataBaseHandler dataBaseHandler;
    public FragmentTechnology() {
        dataBaseHandler = DataBaseHandler.getInstance(getActivity());
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment__technology, container, false);
        RecyclerView recyclerView = view.findViewById(R.id.fragment_technology_recycler_view);
        recyclerView.setHasFixedSize(true);
        mLayoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(mLayoutManager);
        ControlItemProduct itemProductControl = new ControlItemProduct(getActivity());
        myDataSet = itemProductControl.getItemProductsByCategory(1, dataBaseHandler);
        mAdapter = new AdapterProduct(getActivity(), myDataSet);
        recyclerView.setAdapter(mAdapter);
        itemProductControl = null;
        return view;
    }

    public void notifyDataSetChanged(ItemProduct itemProduct){
        myDataSet.add(itemProduct);
        mAdapter.notifyDataSetChanged();
    }

//    public void onActivityResult(int requestCode, int resultCode, Intent data) {
//        ItemProduct itemProduct = data.getParcelableExtra(Constants.PRODUCT);
//        Iterator<ItemProduct> iterator = myDataSet.iterator();
//        int position = 0;
//        while(iterator.hasNext()){
//            ItemProduct item = iterator.next();
//            if(item.getCode()==itemProduct.getCode()){
//                myDataSet.set(position, itemProduct);
//                break;
//            }
//            position++;
//        }
//        mAdapter.notifyDataSetChanged();
//    }



}