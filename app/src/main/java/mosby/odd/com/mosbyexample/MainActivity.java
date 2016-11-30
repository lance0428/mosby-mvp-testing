package mosby.odd.com.mosbyexample;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.ViewSwitcher;

import com.hannesdorfmann.mosby.mvp.MvpActivity;
import com.hannesdorfmann.mosby.mvp.viewstate.MvpViewStateActivity;
import com.hannesdorfmann.mosby.mvp.viewstate.ViewState;

import mosby.odd.com.mosbyexample.MainContract.IMainView;

public class MainActivity extends MvpViewStateActivity<IMainView, MainPresenter> implements IMainView {

    private TextView userName;
    private ViewSwitcher buttonSwitcher;
    private Button loginButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.i("LDJ", "MainActivity.onCreate(" + savedInstanceState  + ") " + this);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        userName = (TextView) findViewById(R.id.usernameText);
        buttonSwitcher = (ViewSwitcher) findViewById(R.id.buttonSwitcher);
        loginButton = (Button) findViewById(R.id.loginButton);
        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                presenter.login(userName.getText().toString());
            }
        });
        setRetainInstance(true);
    }



    @Override
    public MainPresenter createPresenter() {
        MainPresenter mainPresenter = (MainPresenter) getLastNonConfigurationInstance();
//        if(mainPresenter == null) {
            mainPresenter = new MainPresenter();
//        }
        Log.i("LDJ", "MainActivity.createPresenter() " + mainPresenter + " " + this);
        return mainPresenter;
    }

    @Override
    public void showLoginInProgress() {
        Log.i("LDJ", "MainActivity.showLoginInProgress()" + this);
        buttonSwitcher.showNext();
    }

    @Override
    public void showLoginError(String error) {
        Log.i("LDJ", "MainActivity.showLoginError(" + error + ") " + this);
        buttonSwitcher.showPrevious();
        userName.setError(error);
    }

    @Override
    public ViewState<IMainView> createViewState() {
        MainViewState mainViewState = new MainViewState();
        Log.i("LDJ", "MainActivity.createViewState() " + mainViewState + " " + this);
        return mainViewState;
    }

    @Override
    public void onNewViewStateInstance() {
        Log.i("LDJ", "MainActivity.onNewViewStateInstance() " + this);
    }
}
