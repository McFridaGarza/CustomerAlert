package macguffinco.hellrazorbarber.Activities.Dashboard;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.NotificationCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.nex3z.notificationbadge.NotificationBadge;

import macguffinco.hellrazorbarber.DescriptionActivity;
import macguffinco.hellrazorbarber.Logic.TormundManager;
import macguffinco.hellrazorbarber.Macguffin_Code_Activity;
import macguffinco.hellrazorbarber.MainActivity;
import macguffinco.hellrazorbarber.R;

public class ChatFragment extends Fragment {
    public static final String TAG = ChatFragment.class.getSimpleName();
Button agendar;
TextView textView;

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
       View view= inflater.inflate(R.layout.activity_chat_fragment,container,false);

        agendar=(Button)view.findViewById(R.id.agendarcita);
        agendar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TormundManager.goDatesScreen(getContext());

            }
        });
        textView=view.findViewById(R.id.number_to_call);
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TextView textView = (TextView) v.findViewById(R.id.number_to_call);
                String phoneNumber = String.format("tel: %s",textView.getText().toString());
                // Create the intent.
                Intent dialIntent = new Intent(Intent.ACTION_DIAL);
                // Set the data for the intent as the phone number.
                dialIntent.setData(Uri.parse(phoneNumber));
                // If package resolves to an app, send intent.
                if (dialIntent.resolveActivity(getActivity().getPackageManager()) != null) {
                    getActivity().startActivity(dialIntent);
                } else {
                    Log.e(TAG, "Can't resolve app for ACTION_DIAL Intent.");
                }

            }
        });
    return view;
    }
    public void dialNumber(View view)
    {
        TextView textView = (TextView) view.findViewById(R.id.number_to_call);
        // Use format with "tel:" and phone number to create phoneNumber.
        String phoneNumber = String.format("tel: %s",
                textView.getText().toString());
        // Create the intent.
        Intent dialIntent = new Intent(Intent.ACTION_DIAL);
        // Set the data for the intent as the phone number.
        dialIntent.setData(Uri.parse(phoneNumber));
        // If package resolves to an app, send intent.
        if (dialIntent.resolveActivity(getActivity().getPackageManager()) != null) {
            getActivity().startActivity(dialIntent);
        } else {
            Log.e(TAG, "Can't resolve app for ACTION_DIAL Intent.");
        }

    }

}