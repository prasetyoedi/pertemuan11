package com.example.pertemuan11
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.pertemuan11.databinding.ItemBitcoinBinding
import com.example.pertemuan11.model.Data
import com.squareup.picasso.Picasso

class BitcoinAdapter(private var listBitcoin: List<Data>) :
    RecyclerView.Adapter<BitcoinAdapter.ItemHeroViewHolder>() {

    inner class ItemHeroViewHolder(private val binding: ItemBitcoinBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(data: Data) {
            with(binding) {
                idBitcoin.text = data.bitcoinId.toString()
                accountcodeBitcoin.text = data.bitcoinCode
                namaHero.text = data.bitcoinName

                Picasso.get()
                    .load(data.bitcoinLogo)
                    .error(R.drawable.default_bitcoins)
                    .into(bitcoinLogo)
            }
        }
    }

    fun setDataHero(newData: List<Data>) {
        listBitcoin = newData
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemHeroViewHolder {
        val binding = ItemBitcoinBinding.inflate(
            LayoutInflater.from(parent.context),
            parent, false
        )
        return ItemHeroViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ItemHeroViewHolder, position: Int) {
        holder.bind(listBitcoin[position])
    }

    override fun getItemCount(): Int = listBitcoin.size
}