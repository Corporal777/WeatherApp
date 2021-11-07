package org.otunjargych.weatherobserve.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction
import androidx.fragment.app.commit
import org.otunjargych.weatherobserve.R
import org.otunjargych.weatherobserve.databinding.FragmentMainBinding


class MainFragment : Fragment() {

    private var _binding: FragmentMainBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentMainBinding.inflate(inflater, container, false)

        binding.btnNext.setOnClickListener {
            val str = binding.etCityName.text.toString()

            if (!str.isNullOrEmpty()) {
                replaceFragment(WeatherFragment(), str)
            } else Toast.makeText(requireContext(), R.string.empty_field, Toast.LENGTH_SHORT)
                .show()
        }

        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

    }

    private fun replaceFragment(fragment: Fragment, string: String) {

        val bundle = Bundle()
        bundle.putSerializable("city", string)
        fragment.arguments = bundle
        requireActivity().supportFragmentManager.commit {
            setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
            setReorderingAllowed(true)
            addToBackStack(null)
            replace(R.id.fragment_container, fragment)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}