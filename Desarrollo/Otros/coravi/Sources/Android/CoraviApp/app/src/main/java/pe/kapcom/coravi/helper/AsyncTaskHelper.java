package pe.kapcom.coravi.helper;

import android.app.ProgressDialog;
import android.os.AsyncTask;

/**
 * Created by JRaffo on 9/03/17.
 */

public abstract class AsyncTaskHelper<Params, Progress, Result> extends AsyncTask {
    protected ProgressDialog progressDialog;
}
