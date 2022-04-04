package com.elitedevelopers.todoapp.fragment

import android.app.Application
import android.view.View
import android.widget.AdapterView
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.elitedevelopers.todoapp.R
import com.elitedevelopers.todoapp.data.models.Priority
import com.elitedevelopers.todoapp.data.models.ToDoData

class SharedViewModel(application : Application) : AndroidViewModel(application) {

    val emptyDatabase : MutableLiveData<Boolean> = MutableLiveData(false)

    fun checkIfDatabaseEmpty(toDoData: List<ToDoData>){
        emptyDatabase.value=toDoData.isEmpty()
    }
    //Adapter for color changing in different priority
    val listener : AdapterView.OnItemSelectedListener = object :
        AdapterView.OnItemSelectedListener{
        override fun onItemSelected(
            parent : AdapterView<*>?,
            view: View?,
            position : Int,
            id: Long
        ) {
            when(position){
                0-> { (parent?.getChildAt(0) as TextView).setTextColor(ContextCompat.getColor(application,
                    R.color.red))}
                1-> { (parent?.getChildAt(0) as TextView).setTextColor(ContextCompat.getColor(application,
                    R.color.yellow))}
                2-> { (parent?.getChildAt(0) as TextView).setTextColor(ContextCompat.getColor(application,
                    R.color.green ))}
            }


        }

        override fun onNothingSelected(p0: AdapterView<*>?) {

        }
    }

    //For checking about inserting data
    fun verifyDataFromUser(title : String, description : String) : Boolean{

        return !(title.isEmpty() or description.isEmpty())

    }

    //For converting mPriority string to Priority class object
    fun parsePriority(priority: String) : Priority {
        return when(priority){
            "High Priority" -> {
                Priority.HIGH}
            "Medium Priority" -> {
                Priority.MEDIUM}
            "Low Priority" -> {
                Priority.LOW}
            else -> Priority.LOW

        }
    }


}