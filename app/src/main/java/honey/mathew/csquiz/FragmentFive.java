package honey.mathew.csquiz;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import java.util.ArrayList;
import java.util.List;

public class FragmentFive extends Fragment {
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {


        View v = inflater.inflate(R.layout.fragment_five, container, false);

        List<String> ans = new ArrayList<>();
        ans.add("Answer One");
        ans.add("Answer Two");
        ans.add("Answer Three");
        ans.add("Answer Four");

        final ListView lv = v.findViewById(R.id.lst_vw);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(
               getContext(), R.layout.list_item, R.id.lst_txt, ans);

        lv.setAdapter(adapter);

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                String selectedFromList = (lv.getItemAtPosition(i)).toString();
            }
        });
        return v;
    }
}
