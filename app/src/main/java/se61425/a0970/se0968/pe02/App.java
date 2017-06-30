package se61425.a0970.se0968.pe02;

import android.app.Application;
import android.content.Context;
import android.util.Log;

import se61425.a0970.se0968.pe02.database.SQLiteManager;
import se61425.a0970.se0968.pe02.database.SqLiteHelper;

/**
 * Created by Thuans on 4/27/2017.
 */

public class App extends Application {
    private static Context context;
    private static SqLiteHelper dbHelper;

    @Override
    public void onCreate()
    {
        super.onCreate();
        context = this.getApplicationContext();
        dbHelper = new SqLiteHelper();
        SQLiteManager.initializeInstance(dbHelper);
        dbHelper.delete();
        dbHelper.insert(new Bonsai("cây đào",R.drawable.bon1,"chi tiết là cây đào","xuất xứ Singapoe",305.12));
        dbHelper.insert(new Bonsai("cây quỉ",R.drawable.bon2,"chi tiết là cây đào","xuất xứ Singapoe",305.12));
        dbHelper.insert(new Bonsai("cây quý",R.drawable.bon2,"chi tiết là cây đào","xuất xứ Singapoe",305.12));
        dbHelper.insert(new Bonsai("cây mận",R.drawable.bon3,"chi tiết là cây đào","xuất xứ Singapoe",305.12));
        dbHelper.insert(new Bonsai("cây bông",R.drawable.bon3,"chi tiết là cây đào","xuất xứ Singapoe",305.12));
        dbHelper.insert(new Bonsai("cây hoa",R.drawable.bon4,"chi tiết là cây đào","xuất xứ Singapoe",305.12));
        dbHelper.insert(new Bonsai("cây ha",R.mipmap.ic_launcher,"chi tiết là cây đào","xuất xứ Singapoe",305.12));

        Log.d("App context","initiating .....");

    }

    public static Context getContext(){
        return context;
    }
}
