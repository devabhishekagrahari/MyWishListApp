package dev.abhishekagrahari.mywishlistapp

import android.content.Context
import androidx.room.Room
import dev.abhishekagrahari.mywishlistapp.data.WishDatabase
import dev.abhishekagrahari.mywishlistapp.data.Wishrepository

object Graph {
    lateinit var database: WishDatabase

    val wishRepository by lazy {
        Wishrepository(wishDao = database.wishDao())
    }
    fun provide(context: Context){
        database= Room.databaseBuilder(context, WishDatabase::class.java, "wishlist.db").build()
    }

}