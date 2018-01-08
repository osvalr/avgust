package pe.kapcom.coravi.helper;

import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

/**
 * Created by JRaffo on 24/10/16.
 */

public abstract class AppCompatActivityHelper extends AppCompatActivity {

    public void showMessage(String message){
        Toast.makeText(this.getApplicationContext(), message, Toast.LENGTH_LONG).show();
    }

}
