package com.vm.virginmoney.ui.room

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.vm.virginmoney.data.model.Room
import com.vm.virginmoney.data.service.Resource
import com.vm.virginmoney.databinding.FragmentRoomBinding
import dagger.hilt.android.AndroidEntryPoint
import java.util.*

@AndroidEntryPoint
class RoomFragment : Fragment() {

    private val _roomViewModel: RoomViewModel by viewModels()
    private lateinit var _binding: FragmentRoomBinding
    private lateinit var _adapter: RoomListAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentRoomBinding.inflate(inflater, container, false)
        return _binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupObservers()
    }

    private fun setupObservers() {
        _roomViewModel.room.observe(viewLifecycleOwner, Observer {
            when (it.status) {
                Resource.Status.SUCCESS -> {
                    _binding.progressBar.visibility = View.GONE
                    if (!it.data.isNullOrEmpty()) {
                        setRoomListAdapter(ArrayList(it.data))
                    }
                }
                Resource.Status.ERROR ->
                    Toast.makeText(requireContext(), it.message, Toast.LENGTH_SHORT).show()

                Resource.Status.LOADING ->
                    _binding.progressBar.visibility = View.VISIBLE
            }
        })
    }

    private fun setRoomListAdapter(dataSet: ArrayList<Room>) {
        _adapter = RoomListAdapter(dataSet)
        _binding.roomRecyclerId.layoutManager = LinearLayoutManager(requireContext())
        _binding.roomRecyclerId.adapter = _adapter
    }
}