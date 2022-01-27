package com.test.velolibreservice.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import com.test.velolibreservice.databinding.FragmentStationDetailsBinding

class StationDetailsFragment : Fragment() {

    private var _viewBinding: FragmentStationDetailsBinding? = null
    private val viewBinding: FragmentStationDetailsBinding get() = _viewBinding!!
    private val args: StationDetailsFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _viewBinding = FragmentStationDetailsBinding.inflate(inflater, container, false)
        return viewBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val station = args.station
        with(viewBinding){
            tvAddress.text = station.address
            tvStatus.text = station.status
            tvBikeStands.text = station.bikeStands.toString()
            tvAvailableBike.text = station.availableBikes.toString()
            tvContractName.text = station.contractName
            tvNumber.text = station.number.toString()

        }
    }
    override fun onDestroyView() {
        super.onDestroyView()
        _viewBinding = null
    }
}