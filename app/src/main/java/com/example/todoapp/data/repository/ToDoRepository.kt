package com.example.todoapp.data.repository

import androidx.lifecycle.LiveData
import com.example.todoapp.data.ToDoDao
import com.example.todoapp.data.models.ToDoData

class ToDoRepository(private val ToDoDao : ToDoDao) {
    val getAllData : LiveData<List<ToDoData>> = ToDoDao.getAllData()
    val sortByHighPriority : LiveData<List<ToDoData>> = ToDoDao.sortByHighPriority()
    val sortByLowPriority : LiveData<List<ToDoData>> = ToDoDao.sortByLowPriority()

    suspend fun insertData(toDoData : ToDoData){
        ToDoDao.insertData(toDoData)
    }
    suspend fun updateDate(toDoData: ToDoData){
        ToDoDao.updateData(toDoData)
    }

    suspend fun deleteData(toDoData: ToDoData){
        ToDoDao.deleteItem(toDoData)
    }

    suspend fun deleteAll(){
        ToDoDao.deleteAll()
    }

    fun searchDatabase(searchQuery: String) : LiveData<List<ToDoData>>{
        return ToDoDao.searchDatabase(searchQuery)
    }
}