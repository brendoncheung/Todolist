package com.alephreach.todolist.data.Database.Dao;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

import com.alephreach.todolist.domain.Entities.Group;

import java.util.List;

import io.reactivex.Completable;
import io.reactivex.Single;

@Dao
public interface GroupDao {

    @Query("SELECT * FROM `groups` WHERE id IN (:id)")
    public Single<Group> getGroupById(int id);

    @Query("SELECT * FROM groups")
    public Single<List<Group>> getAllGroups();

    @Insert
    public Completable addGroup(Group group);

    @Update(onConflict = OnConflictStrategy.REPLACE)
    public Completable updateGroupById(Group group);

    @Delete
    public Completable deleteGroup(Group group);
}
