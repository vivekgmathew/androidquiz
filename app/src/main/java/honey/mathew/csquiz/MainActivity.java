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
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;

public class MainActivity extends AppCompatActivity {

    FragmentTwo fTwo = null;
    FragmentThree fThree = null;
    FragmentFour fFour = null;
    FragmentFive fFive = null;

    Question question;

    public int q1Score = 0;
    public int q2Score = 0;
    public int q3Score = 0;
    public int q4Score = 0;
    public int q5Score = 0;

    public int score = 0;

    List<Question> questions = new ArrayList<Question>();
    List<Integer> chosenQuestions = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        questions.add(new Question("Which below language is not an OO language ?",
                                  "C++", "Java", "C", "C#",
                                  "C"));
        questions.add(new Question("Which below option is a client side web language ?",
                "JavaScript", "Java", "C#", "Python", "JavaScript"));

        questions.add(new Question("Which below option is not a client side JS framework ?",
                "React", "Node", "Angular", "View", "Node"
        ));

        questions.add(new Question("Which below framework is a server side JS framework ?",
                "Express", "Angular", "React", "Vue", "Express"));

        questions.add(new Question("In addition to Java, Which below language supports Android development ?",
                "Go", "Python", "Scala", "Kotlin", "Kotlin"));

        questions.add(new Question("Which below option is a Java Script Runtime ?", "Go", "Node",
                "Python", "Android", "Node"));

        questions.add(new Question("Which below database is NoSQL database ?", "Mysql", "PostgreSQL",
                "MongoDB", "express", "MongoDB"));

        questions.add(new Question("Which below language support iPhone application development",
                "Java", "Kotlin", "Swift", "Python", "Swift"));

        questions.add(new Question("Which below option is not a cloud platform", "Aws", "Gcp", "Azure",
                "Windows", "Windows"));

        // Select 5 questions randomly
        Random r = new Random();
        Set<Integer> qs = new HashSet<Integer>();
        while (qs.size() < 5) {
            qs.add((r.nextInt(9)));
        }

        final List<Question> dspQuestions = new ArrayList<>();
        for(Integer q: qs) {
            dspQuestions.add(questions.get(q));
        }

        question = dspQuestions.get(0);
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
                        question = dspQuestions.get(1);
                        getIntent().putExtra("q", question);
                        fTwo = new FragmentTwo();
                        ft.remove(fOne);
                        ft.add(R.id.f_container, fTwo, "Fragment Two");
                        ft.commit();
                    }
                    break;
                    case 3: {
                        question = dspQuestions.get(2);
                        getIntent().putExtra("q", question);
                        fThree = new FragmentThree();
                        ft.remove(fTwo);
                        ft.add(R.id.f_container, fThree, "Fragment Three");
                        ft.commit();
                    }
                    break;
                    case 4: {
                        question = dspQuestions.get(3);
                        getIntent().putExtra("q", question);
                        fFour = new FragmentFour();
                        ft.remove(fThree);
                        ft.add(R.id.f_container, fFour, "Fragment Four");
                        ft.commit();
                    }
                    break;
                    case 5: {
                        question = dspQuestions.get(4);
                        getIntent().putExtra("q", question);
                        fFive = new FragmentFive();
                        ft.remove(fFour);
                        ft.add(R.id.f_container, fFive, "Fragment Five");
                        ft.commit();
                    }
                }

                if (qNo[0] == 6) {
                    score = q1Score + q2Score + q3Score + q4Score + q5Score;
                    Intent resIntent = new Intent(MainActivity.this, ResultActivity.class);
                    resIntent.putExtra("score", score);
                    MainActivity.this.startActivity(resIntent);
                }
            }
        });
    }
}