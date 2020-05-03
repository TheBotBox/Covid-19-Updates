package bot.box.covidtracker.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import bot.box.covidtracker.R
import bot.box.covidtracker.databinding.FragmentStateListBinding

class StateListFragment : Fragment() {
    private lateinit var mBinding: FragmentStateListBinding
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return DataBindingUtil.inflate<FragmentStateListBinding>(
            inflater, R.layout.fragment_state_list, container, false
        ).also { mBinding = it }.root
    }
}