package bot.box.covidtracker.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import bot.box.covidtracker.R
import bot.box.covidtracker.databinding.FragmentUpdatesBinding
import bot.box.covidtracker.ui.adapter.UpdateAdapter
import bot.box.covidtracker.ui.viewmodel.HomeViewModel
import bot.box.covidtracker.util.LAZY
import bot.box.covidtracker.util._OBSERVER
import kotlinx.android.synthetic.main.fragment_home.*
import org.koin.androidx.viewmodel.ext.android.sharedViewModel

class UpdateFragment : Fragment() {
    private lateinit var mBinding: FragmentUpdatesBinding
    private val mViewModel by sharedViewModel<HomeViewModel>()
    private val mAdapter by lazy(LAZY.NONE) { UpdateAdapter() }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return FragmentUpdatesBinding.inflate(inflater).apply {
            lifecycleOwner = this@UpdateFragment
            viewModel = mViewModel
            mRecyclerView.adapter = mAdapter
            mBinding = this
        }.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        mViewModel.getUpdates()
        mBinding.swipeRefresh.setOnRefreshListener { mViewModel.getUpdates() }
        mViewModel._covidUpdates.observe(viewLifecycleOwner, _OBSERVER {
            if (mBinding.swipeRefresh.isRefreshing) mBinding.swipeRefresh.isRefreshing = false
            mAdapter.refreshData(it)
        })
    }
}