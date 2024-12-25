package dev.abhishekagrahari.mywishlistapp.data

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "wish-table")
data class Wish(
    @PrimaryKey(autoGenerate = true)
    val id: Long =10L,
    @ColumnInfo(name="wish-title")
    val title: String = "",
    @ColumnInfo(name="wish-description")
    val description: String=""
)

object DummyWish{
    val wishList = listOf(
        Wish(title = "Google Watch 2" , description = "An Android Watch"),
        Wish(title = "Oculus Quest 2" , description = "A VR headset for playing games"),
        Wish(title = "A Sci-fi Book" , description = "A science fiction book from any best seller"),
        Wish(title = "Google Watch 2" , description = "An Android Watch"),
        Wish(title = "Google Watch 2" , description = "An Android Watch"),
    )
}
