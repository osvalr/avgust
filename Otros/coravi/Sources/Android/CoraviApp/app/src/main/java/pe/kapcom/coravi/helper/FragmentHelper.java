package pe.kapcom.coravi.helper;

import android.database.Cursor;
import android.support.v4.app.Fragment;
import android.widget.TableLayout;
import android.widget.Toast;

/**
 * Created by JRaffo on 26/12/16.
 */

public abstract class FragmentHelper  extends Fragment {


    public void showMessage(String message){
        Toast.makeText(this.getContext(), message, Toast.LENGTH_LONG).show();
    }

    protected void cleanTable(TableLayout table) {

        int childCount = table.getChildCount();

        // Remove all rows except the first one
        if (childCount > 1) {
            table.removeViews(1, childCount - 1);
        }
    }
}
