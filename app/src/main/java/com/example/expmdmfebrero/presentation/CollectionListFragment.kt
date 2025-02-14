package com.example.expmdmfebrero.presentation

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.expmdmfebrero.databinding.FragmentCollectionListBinding
import com.example.expmdmfebrero.domain.Collection
import org.koin.androidx.viewmodel.ext.android.viewModel

class CollectionListFragment : Fragment() {

    private var _binding: FragmentCollectionListBinding? = null
    private val binding get() = _binding!!
    private val viewModel: CollectionViewModel by viewModel()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentCollectionListBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.loadCollections()
        setUpObserver()
    }

    private fun setUpObserver() {
        viewModel.uiState.observe(viewLifecycleOwner) { state ->
            bindData(state.collections)
            bindError(state.error)
            bindLoading(state.isLoading)
        }
    }

    private fun bindData(collections: List<Collection>?) {
        if (collections != null) {
            binding.apply {
                collection1.setMushroom(collections[0].name)
                collection2.setMushroom(collections[1].name)
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