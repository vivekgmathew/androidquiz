package honey.mathew.csquiz;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    FragmentTwo fTwo = null;
    FragmentThree fThree = null;
    FragmentFour fFour = null;
    FragmentFive fFive = null;

    Question question;

    public int score = 0;

    List<Question> questions = new ArrayList<Question>();
    List<Integer> chosenQuestions = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        questions.add(new Question("Which below language is not an OO language",
                                  "C++", "Java", "C", "C#",
                                  "C"));
        questions.add(new Question("Which below option is a client side web language",
                "JavaScript", "Java", "C#", "Python", "JavaScript"));

        Random r = new Random();
        int index = r.nextInt(1);
        question = questions.get(index);
        getIntent().putExtra("q", question);

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final FragmentOne fOne = new FragmentOne();
        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        ft.add(R.id.f_container, fOne, "Fragment One");
        ft.commit();
        final int[] qNo = {1};
        final TextView qnText = findViewById(R.id.text_qn);
        qnText.setText(question.getQuestion());

        Button nextButton = findViewById(R.id.next_btn);
        qnText.setText("Your are answering question : 1/5");
        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                qNo[0] = qNo[0] + 1;
                if (qNo[0] <= 5)
                    qnText.setText("Your are answering question : " + qNo[0] + "/5");

                FragmentManager fm = getSupportFragmentManager();
                FragmentTransaction ft = fm.beginTransaction();

                switch (qNo[0]) {
                    case 2: {
                        question = questions.get(1);
                        getIntent().putExtra("q", question);
                        fTwo = new FragmentTwo();
                        ft.remove(fOne);
                        ft.add(R.id.f_container, fTwo, "Fragment Two");
                        ft.commit();
                    }
                    break;
                    case 3: {
                        fThree = new FragmentThree();
                        ft.remove(fTwo);
                        ft.add(R.id.f_container, fThree, "Fragment Three");
                        ft.commit();
                    }
                    break;
                    case 4: {
                        fFour = new FragmentFour();
                        ft.remove(fThree);
                        ft.add(R.id.f_container, fFour, "Fragment Four");
                        ft.commit();
                    }
                    break;
                    case 5: {
                        fFive = new FragmentFive();
                        ft.remove(fFour);
                        ft.add(R.id.f_container, fFive, "Fragment Five");
                        ft.commit();
                    }
                }

                if (qNo[0] == 6) {
                    Intent myIntent = new Intent(MainActivity.this, ResultActivity.class);
                    myIntent.putExtra("score", 4);
                    MainActivity.this.startActivity(myIntent);
                }
            }
        });
    }

    public void onClick(final View v) {
        int id = v.getId();
        String msg = "";
        if (id == R.id.img_java) msg = "Correct Answer";
        else msg = "Wrong Answer";
        Toast.makeText(MainActivity.this, msg, Toast.LENGTH_SHORT).show();
    }
}