package com.example.mytestproject.ui.fragments.main

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.mytestproject.R
import com.example.mytestproject.databinding.FragmentMainBinding
import com.example.mytestproject.ui.fragments.main.viewmodel.adapter.MyPersonsRecyclerAdapter
import com.example.mytestproject.ui.fragments.main.viewmodel.models.Date
import com.example.mytestproject.ui.fragments.main.viewmodel.models.Location
import com.example.mytestproject.ui.fragments.main.viewmodel.models.Person
import com.example.mytestproject.ui.fragments.main.viewmodel.parsers.PersonJsonParser

class MainFragment : Fragment() {
    private var binding: FragmentMainBinding? = null
    private lateinit var mAdapter: MyPersonsRecyclerAdapter

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding = FragmentMainBinding.bind(view)

        if (!this::mAdapter.isInitialized) {

            setAdapterPersons()
        } else {
            if (PersonJsonParser.persons.isEmpty()) {
                setAdapterPersons()
            } else {
                mAdapter.persons = PersonJsonParser.persons
            }
        }

    }

    private fun setAdapterPersons() {
        PersonJsonParser.convert(requireContext())
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onDestroy() {
        super.onDestroy()
        binding = null
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        return inflater.inflate(R.layout.fragment_main, container, false)
    }


}