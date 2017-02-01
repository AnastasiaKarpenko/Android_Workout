package ws.tilda.anastasia.workout;


import android.app.Activity;
import android.app.ListFragment;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;


/**
 * A simple {@link Fragment} subclass.
 */
public class WorkoutListFragment extends ListFragment {
    //Create nested interface of Listener to make the app listen to the clicks
    interface WorkoutListListener {
        void itemClicked(long id);
    }
    // Create the instance of the interface
    private WorkoutListListener listener;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        //Create new array for names of workouts
        String[] names = new String [Workout.workouts.length];
        for(int i = 0; i < names.length; i++) {
            names[i] = Workout.workouts[i].getName();
        }
        //Create array adapter
        ArrayAdapter<String> listAdapter = new ArrayAdapter<String>(
                inflater.getContext(), android.R.layout.simple_list_item_1,
                names);
        //Link array adapter to the list representation
        setListAdapter(listAdapter);

        return super.onCreateView(inflater, container, savedInstanceState);

    }

    //Attaching fragment to activity, the method is depreciated but I will use it
    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        this.listener = (WorkoutListListener)activity;


    }

    //Let the listener know that the user clicked on a list item
    @Override
    public void onListItemClick(ListView l, View v, int position, long id) {
        if(listener != null) {
            listener.itemClicked(id);
        }
    }

}
