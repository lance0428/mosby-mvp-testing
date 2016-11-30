package mosby.odd.com.mosbyexample;

import android.os.AsyncTask;
import android.util.Log;

import com.hannesdorfmann.mosby.mvp.MvpBasePresenter;

import mosby.odd.com.mosbyexample.MainContract.IMainView;

public class MainPresenter extends MvpBasePresenter<IMainView> {

    @Override
    public void attachView(IMainView view) {
        Log.i("LDJ", "MainPresenter.attachView(" + view + ") " + this);
        super.attachView(view);
    }

    @Override
    public void detachView(boolean retainInstance) {
        Log.i("LDJ", "MainPresenter.detachView(" + retainInstance + ") " + this);
        super.detachView(retainInstance);
    }

    public void login(final String text) {
        AsyncTask<Void, Void, String> task = new AsyncTask<Void, Void, String>() {

            @Override
            protected String doInBackground(Void... voids) {
                Log.i("LDJ", "MainPresenter.task.doInBackground() " + text + " - Start " + MainPresenter.this);
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                Log.i("LDJ", "MainPresenter.task.doInBackground() " + text +  " - Finish " + MainPresenter.this);
                return "I did it in the background";
            }
        };
        task.execute();

    }
}
