package com.radityarin.spacexinfo.ui.about

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import com.radityarin.spacexinfo.R
import com.radityarin.spacexinfo.data.model.company.Company
import com.radityarin.spacexinfo.databinding.ActivityAboutBinding
import org.koin.androidx.viewmodel.ext.android.viewModel

class AboutActivity : AppCompatActivity() {

    private val viewModel by viewModel<AboutActivityViewModel>()
    private lateinit var binding: ActivityAboutBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAboutBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initViews()
        observe()
    }


    private fun initViews() {
        supportActionBar?.title = getString(R.string.about_company)
        viewModel.getAboutCompany()
    }


    private fun observe() {
        viewModel.companyItems.observe(this, Observer {
            onDataLoad(it)
        })
    }

    private fun onDataLoad(it: Company?) {
        with(binding){
            tvCompanySummary.text = it?.summary
            tvCompanyFounder.text = it?.founder
            tvCompanyCeo.text = it?.ceo
            tvCompanyCoo.text = it?.coo
            tvCompanyHeadquarters.text = it?.headquarters?.city
            tvCompanyWebsites.text = it?.links?.website
        }
    }
}