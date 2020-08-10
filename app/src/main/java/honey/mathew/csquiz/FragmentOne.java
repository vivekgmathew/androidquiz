package honey.mathew.csquiz;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class FragmentOne extends Fragment {

    Question q;
    String selectedAnswer = "";

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        Intent i = getActivity().getIntent();
        q = (Question) i.getSerializableExtra("q");
        View v = inflater.inflate(R.layout.fragment_one, container, false);

        Button btnOne = v.findViewById(R.id.btn_q_1);
        Button btnTwo = v.findViewById(R.id.btn_q_2);
        Button btnThree = v.findViewById(R.id.btn_q_3);
        Button btnFour = v.findViewById(R.id.btn_q_4);

        TextView tv = v.findViewById(R.id.q);

        tv.setText(q.getQuestion());
        btnOne.setText(q.getChoiceOne());
        btnTwo.setText(q.getChoiceTwo());
        btnThree.setText(q.getChoiceThree());
        btnFour.setText(q.getChoiceFour());


        btnOne.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Button b = (Button) view;
                selectedAnswer = b.getText().toString();
                if (selectedAnswer.equals(q.getAnswer())) {
                    MainActivity ma = (MainActivity) getActivity();
                    ma.score += 1;
                }
            }
        });

        btnTwo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Button b = (Button) view;
                selectedAnswer = b.getText().toString();
                if (selectedAnswer.equals(q.getAnswer())) {
                    MainActivity ma = (MainActivity) getActivity();
                    ma.score += 1;
                }
            }
        });

        btnThree.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Button b = (Button) view;
                selectedAnswer = b.getText().toString();
                if (selectedAnswer.equals(q.getAnswer())) {
                    MainActivity ma = (MainActivity) getActivity();
                    ma.score += 1;
                }
            }
        });

        btnFour.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Button b = (Button) view;
                selectedAnswer = b.getText().toString();
                if (selectedAnswer.equals(q.getAnswer())) {
                    MainActivity ma = (MainActivity) getActivity();
                    ma.score += 1;
                }
            }
        });
        return v;
    }
}
