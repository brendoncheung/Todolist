package com.alephreach.todolist.domain.Repositories;

import com.alephreach.todolist.domain.Entities.Item;

import java.util.List;

import io.reactivex.Completable;
import io.reactivex.Single;

public interface ItemRepository {

    Single<Item> getItemById(int id);
    Single<List<Item>> getAllItems();

    Completable insertItem(Item item);

    Completable updateItem(Item item);

    Completable deleteItem(Item item);
}
