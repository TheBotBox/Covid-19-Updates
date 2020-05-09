package bot.box.covidtracker.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import bot.box.covidtracker.databinding.FragmentHomeBinding
import bot.box.covidtracker.ui.adapter.DailyStatsAdapter
import bot.box.covidtracker.ui.viewmodel.HomeViewModel
import bot.box.covidtracker.util.LAZY
import bot.box.covidtracker.util._OBSERVER
import bot.box.covidtracker.util.extension.getProgressDialog
import org.koin.androidx.viewmodel.ext.android.sharedViewModel

class HomeFragment : Fragment() {
    private lateinit var mBinding: FragmentHomeBinding
    private val mViewModel by sharedViewModel<HomeViewModel>()
    private val mAdapter: DailyStatsAdapter by lazy(LAZY.NONE) { DailyStatsAdapter() }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return FragmentHomeBinding.inflate(inflater).apply {
            lifecycleOwner = viewLifecycleOwner
            viewModel = mViewModel
            mRecyclerView.adapter = mAdapter
            mBinding = this
        }.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        mViewModel.getCovidData()
        mBinding.swipeRefresh.setOnRefreshListener { mViewModel.getCovidData() }

        mViewModel._covidDaily.observe(viewLifecycleOwner, _OBSERVER {
            if (mBinding.swipeRefresh.isRefreshing) mBinding.swipeRefresh.isRefreshing = false
            mAdapter.refreshData(it)
        })
    }
}