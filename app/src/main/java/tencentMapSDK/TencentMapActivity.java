package tencentMapSDK;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

import com.example.testone.R;
import com.tencent.tencentmap.mapsdk.maps.MapView;
import com.tencent.tencentmap.mapsdk.maps.TencentMap;

public class TencentMapActivity extends AppCompatActivity {

    private MapView mapView;
    private TencentMap tencentMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tencent_map);
        mapView = findViewById(R.id.tencentMapView);
        tencentMap = mapView.getMap();
    }
}