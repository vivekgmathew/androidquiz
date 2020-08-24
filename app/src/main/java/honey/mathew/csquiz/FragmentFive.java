package honey.mathew.csquiz;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import java.util.ArrayList;
import java.util.List;

public class FragmentFive extends Fragment {

    Question q;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {

        Intent i = getActivity().getIntent();
        q = (Question) i.getSerializableExtra("q");
        View v =  inflater.inflate(R.layout.fragment_five, container, false);

        TextView tv = v.findViewById(R.id.q5);
        tv.setText(q.getQuestion());

        List<String> ans = new ArrayList<>();
        ans.add(q.getChoiceOne());
        ans.add(q.getChoiceTwo());
        ans.add(q.getChoiceThree());
        ans.add(q.getChoiceFour());
        final MainActivity ma = (MainActivity) getActivity();
        final ListView lv = v.findViewById(R.id.lst_vw);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(
               getContext(), R.layout.list_item, R.id.lst_txt, ans);

        lv.setAdapter(adapter);

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                String selectedFromList = (lv.getItemAtPosition(i)).toString();
                if (selectedFromList.equals(q.getAnswer())) {
                    if (ma.q5Score < 1) {
                        ma.q5Score += 1;
                    }
                } else {
                    if (ma.q5Score > 0 ) ma.q5Score -= 1;
                }
            }
        });
        return v;
    }
}
