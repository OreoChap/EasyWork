package com.oreooo.library.MvpBase;

public interface BaseContract {
    interface BaseView{
        void subscribe();
        void unsubscribe();
    }

    interface BasePresenter{
        void setView(BaseView view);
    }
}
