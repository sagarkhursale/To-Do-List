package com.sagar.to_dolist;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.ViewModel;

import com.sagar.to_dolist.database.AppDatabase;
import com.sagar.to_dolist.database.TaskEntry;


public class AddTaskViewModel extends ViewModel {

    private LiveData<TaskEntry> task;


    AddTaskViewModel(AppDatabase database, int taskId) {
        task = database.taskDao().loadTaskById(taskId);
    }


    public LiveData<TaskEntry> getTask() {
        return task;
    }

    // END
}
