package bot.box.covidtracker.ui.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.app.AppCompatDelegate
import androidx.databinding.DataBindingUtil
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.ui.setupWithNavController
import bot.box.covidtracker.R
import bot.box.covidtracker.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var mNavController: NavController
    private lateinit var mBinding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        DataBindingUtil.setContentView<ActivityMainBinding>(this, R.layout.activity_main).also {
            mBinding = it
        }

        mNavController = findNavController(R.id.navigationHost)
        mBinding.bottomNavigation.setupWithNavController(mNavController)
    }
}
