package bot.box.covidtracker.util.extension

import android.app.Activity
import android.app.ProgressDialog


fun Activity.getProgressDialog(): ProgressDialog {
    return ProgressDialog(this).apply {
        setCancelable(false)
        setMessage("Please Wait...")
    }
}
