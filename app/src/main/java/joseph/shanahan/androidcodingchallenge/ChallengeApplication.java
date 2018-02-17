package joseph.shanahan.androidcodingchallenge;

import android.app.Application;

import joseph.shanahan.androidcodingchallenge.data.DataManager;

/**
 * Created by josephshanahan on 2/17/18.
 */

public class ChallengeApplication extends Application {

    private DataManager dataManager;

    @Override
    public void onCreate() {
        super.onCreate();
        dataManager = new DataManager();
    }

    public DataManager getDataManager(){
        return dataManager;
    }
}
