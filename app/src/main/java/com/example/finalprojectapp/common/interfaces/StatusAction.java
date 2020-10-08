package com.example.finalprojectapp.common.interfaces;

public interface StatusAction {

    interface ActionLoadingAndSuccess {
        void loading();
        void success();
    }

    interface ActionSuccessAndFailed {
        void success();
        void failed();
    }
}
