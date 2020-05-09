package bot.box.covidtracker.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import bot.box.covidtracker.databinding.ItemDailyStatsBinding
import bot.box.domain.common.inNumeric
import bot.box.domain.model.CovidDaily

class DailyStatsAdapter : RecyclerView.Adapter<DailyStatsAdapter.ViewHolder>() {
    private var mDailyStats: List<CovidDaily>? = null
    private lateinit var mBinding: ItemDailyStatsBinding
    private var maxCount = 0

    fun refreshData(mStats: List<CovidDaily>) {
        this.mDailyStats = mStats
        maxCount = mStats.maxWith(Comparator { o1, o2 ->
            o1.dailyconfirmed.inNumeric.compareTo(o2.dailyconfirmed.inNumeric)
        })?.dailyconfirmed!!.inNumeric
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder =
        ViewHolder(ItemDailyStatsBinding.inflate(LayoutInflater.from(parent.context)).also {
            mBinding = it
        })

    override fun getItemCount(): Int = mDailyStats?.size ?: 0
    override fun getItemId(position: Int): Long = position.toLong()
    override fun getItemViewType(position: Int) = position


    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        mBinding.daily = mDailyStats?.get(position)
        mBinding.adapterPosition = position + 1
        mBinding.maxCount = maxCount
        mBinding.total = mDailyStats?.size
    }

    class ViewHolder(binding: ItemDailyStatsBinding) : RecyclerView.ViewHolder(binding.root)
}