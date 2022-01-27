package com.test.velolibreservice.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.navigation.fragment.findNavController
import com.test.velolibreservice.data.models.State
import com.test.velolibreservice.databinding.FragmentStationListBinding
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class StationListFragment : Fragment() {

    private var _viewBinding: FragmentStationListBinding? = null
    private val viewBinding: FragmentStationListBinding get() = _viewBinding!!
    private val stationViewModel: StationViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _viewBinding = FragmentStationListBinding.inflate(
            inflater,
            container, false
        )
        return viewBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED) {
                stationViewModel.getStations()
            }
        }
        val adapter = StationListAdapter{
            val direction = StationListFragmentDirections
                .actionStationListFragmentToStationDetailsFragment(it)
            findNavController().navigate(direction)
        }
        viewBinding.rvStation.adapter = adapter
        stationViewModel.stationsLiveData.observe(viewLifecycleOwner){
            when(it){
                is State.LoadingState -> {
                    viewBinding.pbLoading.visibility = View.VISIBLE
                }
                is State.ErrorState ->{
                    viewBinding.pbLoading.visibility = View.GONE
                    Toast.makeText(context?.applicationContext , it.exception.message , Toast.LENGTH_LONG).show()
                }
                is State.DataState ->{
                    viewBinding.pbLoading.visibility = View.GONE
                    adapter.submitList(it.data)
                }
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _viewBinding = null
    }
}