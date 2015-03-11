package com.steam.mobile.transj.view.fragment;

import android.app.Fragment;
import android.app.ProgressDialog;

/**
 * Created by heriman on 3/11/15.
 */
public class BaseFragment extends Fragment {

    private ProgressDialog progressDialog;
    public void showProgressDialog(String title, String contain){
        progressDialog = ProgressDialog.show(getActivity(),title,
                contain, true);
    }
    public void dismissProgressDialog(){
        progressDialog.dismiss();
    }
}
