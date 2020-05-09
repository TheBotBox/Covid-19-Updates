package bot.box.covidtracker.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import bot.box.covidtracker.databinding.ItemUpdatesBinding
import bot.box.domain.model.UpdateResponse

class UpdateAdapter : RecyclerView.Adapter<UpdateAdapter.ViewHolder>() {
    private var mUpdates: List<UpdateResponse>? = null
    private lateinit var mBinding: ItemUpdatesBinding

    fun refreshData(mStats: List<UpdateResponse>) {
        this.mUpdates = mStats
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder =
        ViewHolder(ItemUpdatesBinding.inflate(LayoutInflater.from(parent.context)).also {
            mBinding = it
        })

    override fun getItemCount(): Int = mUpdates?.size ?: 0
    override fun getItemId(position: Int) = position.toLong()
    override fun getItemViewType(position: Int) = position

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        mBinding.notification = mUpdates?.get(position)
    }

    class ViewHolder(binding: ItemUpdatesBinding) : RecyclerView.ViewHolder(binding.root)
}
