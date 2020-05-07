package bot.box.covidtracker.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import bot.box.covidtracker.databinding.FragmentHomeBinding
import bot.box.covidtracker.ui.viewmodel.HomeViewModel
import io.reactivex.Observable
import org.koin.androidx.viewmodel.ext.android.sharedViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

typealias _OBSERVER<T> = Observer<T>

class HomeFragment : Fragment() {
    private lateinit var mBinding: FragmentHomeBinding
    private val mViewModel by sharedViewModel<HomeViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return FragmentHomeBinding.inflate(inflater).also {
            mBinding = it
            mBinding.viewModel = mViewModel
            mBinding.lifecycleOwner = this
        }.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        mViewModel.getCovidData()
        mViewModel._mData.observe(viewLifecycleOwner, _OBSERVER {

        })
    }
}