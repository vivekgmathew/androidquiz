package honey.mathew.csquiz;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class FragmentThree extends Fragment {

    Question q;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {

        Intent i = getActivity().getIntent();
        q = (Question) i.getSerializableExtra("q");
        View v =  inflater.inflate(R.layout.fragment_three, container, false);

        RadioButton rbOne = v.findViewById(R.id.rb_one);
        RadioButton rbTwo = v.findViewById(R.id.rb_two);
        RadioButton rbThree = v.findViewById(R.id.rb_three);
        RadioButton rbFour = v.findViewById(R.id.rb_four);

        TextView tv = v.findViewById(R.id.q3);

        tv.setText(q.getQuestion());
        rbOne.setText(q.getChoiceOne());
        rbTwo.setText(q.getChoiceTwo());
        rbThree.setText(q.getChoiceThree());
        rbFour.setText(q.getChoiceFour());

        final MainActivity ma = (MainActivity) getActivity();

        rbOne.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        String text = ((RadioButton) view).getText().toString();
                        if (text.equals(q.getAnswer())) {
                            ma.q3Score += 1;
                        } else {
                            if (ma.q3Score > 0) ma.q3Score -= 1;
                        }
                    }
                }
        );

        rbTwo.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        String text = ((RadioButton) view).getText().toString();
                        if (text.equals(q.getAnswer())) {
                            ma.q3Score += 1;
                        } else {
                            if (ma.q3Score > 0) ma.q3Score -= 1;
                        }
                    }
                }
        );

        rbThree.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        String text = ((RadioButton) view).getText().toString();
                        if (text.equals(q.getAnswer())) {
                            ma.q3Score += 1;
                        } else {
                            if (ma.q3Score > 0) ma.q3Score -= 1;
                        }
                    }
                }
        );

        rbFour.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        String text = ((RadioButton) view).getText().toString();
                        if (text.equals(q.getAnswer())) {
                            ma.q3Score += 1;
                        } else {
                            if (ma.q3Score > 0) ma.q3Score -= 1;
                        }
                    }
                }
        );
        return v;
    }
}
