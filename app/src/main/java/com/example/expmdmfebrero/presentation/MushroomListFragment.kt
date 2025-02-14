package com.example.expmdmfebrero.presentation

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.expmdmfebrero.databinding.FragmentMushroomListBinding
import com.example.expmdmfebrero.domain.Mushroom
import org.koin.androidx.viewmodel.ext.android.viewModel

class MushroomListFragment : Fragment() {

    private var _binding: FragmentMushroomListBinding? = null
    private val binding get() = _binding!!
    private val viewModel: MushroomListViewModel by viewModel()
    private lateinit var collectionId: String

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentMushroomListBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.loadMushrooms(collectionId)
        setUpObserver()
    }

    private fun setUpObserver() {
        viewModel.uiState.observe(viewLifecycleOwner) { state ->
            bindData(state.mushrooms)
            bindError(state.error)
            bindLoading(state.isLoading)
        }
    }

    private fun bindData(mushrooms: List<Mushroom>?) {
        if (mushrooms != null) {
            binding.apply {
                mushroom1.setMushroom(
                    mushrooms[0].name,
                    mushrooms[0].date,
                    mushrooms[0].description,
                    mushrooms[0].image
                )
                mushroom2.setMushroom(
                    mushrooms[1].name,
                    mushrooms[1].date,
                    mushrooms[1].description,
                    mushrooms[1].image
                )
            }
        }
    }

    private fun bindError(error: Error?) {
        if (error != null) {
            Log.d("@dev", error.toString())
        }
    }

    private fun bindLoading(loading: Boolean) {
        if (loading) {
            Log.d("@dev", "Cargando los datos...")
        }
    }
}