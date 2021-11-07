package org.otunjargych.weatherobserve.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import org.otunjargych.weatherobserve.R
import org.otunjargych.weatherobserve.databinding.FragmentWeatherBinding
import org.otunjargych.weatherobserve.model.Data
import org.otunjargych.weatherobserve.model.Resource
import org.otunjargych.weatherobserve.ui.adapter.WeatherAdapter
import org.otunjargych.weatherobserve.ui.viewmodel.MainViewModel
import org.otunjargych.weatherobserve.util.RecyclerViewDisabler


class WeatherFragment : Fragment() {

    private var _binding: FragmentWeatherBinding? = null
    private val binding get() = _binding!!
    private var adapter: WeatherAdapter? = null
    private val mViewModel: MainViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentWeatherBinding.inflate(inflater, container, false)


        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initViews()
        var bundle = requireArguments().getSerializable("city") as String

        observeData()
        mViewModel.loadData(bundle, requireContext())
    }


    private fun observeData() {
        mViewModel.data.observe(viewLifecycleOwner, { status ->
            when (status) {
                is Resource.Loading -> {
                    binding.shimmerFrameLayout.startShimmer()
                }
                is Resource.Success -> {
                    status.data.let {
                        if (it != null) {
                            val list = ArrayList<Data>()
                            list.clear()
                            list.add(it)
                            adapter?.swapData(list)
                            showViews()
                        }
                        Toast.makeText(requireContext(), it?.cityName, Toast.LENGTH_SHORT).show()
                    }
                }
                is Resource.NoConnection -> {
                    Toast.makeText(requireContext(), R.string.connection_info, Toast.LENGTH_SHORT)
                        .show()
                }
            }

        })
    }


    private fun initViews() {
        val lol = "lol"
        val hello = "Hello my friend"
        adapter = WeatherAdapter(requireContext())
        val disabler: RecyclerView.OnItemTouchListener = RecyclerViewDisabler()
        binding.listWeather.addOnItemTouchListener(disabler)
        binding.listWeather.removeOnItemTouchListener(disabler)
        binding.listWeather.layoutManager = LinearLayoutManager(
            requireContext(),
            LinearLayoutManager.VERTICAL,
            false
        )
        binding.listWeather.adapter = adapter
        binding.listWeather.setHasFixedSize(true)
    }

    private fun showViews() {
        with(binding) {
            shimmerFrameLayout.stopShimmer()
            shimmerFrameLayout.visibility = View.GONE
        }
        binding.listWeather.visibility = View.VISIBLE
    }
}