/* Working : Two Fragmnet sweep on screen direction */
package com.dipankar.crazyexpandroid.app;
import android.app.Fragment;
import android.os.Bundle;
    import android.app.Activity;
    import android.app.FragmentManager;
    import android.app.FragmentTransaction;
    import android.content.res.Configuration;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;

public class tutorial21 extends Activity {

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            Configuration config = getResources().getConfiguration();
            FragmentManager fragmentManager = getFragmentManager();
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

            if (config.orientation == Configuration.ORIENTATION_LANDSCAPE) {
                LM_Fragment ls_fragment = new LM_Fragment();
                fragmentTransaction.replace(android.R.id.content, ls_fragment);
            }else{
                PM_Fragment pm_fragment = new PM_Fragment();
                fragmentTransaction.replace(android.R.id.content, pm_fragment);
            }
            fragmentTransaction.commit();
            /* SUMMARY
            Step1: Adding Fragment
            getFragmentManager()
            .beginTransaction()
            .add(R.id.fragmentParentViewGroup, new MyFragment())
            .commit();

            Step2: Replace:
            getFragmentManager().beginTransaction()
            .replace(R.id.fragmentParentViewGroup, new MySecondFragment())
            .commit();

            Step3: Remove
            getFragmentManager().beginTransaction()
           .remove(mySecondFragment)
            .commit();

            Step4: Adding Backstage.
            MySecondFragment mySecondFragment = new MySecondFragment();
            getFragmentManager().beginTransaction()
            .replace(R.id.fragmentParentViewGroup, mySecondFragment)
            .addToBackStack(null)
            .commit();


            ***************************************/
        }

}

