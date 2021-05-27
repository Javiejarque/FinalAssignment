package com.example.finalassignment

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.navigation.findNavController


class MenuFragment : Fragment() {

    private lateinit var viewModel: MenuViewModel
    private lateinit var binding: MenuFragmentBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(R.layout.menu_fragment, container, false)
        viewModel = ViewModelProvider(this).get(MenuViewModel::class.java)
        binding.viewmodel =viewModel

        viewModel.navigateToCallFragment.observe(viewLifecycleOwner, Observer {
            if(it){
                navigateToCallFragment()
            }
        })
        viewModel.navigateToLoginFragment.observe(viewLifecycleOwner, Observer {
            if(it){
                navigateToLoginFragment()
            }
        })



        return binding.root
    }

    fun navigateToCallFragment(){
    requireView().findNavController().navigate(R.id.action_menuFragment_to_callFragment)
    viewModel.navigationCallFinished()
    }
    fun navigateToLoginFragment(){
        requireView().findNavController().navigate(R.id.action_menuFragment_to_loginFragment)
        viewModel.navigationLoginFinished()
    }
    fun navigateToChatFragment(){
        requireView().findNavController().navigate(R.id.action_menuFragment_to_chatFragment)
        viewModel.navigationChatFinished()
    }

}