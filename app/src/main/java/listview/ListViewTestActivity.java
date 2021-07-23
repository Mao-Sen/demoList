package listview;


import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListAdapter;
import android.widget.ListView;

import com.example.testone.R;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ListViewTestActivity extends Activity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listview_test);
        ListView listView = (ListView) findViewById(R.id.moreItemsListView);
        MyAdapter adapter = new MyAdapter(this, map());
        listView.setAdapter(adapter);
        setListViewHeightBasedOnChildren(listView);
    }

    public void setListViewHeightBasedOnChildren(ListView listView) {
        ListAdapter listAdapter = listView.getAdapter();
        if (listAdapter == null) {
            return;
        }

        int totalHeight = 0;
        for (int i = 0; i < listAdapter.getCount(); i++) {
            View listItem = listAdapter.getView(i, null, listView);
            listItem.measure(0, 0);
            totalHeight += listItem.getMeasuredHeight();
        }

        ViewGroup.LayoutParams params = listView.getLayoutParams();
        params.height = totalHeight
                + (listView.getDividerHeight() * (listAdapter.getCount() - 1));
        ((ViewGroup.MarginLayoutParams) params).setMargins(10, 10, 10, 10);
        listView.setLayoutParams(params);
    }

    private List<HashMap<String, String>> map() {
        List<HashMap<String, String>> data = new ArrayList<>();
        HashMap<String, String> map = new HashMap<>();
        map.put("name", "NameOne");
        data.add(map);
        map = new HashMap<String, String>();
        map.put("name", "NameTow");
        data.add(map);
        map = new HashMap<String, String>();
        map.put("name", "NameThree");
        data.add(map);
        map = new HashMap<String, String>();
        map.put("name", "Name4");
        data.add(map);
        map = new HashMap<String, String>();
        map.put("name", "Name5");
        data.add(map);
        return data;
    }

}