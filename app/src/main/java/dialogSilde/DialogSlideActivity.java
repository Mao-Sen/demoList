package dialogSilde;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import com.example.testone.R;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Hashtable;

public class DialogSlideActivity extends AppCompatActivity {

    public static String FILENAME = "fileName";
    private int selectedItem = -1;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dialog_silde);

        Button btnOpen = (Button) this.findViewById(R.id.btnOpen);

        btnOpen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ArrayList<Hashtable<String, String>> listData = GetCity();
                showSudokuListDialog(listData);
            }
        });
    }

    public void showSudokuListDialog(// TODO
                                     final ArrayList<Hashtable<String, String>> listFilePath) {
        if (listFilePath == null || listFilePath.size() == 0) {
            return;
        }
        selectedItem = -1;

        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        // builder.setTitle(getResources().getString(R.string.dialogOpenTitle));

        // set dialog view
        LayoutInflater layout = LayoutInflater.from(this);
        View sudokulistView = layout.inflate(R.layout.sudokulist, null);
        builder.setView(sudokulistView);
        builder.setCancelable(false);

        final TextView tvSudokuPreview = (TextView) sudokulistView
                .findViewById(R.id.tvSudokuPreview);

        final ListView lvSudokuItems = (ListView) sudokulistView
                .findViewById(R.id.lvSudokuItems);
        final SimpleAdapter adapter = new SimpleAdapter(this,
                listFilePath, R.layout.filelist, new String[] { FILENAME },
                new int[] { R.id.tvSudokuItem });
        // set list adapter
        lvSudokuItems.setAdapter(adapter);
        // TODO
        // set list click event
        lvSudokuItems.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @SuppressWarnings("unchecked")
            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {
                selectedItem = position;
                String strPreview = ((Hashtable<String, String>) adapter
                        .getItem(position)).get(FILENAME);
                tvSudokuPreview.setText(strPreview);
            }
        });

        // set list touch event
        lvSudokuItems.setOnTouchListener(new AdapterView.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                return false;
            }
        });

        // set delete button getResources().getString(R.string.dialogOpenBtnDel)
        builder.setNeutralButton("OK", new DialogInterface.OnClickListener() {
            @SuppressWarnings("unchecked")
            @Override
            public void onClick(DialogInterface dialog, int which) {
                try {
                    Field field = dialog.getClass().getSuperclass()
                            .getDeclaredField("mShowing");
                    field.setAccessible(true);
                    // set false?
                    field.setBoolean(dialog, false);
                } catch (Exception e) {
                    e.printStackTrace();
                }

                if (selectedItem == -1) {
                    showToast("δ������һ����ѡ��");
                    return;
                } else {
                    try {
                        Field field = dialog.getClass().getSuperclass()
                                .getDeclaredField("mShowing");
                        field.setAccessible(true);
                        field.setBoolean(dialog, true);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }

                    String key = ((Hashtable<String, String>) adapter
                            .getItem(selectedItem)).get(FILENAME);
                    showToast(key);
                    dialog.dismiss();
                }
            }
        });

        builder.setNegativeButton("Cancel",
                new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        try {
                            Field field = dialog.getClass().getSuperclass()
                                    .getDeclaredField("mShowing");
                            field.setAccessible(true);
                            // set true
                            field.setBoolean(dialog, true);
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                        dialog.dismiss();
                    }
                });
        builder.create().show();
    }

    public void showToast(String message) {
        Toast toast = Toast.makeText(this, message, Toast.LENGTH_LONG);
        toast.setGravity(Gravity.CENTER, 0, 0);
        toast.show();
    }

    private ArrayList<Hashtable<String, String>> GetCity() {
        ArrayList<Hashtable<String, String>> listData = new ArrayList<>();

        for (int i=1;i<=100;i++){
            Hashtable<String, String> hmItem = new Hashtable<>();
            hmItem.put(FILENAME, i+"");
            listData.add(hmItem);
        }
        return listData;
    }
}
