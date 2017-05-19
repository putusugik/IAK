package sugialmantara.iak;

import android.app.Application;

import com.facebook.stetho.Stetho;

/**
 * Created by Sugik on 5/20/2017.
 */

public class App extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        Stetho.initializeWithDefaults(this);
    }
}
