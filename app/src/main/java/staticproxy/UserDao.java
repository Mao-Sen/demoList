package staticproxy;

import android.util.Log;

public class UserDao implements DAOInterface{
    @Override
    public void add() {
        Log.d("DAO","add");
    }

    @Override
    public void update() {
        Log.d("DAO","update");
    }

    @Override
    public void delete() {
        Log.d("DAO","delete");
    }

    @Override
    public void query() {
        Log.d("DAO","query");
    }

}
