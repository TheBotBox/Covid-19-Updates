package bot.box.covidtracker.ui.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.ui.setupWithNavController
import bot.box.covidtracker.R
import bot.box.covidtracker.databinding.ActivityMainBinding
import bot.box.covidtracker.ui.viewmodel.HomeViewModel
import bot.box.covidtracker.util.LAZY
import bot.box.covidtracker.util.extension.getProgressDialog
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : AppCompatActivity() {

    private lateinit var mNavController: NavController
    private lateinit var mBinding: ActivityMainBinding
    private val mViewModel by viewModel<HomeViewModel>()
    private val mProgressDialog by lazy(LAZY.NONE) { getProgressDialog() }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        DataBindingUtil.setContentView<ActivityMainBinding>(this, R.layout.activity_main).also {
            mBinding = it
        }

        mNavController = findNavController(R.id.navigationHost)
        mBinding.bottomNavigation.setupWithNavController(mNavController)

        mViewModel.mConnectionStatus =
            { if (it) mProgressDialog.show() else mProgressDialog.dismiss() }
    }
}

