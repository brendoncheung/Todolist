package com.alephreach.todolist.data.Database.Dao;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

import com.alephreach.todolist.domain.Entities.Item;

import java.util.List;

import io.reactivex.Completable;
import io.reactivex.Single;

@Dao
public interface ItemDao {

    @Query("SELECT * FROM items")
    Single<List<Item>> getAllItems();

    @Query("SELECT * FROM items WHERE group_id=:id")
    Single<List<Item>> getAllItemsByGroupId(int id);

    @Query("SELECT * FROM items where id=:id")
    Single<Item> getItemByItemId(int id);

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    Completable insertItem(Item item);

    @Update
    Completable updateItem(Item item);

    @Delete
    Completable deleteItem(Item item);

}
