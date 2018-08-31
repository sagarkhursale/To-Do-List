package com.sagar.to_dolist;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;
import android.util.Log;
import com.sagar.to_dolist.database.AppDatabase;
import com.sagar.to_dolist.database.TaskEntry;
import java.util.List;


public class MainViewModel extends AndroidViewModel {

    // Constant for logging
    private static final String TAG = MainViewModel.class.getSimpleName();


    private LiveData<List<TaskEntry>> tasks;


    public MainViewModel(Application application) {
        super(application);
        AppDatabase database = AppDatabase.getInstance(this.getApplication());
        Log.d(TAG, "Actively retrieving the tasks from the DataBase");
        tasks = database.taskDao().loadAllTasks();
    }


    public LiveData<List<TaskEntry>> getTasks() {
        return tasks;
    }


    // END
}
