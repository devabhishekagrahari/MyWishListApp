package dev.abhishekagrahari.mywishlistapp

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dev.abhishekagrahari.mywishlistapp.data.Wish
import dev.abhishekagrahari.mywishlistapp.data.Wishrepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.launch

class WishViewModel(
    private val wishRepository: Wishrepository = Graph.wishRepository
):ViewModel() {
    var wishTitleState by mutableStateOf("")
    var wishDescriptionState by mutableStateOf("")


    fun onWishTitleChanged(newString:String){
        wishTitleState = newString
    }

    fun onWishDescriptionState(newString: String){
        wishDescriptionState = newString
    }
    lateinit var getAllWishes: Flow<List<Wish>>
    init {
        viewModelScope.launch{
            getAllWishes = wishRepository.getWishes()
        }
    }

    fun addWish(wish: Wish){
        viewModelScope.launch (Dispatchers.IO){
            wishRepository.addWish(wish =  wish)
        }
    }
    fun updateWish(wish: Wish){
        viewModelScope.launch (Dispatchers.IO){
            wishRepository.updateWish(wish =  wish)
        }
    }
    fun getWishById(id:Long):Flow<Wish>{
        return wishRepository.getWishById(id)
    }
    fun deleteWish(wish: Wish){
        viewModelScope.launch (Dispatchers.IO){
            wishRepository.deleteWish(wish =  wish)
        }
    }
}