package com.radityarin.spacexinfo.ui.settings

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.radityarin.spacexinfo.databinding.FragmentSettingsBinding
import com.radityarin.spacexinfo.ui.about.AboutActivity

class SettingsFragment : Fragment() {

    private var _binding: FragmentSettingsBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentSettingsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initView()
    }

    private fun initView() {
        with(binding){
            tvAbout.setOnClickListener {
                startActivity(
                    Intent(
                        binding.root.context,
                        AboutActivity::class.java
                    )
                )
            }
        }
    }
}