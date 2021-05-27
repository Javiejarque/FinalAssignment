package com.example.finalassignment

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MenuViewModel : ViewModel() {

    private var _navigateToCallFragment = MutableLiveData<Boolean>()

    val navigateToCallFragment : LiveData<Boolean>
        get(){
            return _navigateToCallFragment

        }

    private var _navigateToLoginFragment = MutableLiveData<Boolean>()
    val navigateToLoginFragment : LiveData<Boolean>
    get(){
        return _navigateToLoginFragment
    }

    private var _navigateToChatFragment = MutableLiveData<Boolean>()
    val navigateToChatFragment : LiveData<Boolean>
    get(){
        return _navigateToChatFragment
    }

    init{
        _navigateToCallFragment.value = false
        _navigateToLoginFragment.value = false
        _navigateToChatFragment.value = false
    }

    fun navigateCallClicked(){
         _navigateToCallFragment.value = true
    }
    fun navigateLoginClicked(){
        _navigateToLoginFragment.value = true
    }
    fun navigateChatClicked(){
        _navigateToChatFragment.value = true
    }



    fun navigationCallFinished() {
        _navigateToCallFragment.value = false
    }

    fun navigationLoginFinished(){
        _navigateToLoginFragment.value = false
    }
    fun navigationChatFinished(){
        _navigateToChatFragment.value = false
    }

}