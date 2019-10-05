package com.groundzero.gloriapatri.features.prayers.ui.content

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.AnimationUtils
import androidx.navigation.findNavController
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.SCROLL_STATE_DRAGGING
import com.groundzero.gloriapatri.R
import com.groundzero.gloriapatri.data.prayers.Prayer
import com.groundzero.gloriapatri.databinding.ItemPrayersBinding
import com.groundzero.gloriapatri.features.singleprayer.SinglePrayerFragmentArgs
import com.groundzero.gloriapatri.utils.navAnimOption


class PrayerContentAdapter(private val listener: ScrollingListener) :
    ListAdapter<Prayer, PrayerContentAdapter.ViewHolder>(
        DiffCallback()
    ) {

    private lateinit var context: Context
    private var latestPosition = -1

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        this.context = parent.context
        return ViewHolder(
            ItemPrayersBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.apply {
            bind(
                createOnClickListener(getItem(position).prayerId),
                getItem(position),
                position
            )
        }
        if (listener.getRecyclerScrollState() == SCROLL_STATE_DRAGGING)
            setAnimation(holder.itemView, position)
    }

    private fun setAnimation(viewToAnimate: View, position: Int) {
        val anim = if (position > latestPosition) R.anim.slide_up else R.anim.slide_down
        val animation = AnimationUtils.loadAnimation(context, anim)
        viewToAnimate.startAnimation(animation)
        latestPosition = position
    }

    /**
     * Passing the prayerId to next fragment. Object will be fetched from local
     * database with this id
     */
    private fun createOnClickListener(prayerId: String) = View.OnClickListener {
        it.findNavController().apply {
            val args = SinglePrayerFragmentArgs.Builder(prayerId).build().toBundle()

            navigate(
                R.id.singlePrayerFragment,
                args,
                navAnimOption(R.anim.fade_in, R.anim.fade_out)
            )
        }
    }

    class ViewHolder(private val binding: ItemPrayersBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(itemClickListener: View.OnClickListener, prayer: Prayer, position: Int) {
            binding.prayer = prayer
            binding.listIndex = position + 1
            binding.itemClickListener = itemClickListener
        }
    }

    private class DiffCallback : DiffUtil.ItemCallback<Prayer>() {
        override fun areItemsTheSame(oldItem: Prayer, newItem: Prayer): Boolean = oldItem == newItem
        override fun areContentsTheSame(oldItem: Prayer, newItem: Prayer): Boolean =
            oldItem.prayerId == newItem.prayerId
    }
}