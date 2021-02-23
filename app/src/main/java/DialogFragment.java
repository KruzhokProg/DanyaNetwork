import android.view.LayoutInflater;
import android.view.View;

import androidx.appcompat.app.AppCompatDialogFragment;

import com.example.danyanetwork.R;

public class DialogFragment extends androidx.fragment.app.DialogFragment {
    View view = LayoutInflater.from(getContext()).inflate(R.layout.forget_emai_dialog,null);

}
