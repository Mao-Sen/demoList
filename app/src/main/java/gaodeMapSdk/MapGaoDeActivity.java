package gaodeMapSdk;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.Button;
import android.widget.Toolbar;

import com.amap.api.maps.AMap;
import com.amap.api.maps.MapView;
import com.amap.api.maps.model.Circle;
import com.amap.api.maps.model.CircleOptions;
import com.amap.api.maps.model.LatLng;
import com.amap.api.maps.model.Marker;
import com.amap.api.maps.model.MarkerOptions;
import com.amap.api.maps.model.MyLocationStyle;
import com.amap.api.maps.model.PolygonOptions;
import com.amap.api.maps.model.Polyline;
import com.amap.api.maps.model.PolylineOptions;
import com.example.testone.R;

import java.security.PublicKey;
import java.util.ArrayList;
import java.util.List;

public class MapGaoDeActivity extends AppCompatActivity {
//40:8F:8D:9C:F0:0D:08:15:F2:D4:43:71:FF:33:34:00:A6:00:4E:87
    //3a2150a578c97b74d82e8ae504a49da6
    MapView mMapView=null;
    AMap aMap;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_map_gao_de);
        findViewById(R.id.toolbar).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        mMapView = findViewById(R.id.mapaView);
        mMapView.onCreate(savedInstanceState);
        //初始化地图控制器对象
        if (aMap == null) {
            aMap=mMapView.getMap();
        }
        findViewById(R.id.polyline).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                List<LatLng> latLngs = new ArrayList<LatLng>();
                latLngs.add(new LatLng(39.999391,116.135972));
                latLngs.add(new LatLng(39.898323,116.057694));
                latLngs.add(new LatLng(39.900430,116.265061));
                latLngs.add(new LatLng(39.955192,116.140092));
                aMap.addPolyline(new PolylineOptions().
                        addAll(latLngs).width(10).color(Color.argb(255, 1, 1, 1)));
            }
        });
        LatLng latLng = new LatLng(39.984059,116.307771);
        aMap.addCircle(new CircleOptions()
                .center(latLng)
                .radius(1000)
                .fillColor(Color.argb(100, 1, 1, 1))
                .strokeColor(Color.argb(150, 1, 1, 1))
                .strokeWidth(8));
        LatLng latLng2 = new LatLng(39.906901,116.397972);
        aMap.addMarker(new MarkerOptions()
                .position(latLng2)
                .title("北京")
                .snippet("BeiJingTianAnMen")
                .draggable(true));
        aMap.showIndoorMap(true);//室内地图

        MyLocationStyle myLocationStyle;
        myLocationStyle = new MyLocationStyle();//初始化定位蓝点样式类myLocationStyle.myLocationType(MyLocationStyle.LOCATION_TYPE_LOCATION_ROTATE);//连续定位、且将视角移动到地图中心点，定位点依照设备方向旋转，并且会跟随设备移动。（1秒1次定位）如果不设置myLocationType，默认也会执行此种模式。
        myLocationStyle.interval(2000); //设置连续定位模式下的定位间隔，只在连续定位模式下生效，单次定位模式下不会生效。单位为毫秒。
        aMap.setMyLocationStyle(myLocationStyle);//设置定位蓝点的Style
//aMap.getUiSettings().setMyLocationButtonEnabled(true);设置默认定位按钮是否显示，非必需设置。
        aMap.setMyLocationEnabled(true);
        //myLocationStyle.showMyLocation(true);
    }





//aMap.showIndoorMap(true);

    @Override
    protected void onDestroy() {
        super.onDestroy();
        //在activity执行onDestroy时执行mMapView.onDestroy()，销毁地图
        mMapView.onDestroy();
    }
    @Override
    protected void onResume() {
        super.onResume();
        //在activity执行onResume时执行mMapView.onResume ()，重新绘制加载地图
        mMapView.onResume();
    }
    @Override
    protected void onPause() {
        super.onPause();
        //在activity执行onPause时执行mMapView.onPause ()，暂停地图的绘制
        mMapView.onPause();
    }
    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        //在activity执行onSaveInstanceState时执行mMapView.onSaveInstanceState (outState)，保存地图当前的状态
        mMapView.onSaveInstanceState(outState);
    }
}