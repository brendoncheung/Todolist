package com.alephreach.todolist.data.Repositories;

import com.alephreach.todolist.data.Database.Dao.ItemDao;
import com.alephreach.todolist.domain.Entities.Item;
import com.alephreach.todolist.domain.Repositories.ItemRepository;

import java.util.List;

import io.reactivex.Completable;
import io.reactivex.Single;

public class ItemRepositoryImpl implements ItemRepository {

    private final ItemDao mItemDao;

    public ItemRepositoryImpl(ItemDao dao) {
        mItemDao = dao;
    }

    @Override
    public Single<Item> getItemById(int id) {
        return mItemDao.getItemByItemId(id);
    }

    @Override
    public Single<List<Item>> getAllItems() {
        return mItemDao.getAllItems();
    }

    @Override
    public Completable insertItem(Item item) {
        return mItemDao.insertItem(item);
    }

    @Override
    public Completable updateItem(Item item) {
        return mItemDao.updateItem(item);
    }

    @Override
    public Completable deleteItem(Item item) {
        return mItemDao.deleteItem(item);
    }
}
