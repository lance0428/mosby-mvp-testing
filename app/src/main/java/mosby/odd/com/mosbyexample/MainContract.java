package mosby.odd.com.mosbyexample;

import com.hannesdorfmann.mosby.mvp.MvpView;

interface MainContract {

    interface IMainView extends MvpView {
        void showLoginInProgress();
        void showLoginError(String error);
    }
}
