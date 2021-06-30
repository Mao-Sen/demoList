package staticproxy;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

import com.example.testone.R;

public class ProxyActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_proxy);
        findViewById(R.id.add).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new UserDaoProxy(new UserDao()).add();
            }
        });
        findViewById(R.id.update).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new UserDaoProxy(new UserDao()).update();
            }
        });
        findViewById(R.id.delete).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new UserDaoProxy(new UserDao()).delete();
            }
        });
        findViewById(R.id.query).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new UserDaoProxy(new UserDao()).query();
            }
        });
        findViewById(R.id.dynamicProxy).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DAOInterface proxy = new DynamicProxy().getProxy(new UserDao());
                proxy.add();
            }
        });
    }
}