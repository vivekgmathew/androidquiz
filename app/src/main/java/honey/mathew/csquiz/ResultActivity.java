package honey.mathew.csquiz;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.util.Log;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class ResultActivity extends AppCompatActivity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d("QF", "Second activity");
        setContentView(R.layout.activity_result);
        Log.d("QF", "Second activity loaded");
    }
}
