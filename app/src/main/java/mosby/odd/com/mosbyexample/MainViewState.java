package mosby.odd.com.mosbyexample;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.util.Log;

import com.hannesdorfmann.mosby.mvp.viewstate.RestorableViewState;

public class MainViewState implements RestorableViewState<MainContract.IMainView> {
    @Override
    public void saveInstanceState(@NonNull Bundle out) {
        Log.i("LDJ", "MainViewState.saveInstanceState(" + out + ")" + this);
    }

    @Override
    public RestorableViewState<MainContract.IMainView> restoreInstanceState(Bundle in) {
        Log.i("LDJ", "MainViewState.restoreInstanceState(" + in + ")" + this);
        return this;
    }

    @Override
    public void apply(MainContract.IMainView view, boolean retained) {
        Log.i("LDJ", "MainViewState.apply(" + view + ", " + retained + ")" + this);
    }
}
