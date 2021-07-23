package HeaderBottomList;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.testone.R;

public class HeaderBottomListActivity extends AppCompatActivity {
    private ListView mylist = null;
    String[] listArray = { "ideasAndrid", "ideasandroid.com", "演示程序", "欢迎访问ideasandroid.com",
            "让程序开发不再神秘",  "android", "ListView", "渐变效果",
            "欢迎光临！","测试1", "测试2", "测试3",
            "测试4","测试4","测试4","测试4","测试4","测试4","测试4"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_header_bottom_list);
        mylist = (ListView) findViewById(R.id.myListView);
        ArrayAdapter<String> arrayA=new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, listArray);
        mylist.setAdapter(arrayA);
    }
}