package com.krawczyk.maciej.ui.main

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import com.krawczyk.maciej.R
import com.krawczyk.maciej.databinding.FragmentMainBinding
import com.krawczyk.maciej.ui.adapters.ListItemAdapter
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainFragment : Fragment() {

    private val viewModel: MainViewModel by viewModels()
    private val listItemAdapter = ListItemAdapter()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val binding: FragmentMainBinding = DataBindingUtil.inflate(
            inflater,
            R.layout.fragment_main,
            container,
            false
        )
        binding.let {
            it.lifecycleOwner = this
            it.viewmodel = viewModel
            it.listItemAdapter = listItemAdapter
        }
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewLifecycleOwner.lifecycleScope.launchWhenCreated {
            viewModel.pictures.collect {
                listItemAdapter.apply {
                    Log.e("MACIE", "it = $it")
                    updateAdapter(it)
                    notifyDataSetChanged()
                }
            }
        }
    }
}