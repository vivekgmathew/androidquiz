package honey.mathew.csquiz;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class FragmentFour extends Fragment {
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_four, container, false);

        ImageView imgGo = v.findViewById(R.id.img_go);
        ImageView imgJava = v.findViewById(R.id.img_java);
        ImageView imgPython = v.findViewById(R.id.img_py);
        ImageView imgJs = v.findViewById(R.id.img_js);

        final MainActivity ma = (MainActivity) getActivity();

        imgGo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (ma.q4Score > 0) {
                    ma.q4Score -= 1;
                }
            }
        });

        imgJs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (ma.q4Score > 0) {
                    ma.q4Score -= 1;
                }
            }
        });

        imgPython.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (ma.q4Score > 0) {
                    ma.q4Score -= 1;
                }
            }
        });

        imgJava.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (ma.q4Score < 1) {
                    ma.q4Score += 1;
                }
            }
        });
        return v;
    }
}
