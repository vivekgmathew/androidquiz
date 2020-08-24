package honey.mathew.csquiz;

import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class ResultActivity extends AppCompatActivity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d("QF", "Second activity");
        setContentView(R.layout.activity_result);
        Log.d("QF", "Second activity loaded");

        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            int score = extras.getInt("score");
            TextView scoreView = findViewById(R.id.score_tv);
            scoreView.setText("You have scored " + score + " out of 5");
            String msg = "";
            if (score < 3) msg = "Please try again!";
            else if (score == 3) msg = "Good job!";
            else if (score == 4) msg = "Excellent work!";
            else msg = "You are a genius";

            TextView msgText = findViewById(R.id.score_msg);
            msgText.setText(msg);
        }

        Button tryButton = findViewById(R.id.btn_try);
        tryButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent resIntent = new Intent(ResultActivity.this, MainActivity.class);
                ResultActivity.this.startActivity(resIntent);
            }
        });

        Button stopButton = findViewById(R.id.btn_stop);
        stopButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent resIntent = new Intent(ResultActivity.this, FirstActivity.class);
                ResultActivity.this.startActivity(resIntent);
            }
        });
    }
}
