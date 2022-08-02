package com.example.mytestproject.ui.fragments.main

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import com.example.mytestproject.R
import com.example.mytestproject.databinding.FragmentMainBinding
import com.example.mytestproject.ui.fragments.main.viewmodel.MainViewModel
import com.example.mytestproject.ui.fragments.main.viewmodel.adapter.MyPersonsRecyclerAdapter
import com.example.mytestproject.ui.fragments.main.viewmodel.parsers.PersonJsonParser

class MainFragment : Fragment() {
    private var binding: FragmentMainBinding? = null
    private lateinit var mAdapter: MyPersonsRecyclerAdapter
    private lateinit var mViewModel : MainViewModel

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        PersonJsonParser.getJsonObjects(requireContext())


        binding = FragmentMainBinding.bind(view)
        mViewModel = MainViewModel(requireContext())

        if (!this::mAdapter.isInitialized) {
            mAdapter = MyPersonsRecyclerAdapter()
            setAdapterPersons()
        } else {
            if (PersonJsonParser.persons.isEmpty()) {
                setAdapterPersons()
            } else {
                mAdapter.persons = PersonJsonParser.persons
            }
        }

        binding!!.recyclerView.adapter = mAdapter
        binding!!.recyclerView.layoutManager = GridLayoutManager(context, 2)


    }

    private fun setAdapterPersons() {
        mViewModel.updateListUsers(requireContext())
        mAdapter.persons = PersonJsonParser.persons
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        return inflater.inflate(R.layout.fragment_main, container, false)
    }


}