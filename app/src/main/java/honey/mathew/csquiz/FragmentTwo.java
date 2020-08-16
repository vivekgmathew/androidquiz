package honey.mathew.csquiz;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class FragmentTwo extends Fragment {

    Question q;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {

        Intent i = getActivity().getIntent();
        q = (Question) i.getSerializableExtra("q");
        View v = inflater.inflate(R.layout.fragment_two, container, false);

        CheckBox chOne = v.findViewById(R.id.chk_q_1);
        CheckBox chTwo = v.findViewById(R.id.chk_q_2);
        CheckBox chThree = v.findViewById(R.id.chk_q_3);
        CheckBox chFour = v.findViewById(R.id.chk_q_4);

        TextView tv = v.findViewById(R.id.q2);

        tv.setText(q.getQuestion());

        final MainActivity ma = (MainActivity) getActivity();

        chOne.setText(q.getChoiceOne());
        chTwo.setText(q.getChoiceTwo());
        chThree.setText(q.getChoiceThree());
        chFour.setText(q.getChoiceFour());

        chOne.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton cb, boolean b) {
                if (cb.isChecked()) {
                    if (cb.getText().equals(q.getAnswer())) {
                        ma.q2Score += 1;
                    } else {
                        if (ma.q2Score > 0 ) ma.q2Score -= 1;
                    }
                }
            }
        });

        chTwo.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton cb, boolean b) {
                if (cb.isChecked()) {
                    if (cb.getText().equals(q.getAnswer())) {
                        ma.q2Score += 1;
                    } else {
                        if (ma.q2Score > 0 ) ma.q2Score -= 1;
                    }
                }
            }
        });

        chThree.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton cb, boolean b) {
                if (cb.isChecked()) {
                    if (cb.getText().equals(q.getAnswer())) {
                        ma.q2Score += 1;
                    } else {
                        if (ma.q2Score > 0 ) ma.q2Score -= 1;
                    }
                }
            }
        });

        chFour.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton cb, boolean b) {
                if (cb.isChecked()) {
                    if (cb.getText().equals(q.getAnswer())) {
                        ma.q2Score += 1;
                    } else {
                        if (ma.q2Score > 0 ) ma.q2Score -= 1;
                    }
                }
            }
        });
        return v;
    }
}
