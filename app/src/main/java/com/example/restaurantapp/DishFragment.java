package com.example.restaurantapp;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link DishFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class DishFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "dishName";
    private static final String ARG_PARAM2 = "dishPrice";
    private static final String ARG_PARAM3 = "dishIngredients";

    // TODO: Rename and change types of parameters
    private String mDishName;
    private String mDishPrice;
    private String mDishIngredients;

    public DishFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param mDishName Parameter 1.
     * @param mDishPrice Parameter 2.
     * @param mDishIngredients Parameter 3.
     * @return A new instance of fragment DishFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static DishFragment newInstance(String mDishName, String mDishPrice, String mDishIngredients) {
        DishFragment fragment = new DishFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, mDishName);
        args.putString(ARG_PARAM2, mDishPrice);
        args.putString(ARG_PARAM3, mDishIngredients);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mDishName = getArguments().getString(ARG_PARAM1);
            mDishPrice = getArguments().getString(ARG_PARAM2);
            mDishIngredients = getArguments().getString(ARG_PARAM3);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_dish, container, false);
    }
}